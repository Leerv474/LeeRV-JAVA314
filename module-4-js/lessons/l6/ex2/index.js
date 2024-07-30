$(document).ready(function () {
  let flag = true;

  $(".icon img").click(function () {
    console.log('worked');
    if (flag) {
      $(".links").css({
        top: "0px",
        transition: "3s ease", // 'z-index': 1,
      });
    } else {
      $(".links").css({
        top: "-320px",
        transition: "5s ease",
      });
    }
    flag = !flag;
  });
});
