let myForm = document.forms.toDoForm;
let myList = document.querySelector('.my-list');
let errorText = document.querySelector('.error-text');
let btnDeleteAll = document.querySelector('#btnDeleteAll');
let btnSelectedRemove = document.querySelector('#btnSelectedRemove');
let selectedItems = [];
let doneItems = [];

function updateButtonsState() {
    btnDeleteAll.disabled = myList.children.length === 0;
    btnSelectedRemove.disabled = doneItems.length === 0;
     saveToLocalStorage();
}

function countDoneItems() {
    doneItems = Array.from(myList.querySelectorAll('.done-item'));
     saveToLocalStorage();
}

function saveToLocalStorage() {
    const items = Array.from(myList.children).map(item => {
        return {
            title: item.querySelector('.content').innerText,
            done: item.classList.contains('done-item'),
            selected: selectedItems.includes(item)
        };
    });
    localStorage.setItem('todoList', JSON.stringify(items));
}

function loadFromLocalStorage() {
    const items = JSON.parse(localStorage.getItem('todoList')) || [];
    items.forEach(item => {
        const newItem = `
            <div class="list-group-item list-group-item-action item ${item.done ? 'done-item' : ''}">
                <div class="content">
                    ${item.title}
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
        myList.innerHTML += newItem;
        if (item.selected) {
            selectedItems.push(myList.lastElementChild);
        }
    });
    countDoneItems();
    updateButtonsState();
}


btnDeleteAll.addEventListener('click', () => {
    myList.innerHTML = '';
    selectedItems = [];
    doneItems = [];
    updateButtonsState();
});

btnSelectedRemove.addEventListener('click', () => {
    doneItems.forEach(item => item.remove());
    doneItems = [];
    selectedItems = [];
    updateButtonsState();
});

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

window.addEventListener('load', () => {
    loadFromLocalStorage();
    updateButtonsState();
});
