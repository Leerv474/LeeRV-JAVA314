const but = document.getElementById("but");

but.addEventListener("click", () => {

  mult();
})

function one() {
  console.log("hello world");
  return 0;
}

one();

console.log(one() + 1);

let a = 8,
  b = 8,
  c;

function mult() {
  c = a * b;
  console.log(`The product of a and b is ${c}`);
  return 0;
}

function mult2(a, b) {
  alert(a * b);
}

but.onclick = () => {
  mult2(+prompt('1'), +prompt('2'));
}

function hello() {
  let name = ;
  let 
}
