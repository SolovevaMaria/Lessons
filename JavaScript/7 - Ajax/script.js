let baseUrl = 'http://www.omdbapi.com';
let apiKey = 'bfa687b2';

//получаем элементы
const searchForm = document.getElementById('searchForm');
const resultsContainer = document.querySelector('.list');
const paginationContainer = document.getElementById('pagination'); 

 
let currentSearchTitle = ''; 
let currentSearchType = ''; 
let currentPage = 1; 
const resultsPerPage = 10; 
let totalResults = 0; 

//функция  поиска
async function performSearch(title, type, page) {
    try {
        //запрос к апи
        const response = await fetch(`${baseUrl}?s=${title}&type=${type}&page=${page}&apikey=${apiKey}`);
        const data = await response.json();

        if (data.Response === 'True') {
            totalResults = parseInt(data.totalResults); 
            showResults(data.Search);
            renderPagination(totalResults, page);
        } else {
            //если есть ошибки то
            resultsContainer.innerHTML = '<p>Фильм не найден</p>';
            paginationContainer.innerHTML = ''; 
        }
    } catch (error) {
        console.error('Произошла ошибка:', error);
        resultsContainer.innerHTML = '<p>Ошибка при загрузке данных</p>';
        paginationContainer.innerHTML = ''; 
    }
}

//обработка формы
searchForm.addEventListener('submit', async (event) => {
    event.preventDefault();

    const title = searchForm.title.value;
    const type = searchForm.type.value;

    if (title && title.trim()) {
        currentSearchTitle = title; 
        currentSearchType = type; 
        currentPage = 1; 
        resultsContainer.innerHTML = ''; 
        paginationContainer.innerHTML = ''; 
        performSearch(title, type, 1); 
    }
});

//функция для результатов
function showResults(films) {
    if (!films || films.length === 0) {
        resultsContainer.innerHTML = '<p>Фильмы не найдены</p>';
        return;
    }

    resultsContainer.innerHTML = ''; 

// создание карточек к фильмам 
// (добавляются элеметы,которые должны отображаться 
// и кнопка для деталей)
    films.forEach((film, index) => {
        if (!film.imdbID) {
            console.error('imdbID отсутствует:', film);
            return;
        }
        const colDiv = document.createElement('div');
        colDiv.classList.add('col-md-4');

        const cardDiv = document.createElement('div');
        cardDiv.classList.add('card', 'mb-4');

        const cardBodyDiv = document.createElement('div');
        cardBodyDiv.classList.add('card-body', 'd-flex', 'flex-column');

        const dFlexDiv = document.createElement('div');
        dFlexDiv.classList.add('d-flex');

        const img = document.createElement('img');
        img.src = film.Poster;
        img.classList.add('card-img-left');
        

        const ml3Div = document.createElement('div');
        ml3Div.classList.add('ml-3');

        const typeP = document.createElement('p');
        typeP.classList.add('card-text');
        typeP.textContent = film.Type;

        const titleH5 = document.createElement('h5');
        titleH5.classList.add('card-title');
        titleH5.textContent = film.Title;

        const yearP = document.createElement('p');
        yearP.classList.add('card-text');
        yearP.textContent = film.Year;

        const justifyContentDiv = document.createElement('div');
        justifyContentDiv.classList.add('d-flex', 'justify-content-end');

        const detailsBtn = document.createElement('button');
        detailsBtn.classList.add('btn', 'btn-primary', 'mt-auto');
        detailsBtn.textContent = 'Details';

        detailsBtn.style.backgroundColor = 'rgb(166, 166, 166)'; 
        detailsBtn.style.color = 'white';       
        detailsBtn.style.border = 'none';              
        detailsBtn.style.transition = 'background-color 0.3s ease'; 

        detailsBtn.addEventListener('click', () => {
            console.log("Button clicked! imdbID:", film.imdbID);
            showDetails(film.imdbID);
        });

        detailsBtn.addEventListener('mouseenter', () => {
            detailsBtn.style.backgroundColor = 'rgb(99, 99, 99)'; 
        });

        detailsBtn.addEventListener('mouseleave', () => {
            detailsBtn.style.backgroundColor = 'rgb(166, 166, 166)'; 
        });

        detailsBtn.addEventListener('mousedown', () => {
            detailsBtn.style.boxShadow = 'inset 0 0 3px rgba(0,0,0,0.5)';
        });

        detailsBtn.addEventListener('mouseup', () => {
            detailsBtn.style.boxShadow = 'none';
        });

        ml3Div.appendChild(typeP);
        ml3Div.appendChild(titleH5);
        ml3Div.appendChild(yearP);

        dFlexDiv.appendChild(img);
        dFlexDiv.appendChild(ml3Div);

        justifyContentDiv.appendChild(detailsBtn);

        cardBodyDiv.appendChild(dFlexDiv);
        cardBodyDiv.appendChild(justifyContentDiv);

        cardDiv.appendChild(cardBodyDiv);
        colDiv.appendChild(cardDiv);

        if (index % 3 === 0) { 
            const rowDiv = document.createElement('div');
            rowDiv.classList.add('row');
            rowDiv.appendChild(colDiv);
            resultsContainer.appendChild(rowDiv);
        } else {
            const lastRow = resultsContainer.lastElementChild;
            if (lastRow && lastRow.classList.contains('row')) {
                lastRow.appendChild(colDiv);
            } else {
                const rowDiv = document.createElement('div');
                rowDiv.classList.add('row');
                rowDiv.appendChild(colDiv);
                resultsContainer.appendChild(rowDiv);
            }
        }
    });
}

