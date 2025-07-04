const leftDisplay = document.querySelector(".left");
const rightDisplay = document.querySelector(".right");
const gameContainer = document.getElementById("game-container");

let count = prompt("Укажите количество кубиков (min=5 , max=100): ");
let timeInput = prompt("Укажите время, за которое хотите пройти уровень: 30сек, 1мин, 5мин, 15мин, 30мин");

count = parseInt(count);
if (isNaN(count) || count < 5 || count > 100) {
  alert("Некорректный ввод количества кубиков. Будет создано 25 кубиков.");
  count = 25;
}

let timeLeft = 0;
if (timeInput == "30сек" || timeInput == "30") {
  timeLeft = 30;
} else if (timeInput == "1" || timeInput == "1мин") {
  timeLeft = 60;
} else if (timeInput == "5" || timeInput == "5мин") {
  timeLeft = 300;
} else if (timeInput == "15" || timeInput == "15мин") {
  timeLeft = 900;
} else if (timeInput == "30мин" || timeInput == "30мин") {
  timeLeft = 1800;
} else {
  alert("Некорректный ввод времени. Установлено 30 секунд.");
  timeLeft = 30;
}

function updateCount(removed) {
  if (removed) {
    count--;
  }
  leftDisplay.innerHTML = "Количество кубиков: " + count;
}

leftDisplay.innerHTML = "Количество кубиков: " + count;
rightDisplay.innerHTML = "Оставшееся время: " + formatTime(timeLeft);

function formatTime(seconds) {
  const minutes = Math.floor(seconds / 60);
  const remainingSeconds = seconds % 60;
  const formattedMinutes = String(minutes).padStart(2, "0");
  const formattedSeconds = String(remainingSeconds).padStart(2, "0");
  return `${formattedMinutes}:${formattedSeconds}`;
}

function getRandomColor() {
  var letters = "0123456789ABCDEF";
  var color = "#";
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

window.onload = function () {
  const boxSize = 100;
  const minDistance = 50;
  let blockPositions = [];

  function checkOverlap(x, y) {
    let newRect = {
      x: x,
      y: y,
      width: boxSize,
      height: boxSize,
    };

    let overlapFlag = false;

    for (let i = 0; i < blockPositions.length; i++) {
      let existingRect = blockPositions[i];
      if (
        !(
          newRect.x + newRect.width < existingRect.x ||
          newRect.x > existingRect.x + existingRect.width ||
          newRect.y + newRect.height < existingRect.y ||
          newRect.y > existingRect.y + existingRect.height
        )
      )
        overlapFlag = true;

      let distance = Math.sqrt(
        Math.pow(newRect.x - existingRect.x, 2) +
          Math.pow(newRect.y - existingRect.y, 2)
      );
      if (distance < minDistance) {
        overlapFlag = true;
      }
    }
    return overlapFlag;
  }

  let blocks = [];

  for (let i = 0; i < count; i++) {
    const box = document.createElement("div");
    box.classList.add("box");
    box.innerText = i + 1;

    let x, y;
    let overlap = true;
    let maxAttempts = 1000;
    let attempts = 0;

    while (overlap && attempts < maxAttempts) {
      x = Math.random() * (gameContainer.offsetWidth - boxSize);
      y = Math.random() * (gameContainer.offsetHeight - boxSize);
      overlap = checkOverlap(x, y);
      attempts++;
    }

    if (attempts === maxAttempts) {
      console.log(
        "Не удалось найти незанятое место после."
      );
    }

    box.style.left = x + "px";
    box.style.top = y + "px";
    box.style.backgroundColor = getRandomColor();

    box.addEventListener("click", () => {
      box.remove();
      blocks = blocks.filter((b) => b !== box);
      blockPositions = blockPositions.filter(
        (pos) => pos.x !== x || pos.y !== y
      );
      updateCount(true);
    });

    gameContainer.appendChild(box);
    blocks.push(box);
    blockPositions.push({ x: x, y: y, width: boxSize, height: boxSize });
  }

  blocks.forEach((block) => moveBox(block));

  let timerInterval = setInterval(() => {
    timeLeft--;
    rightDisplay.innerHTML = " Оставшееся время: " + formatTime(timeLeft);
    if (timeLeft <= 0) {
      clearInterval(timerInterval);
      alert("Время вышло! Вы проиграли!");
    }
    if (blocks.length === 0) {
      clearInterval(timerInterval);
      alert("Вы выиграли!");
    }
  }, 1000);

  function moveBox(box) {
    const speed = 2;
    let dx = (Math.random() - 0.5) * speed;
    let dy = (Math.random() - 0.5) * speed;

    function updatePosition() {
      let x = parseFloat(box.style.left);
      let y = parseFloat(box.style.top);

      if (isNaN(x) || isNaN(y)) return;
      x += dx;
      y += dy;

      if (x < 0 || x > gameContainer.offsetWidth - 100) {
        dx = -dx;
      }
      if (y < 0 || y > gameContainer.offsetHeight - 100) {
        dy = -dy;
      }
      box.style.left = x + "px";
      box.style.top = y + "px";

      requestAnimationFrame(updatePosition);
    }
    updatePosition();
  }
};
