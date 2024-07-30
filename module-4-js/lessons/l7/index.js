$(document).ready(function () {
  $("small a").click(function (e) {
    e.preventDefault();
    if ($(".big img").attr("src") != $(this).attr("href")) {
      $(".big img").hide().attr("src", $(this).attr("href")).fadeIn(1000).css({
        width: "100%",
        height: "100%",
      });
    }
  });

  $(".button").click(function (e) {
    e.preventDefault();
    $("gallery").slideToggle();
    if ($(".button").text() == "+") {
      $("button").text("-");
    } else {
      $("button").text("+");
    }
  });

  $(".small a img").click(function () {
    // Выделение выбранной картинки (css - св-ва)
    $(this).fadeTo(600, 0.6).css({
      border: "1px dotted red",
    });
  });

  $(document).mouseup(function () {
    $(".small a img").fadeTo(0, 1).css({
      border: "none",
    });
  });
});
