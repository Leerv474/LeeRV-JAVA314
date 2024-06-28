console.log("Hello!");
console.log("World!");

console.log("Hello" + "World!");
console.log("Hello" + " " + "World!");

console.log("3333");
console.log(343);

console.log("12" + "4");
console.log(12 + 4);

// getting element by id is performed with the following functions
document.getElementById("out");
document.querySelector("#out"); // # is important
// getting element by class name
document.querySelector(".header");

document.getElementById("out").innerHTML = "<b>2024!</b>";
document.querySelector(".header").innerHTML = "Hello!";

// alert("today is a wonderful day");
// alert("today is a wonderful day" + " is was warm");
// alert("today is a wonderful day" + " \nis was warm");

document.querySelector(".header").innerHTML = "My name is Roman";

let input_num = document.querySelector(".input-num");
let but = document.querySelector("button");
but.onclick = function () {
  input_num = prompt("Enter your birth date");
  console.log(input_num.value);
};

// let a = prompt('enter first number'),
//     b = prompt('enter second number');

// alert(`sum: ${(a + b)}\n`
//   ``
// );

let birthdate = prompt('enter your birth year');
const current_year = 2024;
alert(`your age is ${(current_year - birthdate)}`);
