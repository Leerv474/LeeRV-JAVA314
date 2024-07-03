const ageInput = document.getElementById("ageInput"),
  ageButton = document.getElementById("ageButton"),
  ageResult = document.getElementById("result");

ageButton.onclick = () => {
  if (ageInput.value >= 18 && ageInput.value <= 120) {
    ageResult.innerHTML = "You're an adult";
  } else if (ageInput.value >= 0 && ageInput.value < 18) {
    ageResult.innerHTML = "You're a minor";
  } else {
    ageResult.innerHTML = "Invalid age";
  }
};

const numberInput = document.getElementById("numberInput"),
  numberButton = document.getElementById("numberButton"),
  moduleResult = document.getElementById("moduleResult");

numberButton.onclick = () => {
  if (numberInput.value < 0) {
    moduleResult.innerHTML = `${numberInput.value * -1}`;
  } else {
    moduleResult.innerHTML = `${numberInput.value}`;
  }
};

const signInput = document.getElementById("signInput"),
  signButton = document.getElementById("signButton"),
  signResult = document.getElementById("signResult");

signButton.onclick = () => {
  if (isNaN(Number(signInput.value)) || signInput.value.trim() === "") {
    signResult.innerHTML = "Invalid input";
    return;
  }
  if (Number(signInput.value) < 0) {
    signResult.innerHTML = "Number is negative";
  } else if (Number(signInput.value) > 0) {
    signResult.innerHTML = "Number is positive";
  } else {
    signResult.innerHTML = "Number is zero";
  }
};

let switchInput = document.querySelector(".switchInput"),
  switchButton = document.querySelector(".switchButton");

switchButton.onclick = () => {
  let inputAnswer = +switchInput.value;
  switch (inputAnswer) {
    case 1:
      console.log("Right");
      break;
    case 2:
      console.log("Wrong");
      break;
    case 3:
      console.log("Wrong");
      break;
    case 4:
      console.log("Wrong");
      break;
    default:
      console.log("No such answer");
  }
};

const monthInput = document.getElementById("monthInput"),
  monthButton = document.getElementById("monthButton"),
  monthResult = document.getElementById("monthResult");

monthButton.onclick = () => {
  switch (Number(monthInput.value)) {
    case 1:
      monthResult.innerHTML = "January";
      break;
    case 2:
      monthResult.innerHTML = "February";
      break;
    case 3:
      monthResult.innerHTML = "March";
      break;
    case 4:
      monthResult.innerHTML = "April";
      break;
    case 5:
      monthResult.innerHTML = "May";
      break;
    case 6:
      monthResult.innerHTML = "June";
      break;
    case 7:
      monthResult.innerHTML = "July";
      break;
    case 8:
      monthResult.innerHTML = "August";
      break;
    case 9:
      monthResult.innerHTML = "September";
      break;
    case 10:
      monthResult.innerHTML = "October";
      break;
    case 11:
      monthResult.innerHTML = "November";
      break;
    case 12:
      monthResult.innerHTML = "December";
      break;
    default:
      monthResult.innerHTML = "No such month";
  }
};

const num1 = document.getElementById("num1"),
  num2 = document.getElementById("num2"),
  operation = document.getElementById("operation"),
  calcButton = document.getElementById("calcButton"),
  calcResult = document.getElementById("calcResult");

calcButton.onclick = () => {
  let number1 = Number(num1.value);
  let number2 = Number(num2.value);
  switch (operation.value) {
    case "sum":
      calcResult.innerHTML = `${(number1 + number2)}`;
      break;
    case "subtraction":
      calcResult.innerHTML = `${(number1 - number2)}`;
      break;
    case "multiplication":
      calcResult.innerHTML = `${(number1 * number2)}`;
      break;
    case "division":
      calcResult.innerHTML = `${(number1 / number2)}`;
      break;
  }
}

const planetInput = document.getElementById("planetInput"),
  planetButton = document.getElementById("planetButton"),
  planetResult = document.getElementById("planetResult");

planetButton.onclick = () => {
  if (planetInput.value == "Earth" || planetInput.value == "earth") {
    planetResult.innerHTML = "Hello earthling";
  } else {
    planetResult.innerHTML = "Hello alien";
  }
}

