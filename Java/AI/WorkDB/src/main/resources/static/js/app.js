const API_BASE_URL = '/api/books';

let books = [];
let currentEditingId = null;

document.addEventListener('DOMContentLoaded', function() {
    loadBooks();
    loadGenres();
    setupEventListeners();
});

function setupEventListeners() {

    document.getElementById('bookForm').addEventListener('submit', handleFormSubmit);
    document.getElementById('cancelBtn').addEventListener('click', resetForm);
    document.getElementById('clearFormBtn').addEventListener('click', resetForm);


    document.getElementById('searchAuthorBtn').addEventListener('click', searchByAuthor);
    document.getElementById('searchTitleBtn').addEventListener('click', searchByTitle);
    document.getElementById('searchGenreBtn').addEventListener('click', searchByGenre);


    document.getElementById('showAllBtn').addEventListener('click', loadBooks);
    document.getElementById('loadGenresBtn').addEventListener('click', loadGenres);
    document.getElementById('refreshBtn').addEventListener('click', loadBooks);


    document.getElementById('searchAuthor').addEventListener('keypress', function(e) {
        if (e.key === 'Enter') searchByAuthor();
    });

    document.getElementById('searchTitle').addEventListener('keypress', function(e) {
        if (e.key === 'Enter') searchByTitle();
    });
    document.getElementById('refreshListBtn').addEventListener('click', loadBooks);
}
function displayBooks(booksToDisplay) {
    const container = document.getElementById('booksList');
    const countElement = document.getElementById('booksCount');

    countElement.textContent = booksToDisplay.length;

    if (booksToDisplay.length === 0) {
        container.innerHTML = `
            <div class="no-data">
                <div>Книги не найдены</div>
                <div style="margin-top: 10px; font-size: 0.9rem;">Попробуйте изменить параметры поиска</div>
            </div>
        `;
        return;
    }

    container.innerHTML = booksToDisplay.map(book => `
        <div class="book-card" data-id="${book.id}">
            <div class="book-header">
                <div class="book-title">${escapeHtml(book.title)}</div>
            </div>
            <div class="book-author">${escapeHtml(book.author)}</div>
            ${book.description ? `<div class="book-description">${escapeHtml(book.description)}</div>` : ''}
            <div class="book-details">
                ${book.isbn ? `<div class="book-detail"><strong>ISBN:</strong> ${escapeHtml(book.isbn)}</div>` : ''}
                ${book.publicationYear ? `<div class="book-detail"><strong>Год:</strong> ${book.publicationYear}</div>` : ''}
                ${book.genre ? `<div class="book-detail"><strong>Жанр:</strong> ${escapeHtml(book.genre)}</div>` : ''}
                ${book.publisher ? `<div class="book-detail"><strong>Издатель:</strong> ${escapeHtml(book.publisher)}</div>` : ''}
                ${book.pageCount ? `<div class="book-detail"><strong>Страниц:</strong> ${book.pageCount}</div>` : ''}
            </div>
            <div class="book-meta">
                <div class="book-date">
                    <small>Добавлено: ${formatDateTime(book.createdAt)}</small>
                    ${book.updatedAt !== book.createdAt ?
        `<br><small>Обновлено: ${formatDateTime(book.updatedAt)}</small>` : ''}
                </div>
                <div class="book-actions">
                    <button class="btn btn-edit" onclick="editBook(${book.id})">
                        <span class="btn-icon">✏️</span>
                        <span class="btn-text">Изменить</span>
                    </button>
                    <button class="btn btn-delete" onclick="deleteBook(${book.id})">
                        <span class="btn-icon">🗑️</span>
                        <span class="btn-text">Удалить</span>
                    </button>
                </div>
            </div>
        </div>
    `).join('');
}

// Добавьте анимацию появления карточек
function animateCards() {
    const cards = document.querySelectorAll('.book-card');
    cards.forEach((card, index) => {
        card.style.opacity = '0';
        card.style.transform = 'translateY(20px)';
        setTimeout(() => {
            card.style.transition = 'all 0.5s ease';
            card.style.opacity = '1';
            card.style.transform = 'translateY(0)';
        }, index * 100);
    });
}

async function handleFormSubmit(event) {
    event.preventDefault();

    const formData = getFormData();
    if (!validateForm(formData)) return;

    try {
        if (currentEditingId) {
            await updateBook(currentEditingId, formData);
        } else {
            await createBook(formData);
        }
    } catch (error) {
        showError('Ошибка: ' + error.message);
    }
}

function getFormData() {
    return {
        title: document.getElementById('title').value.trim(),
        author: document.getElementById('author').value.trim(),
        isbn: document.getElementById('isbn').value.trim(),
        publicationYear: document.getElementById('publicationYear').value ?
            parseInt(document.getElementById('publicationYear').value) : null,
        genre: document.getElementById('genre').value.trim(),
        publisher: document.getElementById('publisher').value.trim(),
        description: document.getElementById('description').value.trim(),
        pageCount: document.getElementById('pageCount').value ?
            parseInt(document.getElementById('pageCount').value) : null
    };
}

