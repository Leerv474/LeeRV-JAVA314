let purchaces = [
  {
    name: "apple",
    amount: 4,
    sold: true,
  },
  {
    name: "banana",
    amount: 7,
    sold: false,
  },
  {
    name: "cherry",
    amount: 2,
    sold: true,
  },
  {
    name: "date",
    amount: 10,
    sold: false,
  },
  {
    name: "elderberry",
    amount: 1,
    sold: true,
  },
  {
    name: "fig",
    amount: 5,
    sold: false,
  },
  {
    name: "grape",
    amount: 8,
    sold: true,
  },
  {
    name: "honeydew",
    amount: 3,
    sold: false,
  },
  {
    name: "kiwi",
    amount: 6,
    sold: true,
  },
  {
    name: "lemon",
    amount: 9,
    sold: false,
  },
];

function printPurchaces() {
  purchaces.sort((a, b) => a.sold - b.sold);
  purchaces.forEach((item) => {
    console.log(
      `name: ${item.name}, amount: ${item.amount}, status: ${item.sold ? "sold" : "unsold"}`,
    );
  });
}

function addItem(productName) {
  if (purchaces.find((item) => item.name == productName) == undefined) {
    purchaces.push({ name: productName, amount: 1, sold: false });
    return;
  }
  purchaces.find((item) => {
    if (item.name == productName) {
      item.amount++;
      return;
    }
  });
}

function purchaseProduct(productName) {
  purchaces.find((item) => {
    if (item.name == productName) {
      item.sold = true;
      return;
    }
  });
}
let checkout = [
  { name: "apple", amount: 4, price: 89 },
  { name: "banana", amount: 7, price: 45 },
  { name: "cherry", amount: 2, price: 120 },
  { name: "date", amount: 10, price: 75 },
  { name: "elderberry", amount: 1, price: 150 },
  { name: "fig", amount: 5, price: 60 },
  { name: "grape", amount: 8, price: 40 },
  { name: "honeydew", amount: 3, price: 70 },
  { name: "kiwi", amount: 6, price: 55 },
  { name: "lemon", amount: 9, price: 30 },
];

function printCheckout() {
  checkout.forEach((item) => {
    console.log(
      `name: ${item.name}, amount: ${item.amount}, price: ${item.price}`,
    );
  });
  console.log(`Total expenses: ${totalExpenses()}`);
}

function totalExpenses() {
  return checkout.reduce((accumulator, item) => accumulator + item.price, 0);
}

function expensiveItem() {
  let max = 0;
  checkout.forEach(item => {
    if (max < item.price) {
      max = item.price;
    }
  })
  return max;
}

function avgPrice() {
  return checkout.reduce((accumulator, item) => accumulator + item.price, 0) / checkout.length;
}
