document.getElementById("task1").addEventListener("click", () => {
  let age = Number(prompt("enter your age"));
  if (age < 0) {
    alert("invalid age");
  } else if (age < 12) {
    alert("you're a child");
  } else if (age < 18) {
    alert("you're a teenager");
  } else if (age < 60) {
    alert("you're an adult");
  } else {
    alert("you're an elder");
  }
});

document.getElementById("task2").addEventListener("click", () => {
  let digit = Number(prompt("enter a digit"));
  let digits_syms = {
    1: "!",
    2: "@",
    3: "#",
    4: "$",
    5: "%",
    6: "^",
    7: "&",
    8: "*",
    9: "(",
    0: ")",
  };
  alert(digits_syms[digit]);
});

document.getElementById("task3").addEventListener("click", () => {
  let number = Number(prompt("enter the three digit number"));
  if (number > 99 && number < 1000) {
    let numberStr = number.toString();
    if (
      numberStr[0] == numberStr[1] ||
      numberStr[0] == numberStr[2] ||
      numberStr[1] == numberStr[2]
    ) {
      alert("Number has repeating digits in it");
    } else {
      alert("Number has only unique digits in it");
    }
    return;
  }
  alert("invalid number");
});

document.getElementById("task4").addEventListener("click", () => {
  let year = Number(prompt("enter a year"));
  if (year < 0) {
    alert("invalid year");
    return;
  }
  if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
    alert("this year is a leapyear");
    return;
  }
  alert("this is a regular year");
});

document.getElementById("task5").addEventListener("click", () => {
  let number = Number(prompt("enter a 5 digit number"));
  if (number > 9999 && number < 100000) {
    let numberStr = number.toString();
    for (let i = 0; i < Math.round(numberStr.length / 2); i++) {
      console.log(i);
      if (numberStr[i] != numberStr[numberStr.length - i - 1]) {
        alert("This is not a polindrome number");
        return;
      }
    }
    alert("This is a palindrome");
    return;
  }
  alert("Invalid input");
});

const converterButton = document.getElementById("converterButton");
const converterResult = document.getElementById("converterResult");
const usd = document.getElementById("usd");
const currency = document.getElementById("currency");
converterButton.addEventListener("click", () => {
  converterResult.innerHTML = `${usd.value * currency.value}`;
});

document.getElementById("task7").addEventListener("click", () => {
  let price = Number(prompt("Enter purchase price"));
  if (price >= 200 && price < 300) {
    alert(`Price with sale applied: ${price * 0.97}`);
  } else if (price >= 300 && price < 500) {
    alert(`Price with sale applied: ${price * 0.95}`);
  } else if (price >= 500) {
    alert(`Price with sale applied: ${price * 0.93}`);
  }
});

document.getElementById("task8").addEventListener("click", () => {
  let circumference = Number(prompt("Enter the circumference"));
  let perimeter = Number(prompt("Enter the perimeter of a square"));
  if (perimeter > circumference) {
    alert("Such circle would fit in such square");
  }
});

document.getElementById("task9").addEventListener("click", () => {
  let question1 = Number(prompt("question 1\n1) answer\n2) answer\n3) answer"));
  let question2 = Number(prompt("question 2\n1) answer\n2) answer\n3) answer"));
  let question3 = Number(prompt("question 3\n1) answer\n2) answer\n3) answer"));
  let score = 0;

  if ((question1 = 1)) {
    score++;
  }
  if ((question2 = 1)) {
    score++;
  }
  if ((question3 = 1)) {
    score++;
  }
  alert(`You scored ${score}`);
});

const result = document.getElementById("result");
const day = document.getElementById("day");
const month = document.getElementById("month");
const year = document.getElementById("year");
document.getElementById("task10").addEventListener("click", () => {
  if (month.value <= 0 || month.value > 12 || year.value < 0) {
    result.innerHTML = "Invalid date";
    return;
  }
  let daycap = 0;

  let resultDay = day.value;
  let resultMonth = month.value;
  let resultYear = year.value;
  let monthRemainder = 0;
  if (month.value <= 7) {
    monthRemainder = 1;
  }
  if (month.value % 2 == monthRemainder) {
    daycap = 31;
  } else {
    daycap = 30;
  }
  if (month.value == 2) {
    if (year.value % 400 == 0 || (year.value % 4 == 0 && year.value % 100 != 0)) {
      daycap = 29;
    } else {
      daycap = 28;
    }
  }
  if (day.value <= 0 || day.value > daycap) {
    result.innerHTML = "Invalid date";
    return;
  }
  if (day.value == daycap) {
    resultDay = 1;
    resultMonth++;
    if (resultMonth == 13) {
      resultMonth = 1;
      resultYear++;
    }
  } else {
    resultDay++;
  }
  result.innerHTML = `The next date is ${resultDay}:${resultMonth}:${resultYear}`;
});
