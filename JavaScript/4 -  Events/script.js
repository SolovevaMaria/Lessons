//  let count = prompt("Укажите количество квадратов (min=5 , max=100): ")
//  document.querySelector('.left').innerHTML = " Количество кубиков: "+ count

//  let time = prompt("Укажите время, за которое хотите пройти уровень : 30сек, 1мин, 5мин, 15мин,30мин")
//  document.querySelector('.right').innerHTML = " Оставшееся время: "+ time




// //цвет внутри фигурки для всех фигурок
//  function getRandomColor() {
//      var letters = '0123456789ABCDEF';
//      var color = '#';
//      for (var i = 0; i < 6; i++) {
//          color += letters[Math.floor(Math.random() * 16)];
//      }
//      return color;
//  }

//  var box = document.querySelector('.box');
//  box.style.backgroundColor = getRandomColor();

// /////////////////


// //добавляет кубики по count
// let blocks = [];

// for (let i = 0; i < count; i++) {
//     const box = document.createElement('div');
//     box.classList.add('box');
//     box.innerText = i + 1; // Number the boxes

//     // Set random initial position
//     box.style.left = Math.random() * (gameContainer.offsetWidth - 100) + 'px';
//     box.style.top = Math.random() * (gameContainer.offsetHeight - 100) + 'px';
//     box.style.backgroundColor = getRandomColor();

//     //Add click event to remove the box
//       box.addEventListener('click', () => {
//               box.remove();
//               blocks = blocks.filter(b => b !== box); // Remove from blocks array
//           });

//     gameContainer.appendChild(box);
//     blocks.push(box); // Add to blocks array
// }





// //Удаляет кубики при нажатии на них
//  let boxs = document.querySelectorAll('.box');
//  for (let i = 0; i < boxs.length; i++) {
//  boxs[i].addEventListener('click', () => {
//   let num = parseInt(boxs[i].innerText);
//     num--;
//       if (num == 0) {
//               boxs[i].remove();
//           }
//           boxs[i].innerText = num;
//       });
//   }


// //ТАЙМЕР равен тому которое указал пользователь идет обратный отчет минуты:секунды




// //движение фигурок все фигурки должны двигаться рандомно и неприрывно вверх вниз вправо лево по диагонали
// function moveBox(box){
//    const speed = 2;
//    let dx = (Math.random() - 0.5) * speed;
//    let dy = (Math.random() - 0.5) * speed;

//    function updatePosition(){
//        let x = parseFloat(box.style.left);
//        let y = parseFloat(box.style.top);

//        x += dx;
//        y += dy;

//        if(x < 0 || x > gameContainer.offsetWidth -100){
//            dx = -dx;
//        }
//        if(y < 0 || y > gameContainer.offsetHeight - 100){
//            dy = -dy;
//        }
//        box.style.left = x + 'px';
//        box.style.top = y + 'px';

//        requestAnimationFrame(updatePosition);

//    }
//    updatePosition();
// }
// // Add movement to the blocks
// blocks.forEach(block => moveBox(block));

////////////////////////////////////////
// Объявляем переменные и находим нужные элементы на странице
const leftDisplay = document.querySelector('.left'); // Элемент для отображения количества кубиков
const rightDisplay = document.querySelector('.right'); // Элемент для отображения времени
const gameContainer = document.getElementById('game-container'); // Игровое поле

// Получаем от пользователя количество кубиков и время на игру
let count = prompt("Укажите количество кубиков (min=5 , max=100): "); // Запрашиваем количество кубиков
let timeInput = prompt("Укажите время, за которое хотите пройти уровень: 30сек, 1мин, 5мин, 15мин, 30мин"); // Запрашиваем время

// Проверяем корректность введенных данных
count = parseInt(count); // Преобразуем введенное значение в число
if (isNaN(count) || count < 5 || count > 100) { // Проверяем, что число в допустимом диапазоне
    alert("Некорректный ввод количества кубиков. Будет создано 25 кубиков.");
    count = 25; // Если ввод некорректный, устанавливаем значение по умолчанию
}

