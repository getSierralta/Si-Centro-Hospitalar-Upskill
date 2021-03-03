$('.butts').first().addClass('active');

$('.butts').click(function(){
  var $this = $(this);
  $siblings = $this.parent().children(),
  position = $siblings.index($this);
  console.log (position);
  
  $('.card.info div').removeClass('active').eq(position).addClass('active');
  
  $siblings.removeClass('active');
  $this.addClass('active');
})

// DOM ready
$(function() {
    $("<select />").appendTo(".button_group");

    /*
    $("<option />", {
      "selected": "selected",
      "value"   : "",
      "text"    : "Análises Clínicas"
    }).appendTo(".button_group select");
    */

    $(".button_group a").each(function() {
      var el = $(this);
      $("<option />", {
        "value"   : el.attr("href"),
        "text"    : el.text()
      }).appendTo(".button_group select");
    });

    $(".button_group select").change(function() {
      window.location = $(this).find("option:selected").val();
    });
});