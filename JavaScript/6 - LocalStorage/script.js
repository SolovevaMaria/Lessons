let myForm = document.forms.toDoForm;
let myList = document.querySelector('.my-list');
let errorText = document.querySelector('.error-text');
let btnDeleteAll = document.querySelector('#btnDeleteAll');
let btnSelectedRemove = document.querySelector('#btnSelectedRemove');
let selectedItems = [];
let doneItems = [];

// Функция для обновления состояния кнопок
function updateButtonsState() {
    btnDeleteAll.disabled = myList.children.length === 0;
    btnSelectedRemove.disabled = doneItems.length === 0;
}

// Функция для подсчета зеленых элементов
function countDoneItems() {
    doneItems = Array.from(myList.querySelectorAll('.done-item'));
}

// Обработка кнопки Delete All
btnDeleteAll.addEventListener('click', () => {
    myList.innerHTML = '';
    selectedItems = [];
    doneItems = [];
    updateButtonsState();
});

// Обработка кнопки Selected Remove
btnSelectedRemove.addEventListener('click', () => {
    doneItems.forEach(item => item.remove());
    doneItems = [];
    selectedItems = [];
    updateButtonsState();
});

// Обработка формы
myForm.addEventListener('submit', (event) => {
    event.preventDefault();
    
    let title = myForm.title.value;
    
    if (title && title.trim()) {
        myList.innerHTML += `
            <div class="list-group-item list-group-item-action item">
                <div class="content">
                    ${title}
                </div>
                <div class="btns">
                    <div class="done">
                        ✔
                    </div>
                    <div class="remove">
                        ❌
                    </div>
                </div>
            </div>
        `;
        updateButtonsState();
    } else {
        errorText.style.display = 'block';
    }
    
    myForm.reset();
});

// Обработка кликов в списке
myList.addEventListener('click', (event) => {
    if (event.target.classList.contains('remove')) {
        event.target.parentElement.parentElement.remove();
        countDoneItems();
        updateButtonsState();
    } else if (event.target.classList.contains('done')) {
        const item = event.target.parentElement.parentElement;
        item.classList.toggle('done-item');
        countDoneItems();
        updateButtonsState();
    } else if (event.target.classList.contains('content')) {
        const item = event.target.parentElement.parentElement;
        if (selectedItems.includes(item)) {
            selectedItems = selectedItems.filter(i => i !== item);
        } else {
            selectedItems.push(item);
        }
        updateButtonsState();
    }
});

// Инициализация состояния кнопок
updateButtonsState();
