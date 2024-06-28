document.getElementById("task1").addEventListener("click", function () {
  let number = Number(prompt("enter the number"));
  alert(`the square root of ${number} is ${number * number}`);
});

document.getElementById("task2").addEventListener("click", function () {
  let num1 = Number(prompt("enter the first number"));
  let num2 = Number(prompt("enter the second number"));
  alert(`the average of the two given numbers is ${(num1 + num2) / 2}`);
});
document.getElementById("task3").addEventListener("click", function () {
  let a = Number(prompt("enter side of a square"));
  alert(`the area of a square is ${a * a}`);
});
document.getElementById("task4").addEventListener("click", function () {
  let kms = Number(prompt("enter the number of kilometers"));
  const multiplier = 0.621371;
  alert(`${kms} km is ${kms * multiplier} miles`);
});
document.getElementById("task5").addEventListener("click", function () {
  let num1 = Number(prompt("enter the first number"));
  let num2 = Number(prompt("enter the second number"));
  alert(`sum: ${num1 + num2}
  difference: ${num1 - num2}
  product: ${num1 * num2}
  quotient: ${num1 / num2}
    `);
});
document.getElementById("task6").addEventListener("click", function () {
  let a = Number(prompt("enter a of a * x + b = 0"));
  let b = Number(prompt("enter b of a * x + b = 0"));
  alert(`x = ${((-1 * b) / a)}`);
});
document.getElementById("task7").addEventListener("click", function () {
  let hoursInDay = 24;
  let hours = Number(prompt("enter current hours"));
  let minutes = Number(prompt("enter current minutes"));
  if (minutes != 0) {
    hoursInDay--;
  }
  alert(`there is ${(hoursInDay - hours)} hours and ${(60 - minutes)} left until the next day`);
});
document.getElementById("task8").addEventListener("click", function () {
  let number = 0;
  while (number < 100 || number > 999) {
    number = Number(prompt("enter a three digit number"));
  }
  alert(`${(Math.round(number / 10) % 10)}`);
});
document.getElementById("task9").addEventListener("click", function () {
  let number = 0;
  while (number < 10000 || number > 99999) {
    number = Number(prompt("enter a five digit number"));
  }
  alert(`${( (number % 10) * 10000 + Math.round(number / 10))}`);
});
document.getElementById("task10").addEventListener("click", function () {
  let sales = Number(prompt("Enter the total sales this month"));
  alert(`This month's salary is $${(250 + sales * 0.1)}`);
});
