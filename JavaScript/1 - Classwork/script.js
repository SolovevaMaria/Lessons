
for(let i=0; i <8;   i++){
    let spaces = "";
    console.log(i+ ' '+ '* * * * *')
}

for (let i = 0; i < 9; i++) {
  let spaces = "";
  for (let j = 0; j < i; j++) {
    spaces += " ";
  }
  console.log(spaces + "*");
}
for (let i = 0; i < 8; i++) {
  let spaces = "";
  for (let j = 0; j < 8 - i; j++) {
    spaces += " ";
  }
  console.log(spaces + "*");
}


for (let i = 0; i < 8; i++) {
    let line = "";
    for (let j = 0; j <= i; j++) {
        line += "* ";
    }
    console.log(line);
}


for (let i = 8; i >= 0; i--) {
    let line = "";
    for (let j = 0; j < i; j++) {
        line += "* ";
    }
    console.log(line);
}

const width = 8;
const height = 8;

for (let i = 0; i < height; i++) {
    let row = "";
    for (let j = 0; j < width; j++) {
        if (i === 0 || i === height - 1 || j === 0 || j === width - 1) {
            row += "* ";
        } else {
            row += "  "; 
        }
    }
    console.log(i+row );
}

        for (let i = 0; i < 8; i++) {
    let line = "";
    for (let j = 0; j <= i; j++) {
        if (j === 0 || j === i || i === 7) { 
            line += "* ";
        } else {
            line += "  "; 
        }
    }
    console.log(line);
}

for (let i = 8; i >= 0; i--) {
    let line = "";
    for (let j = 0; j < i; j++) {
        if (j === 0 || j === i - 1 || i === 8) {
            line += "* ";
        } else {
            line += "  ";
        }
    }
    console.log(line);
}