var i = 100;

var timerId = setInterval(function () {
  $("#aura").toggleClass("suspend");
  $("#aura").toggleClass("progress");
  $("#sight").toggleClass("turnblue");

  navigator.vibrate([
    i, i,
    i * 3, i,
    i, i,
    i * 5, i * 2
  ]);
}, i * 17);