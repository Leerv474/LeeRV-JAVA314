$(document).ready(function () {
  let flag = true;

  $(".icon img").on(function () {
    console.log('worked');
    if (flag) {
      $(".links").css({
        left: "35px",
        transition: "3s ease", // 'z-index': 1,
      });
    } else {
      $(".links").css({
        left: "-550px",
        transition: "5s ease",
      });
    }
    flag = !flag;
  });
});