function validateForm(data) {
    if (!data.title) {
        showError('Название книги обязательно для заполнения');
        document.getElementById('title').focus();
        return false;
    }

    if (!data.author) {
        showError('Автор книги обязателен для заполнения');
        document.getElementById('author').focus();
        return false;
    }

    if (data.publicationYear && (data.publicationYear < 1000 || data.publicationYear > new Date().getFullYear() + 1)) {
        showError('Год издания должен быть реалистичным');
        document.getElementById('publicationYear').focus();
        return false;
    }

    if (data.pageCount && data.pageCount <= 0) {
        showError('Количество страниц должно быть положительным числом');
        document.getElementById('pageCount').focus();
        return false;
    }

    return true;
}

async function loadBooks() {
    showLoading();
    hideMessages();
    clearSearchFields();

    try {
        const response = await fetch(API_BASE_URL);
        if (!response.ok) throw new Error('Ошибка загрузки данных');

        books = await response.json();
        displayBooks(books);
        updateStatistics();
        showSuccess(`Загружено ${books.length} книг`);
    } catch (error) {
        showError('Ошибка при загрузке книг: ' + error.message);
    } finally {
        hideLoading();
    }
}

function displayBooks(booksToDisplay) {
    const container = document.getElementById('booksList');
    const countElement = document.getElementById('booksCount');

    countElement.textContent = booksToDisplay.length;

    if (booksToDisplay.length === 0) {
        container.innerHTML = '<div class="no-data">Книги не найдены</div>';
        return;
    }

    container.innerHTML = booksToDisplay.map(book => `
        <div class="book-card" data-id="${book.id}">
            <div class="book-info">
                <h3>${escapeHtml(book.title)}</h3>
                <div class="book-author">${escapeHtml(book.author)}</div>
                ${book.description ? `<div class="book-description">${escapeHtml(book.description)}</div>` : ''}
                <div class="book-details">
                    ${book.isbn ? `<div class="detail"><strong>ISBN:</strong> ${escapeHtml(book.isbn)}</div>` : ''}
                    ${book.publicationYear ? `<div class="detail"><strong>Год:</strong> ${book.publicationYear}</div>` : ''}
                    ${book.genre ? `<div class="detail"><strong>Жанр:</strong> ${escapeHtml(book.genre)}</div>` : ''}
                    ${book.publisher ? `<div class="detail"><strong>Издатель:</strong> ${escapeHtml(book.publisher)}</div>` : ''}
                    ${book.pageCount ? `<div class="detail"><strong>Страниц:</strong> ${book.pageCount}</div>` : ''}
                </div>
                <div class="book-meta">
                    <small>Добавлено: ${formatDateTime(book.createdAt)}</small>
                    ${book.updatedAt !== book.createdAt ?
        `<small>Обновлено: ${formatDateTime(book.updatedAt)}</small>` : ''}
                </div>
            </div>
            <div class="book-actions">
                <button class="btn-edit" onclick="editBook(${book.id})">✏️ Редактировать</button>
                <button class="btn-delete" onclick="deleteBook(${book.id})">🗑️ Удалить</button>
            </div>
        </div>
    `).join('');
}

async function createBook(bookData) {
    const response = await fetch(API_BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(bookData)
    });

    if (!response.ok) {
        const errorText = await response.text();
        throw new Error(errorText);
    }

    const createdBook = await response.json();
    resetForm();
    loadBooks();
    showSuccess(`Книга "${createdBook.title}" успешно добавлена!`);
}

async function editBook(id) {
    const book = books.find(b => b.id === id);
    if (!book) return;

    currentEditingId = id;

    document.getElementById('title').value = book.title;
    document.getElementById('author').value = book.author;
    document.getElementById('isbn').value = book.isbn || '';
    document.getElementById('publicationYear').value = book.publicationYear || '';
    document.getElementById('genre').value = book.genre || '';
    document.getElementById('publisher').value = book.publisher || '';
    document.getElementById('description').value = book.description || '';
    document.getElementById('pageCount').value = book.pageCount || '';

    document.getElementById('formTitle').textContent = 'Редактировать книгу';
    document.getElementById('submitBtn').textContent = 'Обновить книгу';
    document.getElementById('cancelBtn').style.display = 'inline-block';

    document.getElementById('bookForm').scrollIntoView({ behavior: 'smooth' });
}

async function updateBook(id, bookData) {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(bookData)
    });

    if (!response.ok) {
        const errorText = await response.text();
        throw new Error(errorText);
    }

    const updatedBook = await response.json();
    resetForm();
    loadBooks();
    showSuccess(`Книга "${updatedBook.title}" успешно обновлена!`);
}

