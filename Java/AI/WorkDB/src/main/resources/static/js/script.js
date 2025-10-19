    //
    // $(document).ready(function() {
    //     loadBooks();
    //
    //     $('#addBookForm').on('submit', function(e) {
    //         e.preventDefault();
    //
    //         const book = {
    //             title: $('#title').val(),
    //             authorId: $('#authorId').val(),
    //             publicationDate: $('#publicationDate').val()
    //         };
    //
    //         $.post('/api/books', book)
    //             .done(function(newBook) {
    //                 $('#addBookForm')[0].reset();
    //                 loadBooks();
    //                 showMessage('success', 'Книга успешно добавлена');
    //             })
    //             .fail(function() {
    //                 showMessage('error', 'Ошибка при добавлении книги');
    //             });
    //     });
    //
    //     function loadBooks() {
    //         $.get('/api/books')
    //             .done(function(books) {
    //                 const tableBody = $('#booksTable tbody');
    //                 tableBody.empty();
    //
    //                 books.forEach(function(book) {
    //                     tableBody.append(`
    //                     <tr>
    //                         <td>${book.id}</td>
    //                         <td>${book.title}</td>
    //                         <td>${book.authorId}</td>
    //                         <td>${new Date(book.publicationDate).toLocaleDateString()}</td>
    //                         <td>
    //                             <button class="btn btn-primary btn-action"
    //                                     onclick="editBook(${book.id})">
    //                                 Редактировать
    //                             </button>
    //                             <button class="btn btn-danger btn-action"
    //                                     onclick="deleteBook(${book.id})">
    //                                 Удалить
    //                             </button>
    //                         </td>
    //                     </tr>
    //                 `);
    //                 });
    //             })
    //             .fail(function() {
    //                 showMessage('error', 'Ошибка при загрузке книг');
    //             });
    //     }
    //
    //     function deleteBook(id) {
    //         if (!confirm('Вы уверены, что хотите удалить книгу?')) return;
    //
    //         $.ajax({
    //             url: `/api/books/${id}`,
    //             method: 'DELETE'
    //         })
    //             .done(function() {
    //                 loadBooks();
    //                 showMessage('success', 'Книга успешно удалена');
    //             })
    //             .fail(function() {
    //                 showMessage('error', 'Ошибка при удалении книги');
    //             });
    //     }
    //
    //     function editBook(id) {
    //         $.get(`/api/books/${id}`)
    //             .done(function(book) {
    //                 showEditModal(book);
    //             })
    //             .fail(function() {
    //                 showMessage('error', 'Ошибка при загрузке данных книги');
    //             });
    //     }
    //
    //     function showEditModal(book) {
    //         const modal = `
    //         <div class="modal">
    //             <div class="modal-content">
    //                 <span class="close">&times;</span>
    //                 <h2>Редактирование книги</h2>
    //                 <form>
    //                     <input type="hidden" value="${book.id}">
    //                     <div class="form-group">
    //                         <label>Название</label>
    //                         <input type="text" value="${book.title}" required>
    //                     </div>
    //                     <div class="form-group">
    //                         <label>ID автора</label>
    //                         <input type="number" value="${book.authorId}" required>
    //                     </div>
    //                     <div class="form-group">
    //                         <label>Дата публикации</label>
    //                         <input type="date" value="${new Date(book.publicationDate).toISOString().substr(0, 10)}" required>
    //                     </div>
    //                     <button onclick="saveBook(event, this.parentElement.parentElement)" class="btn btn-primary">Сохранить</button>
    //                 </form>
    //             </div>
    //         </div>
    //     `;
    //
    //         $('body').append(modal);
    //
    //         $('.modal .close').on('click', function() {
    //             $('.modal').remove();
    //         });
    //     }
    //
    //     function saveBook(e, form) {
    //         e.preventDefault();
    //
    //         const bookId = form.querySelector('input[type="hidden"]').value;
    //         const bookData = {
    //             title: form.querySelector('input[type="text"]').value,
    //             authorId: form.querySelector('input[type="number"]').value,
    //             publicationDate: form.querySelector('input[type="date"]').value
    //         };
    //
    //         $.ajax({
    //             url: `/api/books/${bookId}`,
    //             method: 'PUT',
    //             data: bookData
    //         })
    //             .done(function() {
    //                 $('.modal').remove();
    //                 loadBooks();
    //                 showMessage('success', 'Книга успешно обновлена');
    //             })
    //             .fail(function() {
    //                 showMessage('error', 'Ошибка при сохранении изменений');
    //             });
    //     }
    //
    //     function showMessage(type, message) {
    //         const messageContainer = $('<div>')
    //             .addClass('message')
    //             .addClass(type)
    //             .text(message);
    //
    //         $('body').prepend(messageContainer);
    //
    //         setTimeout(function() {
    //             messageContainer.remove();
    //         }, 3000);
    //     }
    //
    //     $(document).on('click', '.modal', function(e) {
    //         if (e.target === this) {
    //             $(this).remove();
    //         }
    //     });
    //
    // });