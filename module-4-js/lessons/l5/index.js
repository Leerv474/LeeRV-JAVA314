out = [
  1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007,
  2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020,
  2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029,
].filter((out) => out % 4 == 0 || out % 400 == 0 || out % 100 != 0);
console.log(out);

//let array = [];
//while (array.length != 6) {
//  let input = prompt("Enter array of 6 elements");
//  array = input.split(",");
//}
//alert(`THe following array was given: ${array}`);
//console.log(array);

let people = [
  { name: "Alex", age: 25 },
  { name: "John", age: 20 },
  { name: "Boris", age: 35 },
];

console.log(people);
people.forEach((person) => {
  console.log(`${person.name} is ${person.age} years old`);
});

const but = document.getElementById("but_age_user");

const newNameInput = document.getElementById("new_name_user");
const newAgeInput = document.getElementById("new_age_user");

const oldNameInput = document.getElementById("name_user");
const oldAgeInput = document.getElementById("age_user");
but.addEventListener("click", () => {
  let oldName = oldNameInput.value;
  let oldAge = Number(oldAgeInput.value);
  let newName = newNameInput.value;
  let newAge = Number(newAgeInput.value);
  for (let i = 0; i < people.length; i++) {
    if (people[i].name == oldName && people[i].age == oldAge) {
      people[i].name = newName;
      people[i].age = newAge;
      console.log(people);
      return;
    }
  }
  console.log("Person wasn't found");
});

const pets = [
  { name: "Пушок", type: "кот", age: 13 },
  { name: "Пушок", type: "кот", age: 13 },
  { name: "Пушок", type: "кот", age: 13 },
  { name: "Пушок", type: "кот", age: 13 },
  { name: "Пушок", type: "кот", age: 13 },
  { name: "Пушок", type: "кот", age: 13 },
  { name: "Пушок", type: "кот", age: 13 },
];

console.log(pets);

pets.forEach((pet) => console.log(pet));

let twoDarray = [
  [1, 2, 3],
  [1, 2, 3],
  [1, 2, 3],
  [1, 2, 3],
];
let dbl_one = "";
for (let i = 0; i < twoDarray.length; i++) {
  for (let j = 0; j < twoDarray[i].length; j++) {
    dbl_one += twoDarray[i][j] + " ";
  }
  dbl_one += "<br>";
}

document.querySelector(".dbl_one").innerHTML = dbl_one;

let array2 = [1, 2, 3, 4, 5, 6, 7, 8];
array2.forEach((element) => {
  document.querySelector(".dblTwo").innerHTML = element + ", ";
});

let d = 0;

document.querySelector(".push").onclick = () => {
  if (d + 1 < 6) {
    array2[d] = 0;
    array2[d + 1] = 4;
    d++;
  }
  document.querySelector(".dblTwo").innerHTML = array2;
}