async function deleteBook(id) {
    const book = books.find(b => b.id === id);
    if (!book) return;

    if (!confirm(`Вы уверены, что хотите удалить книгу "${book.title}"?`)) {
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/${id}`, {
            method: 'DELETE'
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(errorText);
        }

        loadBooks();
        showSuccess(`Книга "${book.title}" успешно удалена!`);
    } catch (error) {
        showError('Ошибка при удалении книги: ' + error.message);
    }
}

async function searchByAuthor() {
    const author = document.getElementById('searchAuthor').value.trim();
    if (!author) {
        showError('Введите автора для поиска');
        return;
    }

    showLoading();

    try {
        const response = await fetch(`${API_BASE_URL}/search/author?author=${encodeURIComponent(author)}`);
        if (!response.ok) throw new Error('Ошибка поиска');

        const foundBooks = await response.json();
        displayBooks(foundBooks);
        showSuccess(`Найдено ${foundBooks.length} книг автора "${author}"`);
    } catch (error) {
        showError('Ошибка при поиске: ' + error.message);
    } finally {
        hideLoading();
    }
}

async function searchByTitle() {
    const title = document.getElementById('searchTitle').value.trim();
    if (!title) {
        showError('Введите название для поиска');
        return;
    }

    showLoading();

    try {
        const response = await fetch(`${API_BASE_URL}/search/title?title=${encodeURIComponent(title)}`);
        if (!response.ok) throw new Error('Ошибка поиска');

        const foundBooks = await response.json();
        displayBooks(foundBooks);
        showSuccess(`Найдено ${foundBooks.length} книг с названием "${title}"`);
    } catch (error) {
        showError('Ошибка при поиске: ' + error.message);
    } finally {
        hideLoading();
    }
}

async function searchByGenre() {
    const genre = document.getElementById('searchGenre').value;
    if (!genre) {
        showError('Выберите жанр для поиска');
        return;
    }

    showLoading();

    try {
        const response = await fetch(`${API_BASE_URL}/search/genre?genre=${encodeURIComponent(genre)}`);
        if (!response.ok) throw new Error('Ошибка поиска');

        const foundBooks = await response.json();
        displayBooks(foundBooks);
        showSuccess(`Найдено ${foundBooks.length} книг в жанре "${genre}"`);
    } catch (error) {
        showError('Ошибка при поиске: ' + error.message);
    } finally {
        hideLoading();
    }
}

async function loadGenres() {
    try {
        const response = await fetch(`${API_BASE_URL}/genres`);
        if (response.ok) {
            const genres = await response.json();
            const select = document.getElementById('searchGenre');
            select.innerHTML = '<option value="">Выберите жанр</option>' +
                genres.map(genre => `<option value="${escapeHtml(genre)}">${escapeHtml(genre)}</option>`).join('');
            showSuccess(`Загружено ${genres.length} жанров`);
        }
    } catch (error) {
        console.error('Ошибка загрузки жанров:', error);
    }
}

function resetForm() {
    document.getElementById('bookForm').reset();
    currentEditingId = null;

    document.getElementById('formTitle').textContent = 'Добавить новую книгу';
    document.getElementById('submitBtn').textContent = 'Добавить книгу';
    document.getElementById('cancelBtn').style.display = 'none';

    showSuccess('Форма очищена');
}

function clearSearchFields() {
    document.getElementById('searchAuthor').value = '';
    document.getElementById('searchTitle').value = '';
    document.getElementById('searchGenre').value = '';
}

function updateStatistics() {
    const genres = [...new Set(books.filter(b => b.genre).map(b => b.genre))];
    const authors = [...new Set(books.map(b => b.author))];

    document.getElementById('totalBooks').textContent = books.length;
    document.getElementById('totalGenres').textContent = genres.length;
    document.getElementById('totalAuthors').textContent = authors.length;
}

function formatDateTime(dateString) {
    if (!dateString) return 'Не указано';
    const date = new Date(dateString);
    return date.toLocaleDateString('ru-RU') + ' ' + date.toLocaleTimeString('ru-RU', {
        hour: '2-digit',
        minute: '2-digit'
    });
}

function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}

function showLoading() {
    document.getElementById('loading').style.display = 'block';
}

function hideLoading() {
    document.getElementById('loading').style.display = 'none';
}

function showError(message) {
    const errorElement = document.getElementById('error');
    errorElement.textContent = message;
    errorElement.style.display = 'block';
    setTimeout(() => errorElement.style.display = 'none', 5000);
}

function showSuccess(message) {
    const successElement = document.getElementById('success');
    successElement.textContent = message;
    successElement.style.display = 'block';
    setTimeout(() => successElement.style.display = 'none', 3000);
}

function hideMessages() {
    document.getElementById('error').style.display = 'none';
    document.getElementById('success').style.display = 'none';
}

window.editBook = editBook;
window.deleteBook = deleteBook;