//alert($("#one").text()); // Alerts the initial text of the element with id "one"
//$("#one").text("New text");
//alert($("#one").text()); // Alerts the new text of the element with id "one"

//$(function () {
//  //$('#one').hide(4000);
//  //$('#one').show(4000);
//
//  $('#one').hide(4000).show(4000);
//});

//$(function () {
//  $(".but").click(function () {
//    $("#one").toggle(4000);
//  });
//});
//
//$("#one").slideUp(3000).slideDown(3000);
//
//$(function () {
//  $(".img_img > img").hide(5000).show(5000);
//});

//$(function () {
//  $(".img_img > img").fadeTo(5000, 0.2).fadeTo(5000, 1);
//});

//$(function () {
//  $(".tag_P")
//    .animate(
//      {
//        "font-size": "24pt",
//      },
//      3000,
//    )
//    .animate(
//      {
//        "font-size": "12pt",
//      },
//      3000,
//    );
//});

//$('.sd_2').click(function start() {
//    $('.img_img img')
//        .animate({
//            opacity: 0.4,
//            marginLeft: "10%"
//        }, 2000)
//        .animate({
//            opacity: 1,
//            marginTop: "10%"
//        }, 2000)
//        .animate({
//            opacity: 0.4,
//            marginLeft: "0%"
//        }, 2000)
//        .animate({
//            opacity: 1,
//            marginTop: "0%"
//        }, 2000, start);
//});

//$(function() {
//    $('.icon img').each(function() {
//        if ($(this).attr('src') == 'comp3.png') {
//            $(this).hide(1000).show(1000);
//        }
//    });
//});

$(function() {
    $('.icon img').mouseover(function() {
        $(this).fadeTo(1000, 0.5);
    }).mouseout(function() {
        $(this).fadeTo(1000, 1);
    });
});