//функция для деталей фильма (при на жатии на кнопку details)
async function showDetails(imdbID) {
    try {
        const response = await fetch(`${baseUrl}?i=${imdbID}&apikey=${apiKey}`);
        const filmDetails = await response.json();

        if (filmDetails.Response === 'True') {
            const modalContent = document.querySelector('.modal-content');

            const container = document.createElement('div');
            container.classList.add('details-container');

            const posterElement = document.createElement('img');
            posterElement.src = filmDetails.Poster;
            posterElement.alt = filmDetails.Title;
            posterElement.classList.add('modal-poster');
            container.appendChild(posterElement);

            const infoContainer = document.createElement('div');
            infoContainer.classList.add('movie-info');
            container.appendChild(infoContainer);

            infoContainer.innerHTML = `
                <div id="modal-title" class="clearfix">
                    <div class="detail-label">Title:</div>
                    <div class="detail-value">${filmDetails.Title}</div>
                </div>
                <div id="modal-released" class="clearfix">
                    <div class="detail-label">Released:</div>
                    <div class="detail-value">${filmDetails.Released}</div>
                </div>
                <div id="modal-genre" class="clearfix">
                    <div class="detail-label">Genre:</div>
                    <div class="detail-value">${filmDetails.Genre}</div>
                </div>
                <div id="modal-country" class="clearfix">
                    <div class="detail-label">Country:</div>
                    <div class="detail-value">${filmDetails.Country}</div>
                </div>
                <div id="modal-director" class="clearfix">
                    <div class="detail-label">Director:</div>
                    <div class="detail-value">${filmDetails.Director}</div>
                </div>
                <div id="modal-writer" class="clearfix">
                    <div class="detail-label">Writer:</div>
                    <div class="detail-value">${filmDetails.Writer}</div>
                </div>
                <div id="modal-actors" class="clearfix">
                    <div class="detail-label">Actors:</div>
                    <div class="detail-value">${filmDetails.Actors}</div>
                </div>
                <div id="modal-awards" class="clearfix">
                    <div class="detail-label">Awards:</div>
                    <div class="detail-value">${filmDetails.Awards}</div>
                </div>
            `;

            modalContent.innerHTML = '<span class="close">×</span>'; 
            modalContent.appendChild(container);

            const modal = document.getElementById('detailsModal');
            modal.style.display = 'block';

            //закрытие при нажатии на крестик
            const closeBtn = document.querySelector('.close');
            closeBtn.addEventListener('click', function() {
                modal.style.display = 'none';
            });

            window.addEventListener('click', function(event) {
                if (event.target === modal) {
                    modal.style.display = 'none';
                }
            });
        } else {
            console.error('Film details not found');
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

//функция для создания паггинации
function renderPagination(totalResults, currentPage) {
    //общее количество страниц
    const totalPages = Math.ceil(totalResults / resultsPerPage);
    paginationContainer.innerHTML = ''; 

    //список паггинации
    const paginationList = document.createElement('ul');
    paginationList.classList.add('pagination', 'justify-content-center');  

    function createPageItem(pageNumber, isActive, text = pageNumber) {
        //элемент списка
        const listItem = document.createElement('li');
        listItem.classList.add('page-item');
        if (isActive) {
            listItem.classList.add('active');
        }

        //ссылка
        const link = document.createElement('a');
        link.classList.add('page-link');
        link.href = '#';
        link.textContent = text;

          // Стили для цвета
        if (isActive) {
            link.style.color = 'rgb(99, 99, 99)'; 
            link.style.backgroundColor = '#f8f9fa';
            link.style.borderColor = '#dee2e6';
        } else {
            link.style.color = 'rgb(166, 166, 166)'; 
            link.style.borderColor = 'rgba(222, 226, 230, 1)';
        }

        //действия при клике
        link.addEventListener('click', (event) => {
            event.preventDefault();
            if (pageNumber !== currentPage) {
                currentPage = pageNumber;
                resultsContainer.innerHTML = '';
                performSearch(currentSearchTitle, currentSearchType, pageNumber);
            }
        });

        listItem.appendChild(link);
        return listItem;
    }

    if (currentPage > 1) {
        paginationList.appendChild(createPageItem(currentPage - 1, false, 'Previous'));
    }

    //для страниц
    if (totalPages <= 7 || currentPage <= 4) {
        paginationList.appendChild(createPageItem(1, currentPage === 1));
    } else {
        //если больше одной страницы
        paginationList.appendChild(createPageItem(1, false));
        if (currentPage > 4) {
            const dots = document.createElement('li');
            dots.classList.add('page-item', 'disabled');
            dots.innerHTML = '<span class="page-link">...</span>';
            paginationList.appendChild(dots);
        }
    }

    //отображает 7 страничек
    let startPage, endPage;
    if (totalPages <= 7) {
        startPage = 1;
        endPage = totalPages;
    } else {
        if (currentPage <= 4) {
            startPage = 1;
            endPage = 5;
        } else if (currentPage + 2 >= totalPages) {
            startPage = totalPages - 4;
            endPage = totalPages;
        } else {
            startPage = currentPage - 2;
            endPage = currentPage + 2;
        }
    }

    //цикл,который отображает страницы
    for (let i = startPage; i <= endPage; i++) {
        if (i !== 1 && i !== totalPages) {
             paginationList.appendChild(createPageItem(i, currentPage === i));
        }
    }

    //многотичия вместо цифорки
    if (totalPages > 7 && currentPage + 3 <= totalPages) {
        if (currentPage + 2 < totalPages -1) {
            const dots = document.createElement('li');
            dots.classList.add('page-item', 'disabled');
            dots.innerHTML = '<span class="page-link">...</span>';
            paginationList.appendChild(dots);
        }
    }

     if (totalPages > 1) {
        paginationList.appendChild(createPageItem(totalPages, currentPage === totalPages));
    }
    if (currentPage < totalPages) {
        paginationList.appendChild(createPageItem(currentPage + 1, false, 'Next'));
    }

    //добавляет готовый список 
    paginationContainer.appendChild(paginationList);
}