// Преобразуем введенное время в секунды
let timeLeft = 0; // Переменная для хранения времени в секундах
if (timeInput === "30сек") {
    timeLeft = 30;
} else if (timeInput === "1мин") {
    timeLeft = 60;
} else if (timeInput === "5мин") {
    timeLeft = 300;
} else if (timeInput === "15мин") {
    timeLeft = 900;
} else if (timeInput === "30мин") {
    timeLeft = 1800;
} else {
    alert("Некорректный ввод времени. Установлено 30 секунд.");
    timeLeft = 30;
}

// Отображаем количество кубиков и время на странице
leftDisplay.innerHTML = " Количество кубиков: " + count; // Выводим количество кубиков
rightDisplay.innerHTML = " Оставшееся время: " + formatTime(timeLeft); // Выводим время

// Функция для форматирования времени в формат "минуты:секунды"
function formatTime(seconds) {
    const minutes = Math.floor(seconds / 60); // Вычисляем количество минут
    const remainingSeconds = seconds % 60; // Вычисляем количество оставшихся секунд
    const formattedMinutes = String(minutes).padStart(2, '0'); // Форматируем минуты (добавляем 0 в начало, если нужно)
    const formattedSeconds = String(remainingSeconds).padStart(2, '0'); // Форматируем секунды (добавляем 0 в начало, если нужно)
    return `${formattedMinutes}:${formattedSeconds}`; // Возвращаем отформатированную строку
}

// Функция для генерации случайного цвета
function getRandomColor() {
    var letters = '0123456789ABCDEF'; // Символы для шестнадцатеричного кода цвета
    var color = '#'; // Начинаем код цвета с символа '#'
    for (var i = 0; i < 6; i++) { // Шестнадцатеричный код цвета состоит из 6 символов
        color += letters[Math.floor(Math.random() * 16)]; // Добавляем случайный символ к коду цвета
    }
    return color; // Возвращаем случайный код цвета
}

