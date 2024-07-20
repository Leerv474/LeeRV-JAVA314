function mixmax(num1, num2) {
  return num1 > num2 ? num1 : num1 == num2 ? 0 : num2;
}

function fact(num) {
  let result = 1;
  while (num > 0) {
    result *= num;
    num--;
  }
  return result;
}

function mergeNums(num1, num2, num3) {
  if (num1 > 9 || num1 < 0 || num2 > 9 || num2 < 0 || num3 > 9 || num3 < 0) {
    return 0;
  }
  return num1 * 100 + num2 * 10 + num3;
}

function rectangleArea(side1, side2 = -1) {
  if (side2 == -1) {
    side2 = side1;
  }
  return side1 * side2;
}

function perfectNum(num) {
  let sum = 1;
  let divisor = 2;
  while (divisor < num) {
    if (num % divisor == 0) {
      sum += divisor;
    }
    divisor++;
  }
  if (sum == num) {
    return true;
  }
  return false;
}

function perfectArray(min, max) {
  for (let i = min; i <= max; i++) {
    if (perfectNum(i)) {
      console.log(i);
    }
  }
}

function time(hours, mins = 0, secs = 0) {
  if (
    hours < 0 ||
    hours > 60 ||
    mins < 0 ||
    mins > 60 ||
    secs < 0 ||
    secs > 60
  ) {
    return "Invalid time";
  }
  alert(
    `${hours.toString().padStart(2, "0")}:${mins.toString().padStart(2, "0")}:${secs.toString().padStart(2, "0")}`,
  );
}

function timeInSeconds(hours, mins, secs) {
  if (hours < 0 || mins < 0 || secs < 0) {
    return "Invalid time";
  }

  return hours * 60 * 60 + mins * 60 + secs;
}

function secsConvert(secsInput) {
  if (secsInput < 0) {
    return "Invalid time";
  }
  let secs = secsInput % 60;
  secsInput = Math.round(secsInput / 60);
  let mins = secsInput % 60;
  secsInput = Math.round(secsInput / 60);
  let hours = secsInput % 60;
  alert(
    `${hours.toString().padStart(2, "0")}:${mins.toString().padStart(2, "0")}:${secs.toString().padStart(2, "0")}`,
  );
}

function timeDiff(hours1, mins1, secs1, hours2, mins2, secs2) {
  return secsConvert(Math.abs(timeInSeconds(hours1, mins1, secs1) - timeInSeconds(hours2, mins2, secs2)));
}
