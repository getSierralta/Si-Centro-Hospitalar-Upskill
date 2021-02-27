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