// Выполняем код после полной загрузки страницы
window.onload = function() {
    const boxSize = 100;  // Размер кубика
    const minDistance = 50; // Минимальное расстояние между кубиками
    let blockPositions = []; // Массив для хранения координат кубиков

    // Функция для проверки, перекрывает ли новая позиция существующие кубики
    function checkOverlap(x, y) {
        let newRect = { // Создаем объект, описывающий границы нового кубика
            x: x, // Координата X левого верхнего угла
            y: y, // Координата Y левого верхнего угла
            width: boxSize, // Ширина кубика
            height: boxSize // Высота кубика
        };

        for (let i = 0; i < blockPositions.length; i++) { // Перебираем все существующие кубики
            let existingRect = blockPositions[i]; // Получаем координаты текущего кубика

            // Проверяем, накладывается ли новый кубик на существующий
            if (!(newRect.x + newRect.width < existingRect.x || // Новый кубик находится правее существующего
                  newRect.x > existingRect.x + existingRect.width || // Новый кубик находится левее существующего
                  newRect.y + newRect.height < existingRect.y || // Новый кубик находится ниже существующего
                  newRect.y > existingRect.y + existingRect.height)) { // Новый кубик находится выше существующего
                return true; // Если условие не выполняется, значит, есть наложение
            }

            // Проверяем, находится ли новый кубик слишком близко к существующему
            let distance = Math.sqrt(Math.pow(newRect.x - existingRect.x, 2) + Math.pow(newRect.y - existingRect.y, 2)); // Вычисляем расстояние между кубиками
            if (distance < minDistance) { // Если расстояние меньше минимального
                return true; // Считаем, что есть перекрытие (слишком близко)
            }
        }
        return false; // Если перекрытий нет, возвращаем false
    }


    // Создаем кубики
    let blocks = []; // Массив для хранения кубиков

    for (let i = 0; i < count; i++) { // Создаем столько кубиков, сколько указал пользователь
        const box = document.createElement('div'); // Создаем новый элемент div (кубик)
        box.classList.add('box'); // Добавляем кубику класс 'box' (для стилизации)
        box.innerText = i + 1; // Нумеруем кубики (текст внутри кубика)

        // Ищем незанятое место для кубика
        let x, y; // Координаты кубика
        let overlap = true; // Флаг, показывающий, есть ли перекрытие
        let maxAttempts = 1000; // Максимальное количество попыток найти свободное место (чтобы не зависнуть)
        let attempts = 0; // Счетчик попыток

        while (overlap && attempts < maxAttempts) { // Пока есть перекрытие и не превышено максимальное количество попыток
            x = Math.random() * (gameContainer.offsetWidth - boxSize); // Генерируем случайную координату X
            y = Math.random() * (gameContainer.offsetHeight - boxSize); // Генерируем случайную координату Y
            overlap = checkOverlap(x, y); // Проверяем, нет ли перекрытия в этой позиции
            attempts++; // Увеличиваем счетчик попыток
        }

        if (attempts === maxAttempts) { // Если не удалось найти свободное место за заданное количество попыток
            console.warn("Не удалось найти незанятое место после " + maxAttempts + " попыток."); // Выводим предупреждение в консоль
            // Можно пропустить создание этого кубика или попробовать поставить его все равно
        }
        
        box.style.left = x + 'px'; // Устанавливаем координату X для кубика
        box.style.top = y + 'px'; // Устанавливаем координату Y для кубика
        box.style.backgroundColor = getRandomColor(); // Устанавливаем случайный цвет фона

        // Добавляем обработчик клика на кубик (чтобы его удалить)
        box.addEventListener('click', () => {
            box.remove(); // Удаляем кубик со страницы
            blocks = blocks.filter(b => b !== box); // Удаляем кубик из массива blocks
            // Удаляем информацию о позиции кубика
            blockPositions = blockPositions.filter(pos => pos.x !== x || pos.y !== y);
        });

        gameContainer.appendChild(box); // Добавляем кубик на игровое поле
        blocks.push(box); // Добавляем кубик в массив кубиков

        // Добавляем информацию о позиции кубика в массив
        blockPositions.push({ x: x, y: y, width: boxSize, height: boxSize });
    }


    // Запускаем движение кубиков
    blocks.forEach(block => moveBox(block));

    // Запускаем таймер
    let timerInterval = setInterval(() => {
        timeLeft--; // Уменьшаем оставшееся время на 1 секунду
        rightDisplay.innerHTML = " Оставшееся время: " + formatTime(timeLeft); // Отображаем оставшееся время

        if (timeLeft <= 0) { // Если время вышло
            clearInterval(timerInterval); // Останавливаем таймер
            alert("Время вышло! Вы проиграли!"); // Выводим сообщение о проигрыше
        }
        if (blocks.length === 0) { // Если все кубики удалены
            clearInterval(timerInterval); // Останавливаем таймер
            alert("Вы выиграли!"); // Выводим сообщение о выигрыше
        }
    }, 1000);

    // Функция для движения кубика
    function moveBox(box) {
        const speed = 2; // Скорость движения
        let dx = (Math.random() - 0.5) * speed; // Случайное направление по оси X
        let dy = (Math.random() - 0.5) * speed; // Случайное направление по оси Y

        function updatePosition() { // Функция для обновления позиции кубика
            let x = parseFloat(box.style.left); // Получаем текущую координату X
            let y = parseFloat(box.style.top); // Получаем текущую координату Y

            if (isNaN(x) || isNaN(y)) return; // Проверяем значения позиции

            x += dx; // Изменяем координату X
            y += dy; // Изменяем координату Y

            if (x < 0 || x > gameContainer.offsetWidth - 100) { // Если кубик уперся в левую или правую стенку
                dx = -dx; // Меняем направление по оси X на противоположное
            }
            if (y < 0 || y > gameContainer.offsetHeight - 100) { // Если кубик уперся в верхнюю или нижнюю стенку
                dy = -dy; // Меняем направление по оси Y на противоположное
            }
            box.style.left = x + 'px'; // Устанавливаем новую координату X
            box.style.top = y + 'px'; // Устанавливаем новую координату Y

            requestAnimationFrame(updatePosition); // Запускаем функцию снова для следующего кадра анимации

        }
        updatePosition(); // Запускаем функцию обновления позиции
    }
};