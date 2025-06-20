   let box = {
      element: document.querySelector('.box'),
      top: 0,
      left: 0,
      isUp: false, // true - вверх или влево, false - вниз или вправо
      texts: ["1", "2", "3", "Финиш!"],
      circleCount: 0
}

  function setText() {
     box.element.textContent = box.texts[box.circleCount % 4];
 }

 setText()

 let intervalId =  setInterval(() => {
      // Вниз или вправо 
      if (!box.isUp) {
          if (box.top < window.innerHeight - 165) {
              console.log("DOWN");
              box.element.style.top = box.top + 'px';
              box.top += 10;
          } else if (box.left < window.innerWidth - 165) {
              console.log("RIGHT");
              box.element.style.left = box.left + 'px';
              box.left += 10;
          } else {
              box.isUp = true;
             
          }
      }
      // Вверх или влево 
      else {
          if (box.top > 0) {
              console.log("UP");
              box.element.style.top = box.top - 10 + 'px'; 
              box.top -= 10;
          } else if (box.left > 0) {
              console.log("LEFT");
              box.element.style.left = box.left - 10 + 'px'; 
              box.left -= 10;
          } else {
              box.isUp = false;
            if(box.top <= 0 && box.left <= 0){
               box.circleCount++;
               setText();
              }
     }
          }
       if (box.circleCount >= 4) {
          box.element.remove();
          clearInterval(intervalId); 
          console.log("Финиш");
       }
  }, 150);
