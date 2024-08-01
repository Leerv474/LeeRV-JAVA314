$(document).ready(function () {
  function resizeText() {
    let currentFontSize = parseInt($("#text").css("font-size"));
    let newFontSize = currentFontSize + (Math.random() > 0.5 ? 2 : -4);
    if (newFontSize < 10) newFontSize = 10;
    if (newFontSize > 50) newFontSize = 50;
    $("#text").css("font-size", newFontSize + "px");
  }

  function resizeImage() {
    let currentWidth = $("#image").width();
    let newWidth = currentWidth + (Math.random() > 0.5 ? 10 : -10);
    if (newWidth < 100) newWidth = 100;
    if (newWidth > 400) newWidth = 400;
    $("#image").css("width", newWidth + "px");
  }

  function resizing() {
    resizeText();
    resizeImage();
    setTimeout(resizing, 500);
  }

  $("#start").click(function () {
    resizing();
  });
});
