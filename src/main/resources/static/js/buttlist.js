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

$(function() {
    $("<select />").appendTo(".button_group");

    /* I DON'T KNOW
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

$('.item_toggle').click(function(){
  if ($(this).hasClass('list')) {
    $('.card.small').removeClass('as_list');
    $('.card_text').removeClass('as_list');
    $(this).removeClass('list');
  } else {
    $('.card.small').addClass('as_list');
    $('.card_text').addClass('as_list');
    $(this).addClass('list');
  };
});

$('.person_button').first().addClass('selected');

$('.person_button').click(function(){
    var $this = $(this);
    $siblings = $this.parent().children(),
    position = $siblings.index($this);
    console.log (position);

    $('.person_viewer > #thisone').removeClass('active').eq(position).addClass('active');

    $siblings.removeClass('selected');
    $this.addClass('selected');
})

$(function() {
    $("<select />").appendTo(".person_list");

    /* I DON'T KNOW
    $("<option />", {
      "selected": "selected",
      "value"   : "",
      "text"    : "Análises Clínicas"
    }).appendTo(".button_group select");
    */

    $(".person_list a").each(function() {
      var el = $(this);
      $("<option />", {
        "value"   : el.attr("href"),
        "text"    : el.text()
      }).appendTo(".person_list select");
    });

    $(".person_list select").change(function() {
      window.location = $(this).find("option:selected").val();
    });
});