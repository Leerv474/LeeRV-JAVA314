document.getElementById("task1").addEventListener("click", () => {
  let times = Number(prompt("Enter the number of #"));
  let count = 0;
  while (count < times) {
    console.log("#");
    count++;
  }
});

document.getElementById("task2").addEventListener("click", () => {
  let number = Number(prompt("Enter the number"));
  let incremenent = 0;
  if (number < 0) {
    incremenent = 1;
  } else {
    incremenent = -1;
  }
  while (number != 0 + incremenent) {
    console.log(number);
    number += incremenent;
  }
});

document.getElementById("task3").addEventListener("click", () => {
  let number = Number(prompt("Enter the number"));
  let power = Number(prompt("Enter the power"));
  let result = 1;
  while (power != 0) {
    result *= number;
    power--;
  }
  console.log(result);
});

document.getElementById("task4").addEventListener("click", () => {
  let num1 = Number(prompt("Enter the number 1"));
  let num2 = Number(prompt("Enter the number 2"));

  let smallerNum = num1 > num2 ? num1 : num2;
  smallerNum = Math.ceil(Math.sqrt(smallerNum));
  while (smallerNum > 0) {
    if (num1 % smallerNum == 0 && num2 % smallerNum == 0) {
      console.log(smallerNum);
    }
    smallerNum--;
  }
});

document.getElementById("task5").addEventListener("click", () => {
  let number = Number(prompt("Enter the number"));
  let result = number;

  while (number > 1) {
    result *= --number;
  }
  alert(result);
});

document.getElementById("task6").addEventListener("click", () => {
  let answer = 0;
  do {
    answer = Number(prompt("What is 2 + 2 * 2"));
  } while (answer != 6);
});

document.getElementById("task7").addEventListener("click", () => {
  let number = 1000;
  let count = 0;
  do {
    number /= 2;
    count++;
  } while (number >= 50);
  console.log(number);
  console.log(count);
});

document.getElementById("task8").addEventListener("click", () => {
  let number = Number(prompt("Enter the number"));
  for (let i = 0; i < 50; i++) {
    if (i % number == 0) {
      console.log(i);
    }
  }
});

document.getElementById("task9").addEventListener("click", () => {
  let min = Number(prompt("Enter min value"));
  let max = Number(prompt("Enter max value"));
  let count = 0;

  for (let i = min; i < max; i++) {
    count++;
    if (count % 4 == 0) {
      console.log(i);
    }
  }
});

document.getElementById("task10").addEventListener("click", () => {
  let number = Number(prompt("Enter number"));

  for (let i = 0; i < Math.sqrt(number); i++) {
    if (number % i == 0) {
      alert("Given number isn't a prime one");
      return;
    }
  }
  alert("Given number is a prime number");
});
