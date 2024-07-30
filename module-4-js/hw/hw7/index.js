function checkAnswers() {
  const correctAnswers = ["4", "2", "3", "2", "4"];
  let score = 0;
  const form = document.getElementById("quiz-form");
  const resultDiv = document.getElementById("result");
  resultDiv.innerHTML = "";

  correctAnswers.forEach((answer, index) => {
    const questionNumber = index + 1;
    const userAnswer = form["q" + questionNumber].value;
    const resultText = document.createElement("p");

    if (userAnswer === answer) {
      score++;
      resultText.textContent = `Вопрос ${questionNumber}: Верно!`;
      resultText.classList.add("correct");
    } else {
      resultText.textContent = `Вопрос ${questionNumber}: Ошибка. Правильный ответ: ${correctAnswers[index]}`;
      resultText.classList.add("incorrect");
    }

    resultDiv.appendChild(resultText);
  });

  const scoreText = document.createElement("p");
  scoreText.textContent = `Вы набрали ${score} из ${correctAnswers.length} баллов.`;
  resultDiv.appendChild(scoreText);
}

function resetQuiz() {
  document.getElementById("quiz-form").reset();
  document.getElementById("result").innerHTML = "";
}
