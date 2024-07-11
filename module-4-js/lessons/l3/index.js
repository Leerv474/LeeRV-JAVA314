for (let i = 0; i < 7; i++) {
  if (i % 2 == 1) {
    continue;
  }
  console.log(i);
}

let test = document.querySelectorAll(".one");
console.log(test);

for (let i = 0; i < test.length; i++) {
  test[i].style.background = "pink";
  test[i].style.border = "2px double red";
  test[i].style.marginTop = "20px";
  test[i].style.cursor = "pointer";

  test[i].onclick = mes;
}

function mes() {
  console.log("works");
}

let radioInput = document.querySelectorAll("input");
let yes = document.querySelectorAll(".inp_yes");
let no = document.querySelectorAll(".inp_no");
let but_one = document.querySelector(".but_one");

but_one.onclick = () => {
  for (let j = 0; j < radioInput.length; j++) {
    if (radioInput[j].checked) {
      console.log(radioInput[j].value);
    }
  }

  for (let j = 0; j < yes.length; j++) {
    yes[j].style.color = "darkgreen";
  }

  for (let j = 0; j < no.length; j++) {
    no[j].style.color = "red";
  }
};

const equation = document.getElementById("equation");
equation.onclick = () => {
  let answer = 0;
  do {
    answer = Number(prompt("what is 2 + 2 * 2?"));
  } while (answer != 6);
};

