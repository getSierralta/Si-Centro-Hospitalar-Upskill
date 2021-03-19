$(document).ready(function() {
	var max_fields      = 100; //maximum input boxes allowed
	var wrapper   		= $(".input_fields_wrap"); //Fields wrapper
	var add_button      = $(".add_field_button"); //Add button ID

	var x = 1; //initlal text box count
	var i = 0;
	$(add_button).click(function(e){ //on add input button click
		e.preventDefault();
		if(x < max_fields){ //max input box allowed
			x++; //text box increment
			i++;
			$(wrapper).append(
                '<div><input type="text" name="items['+i+'].description" placeholder="Descrição" required="required" ><input type="text" name="items['+i+'].value" placeholder="Value" required="required" ><a href="#" class="remove_field">Remover Item</a></div>'
                ); //add input box
		}
	});
	$(wrapper).on("click",".remove_field", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove();
		i--;
		x--;
	})
});

function submitform(){
    alert("Sending Json");
    var xhr = new XMLHttpRequest();
    xhr.open(form.method, form.action, true);
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    var formData = JSON.stringify($("#invoice").serializeArray());
    xhr.send(JSON.stringify(formData));
};

// PAY
/*$("#pay").on("click",function(){
    $.ajax({
        url: "http://localhost:8080/invoices/802244746/pay",
        type: "POST",
        data: "${invoice.getId()}",
        success: function(response){
            console.log( msg );
        },
        error: function(){
          console.log( "Request failed: " + textStatus );
        }
    });
});*/

// INVOICE OVERLAY
var $overlay = $('<div id="overlay"></div>');
var $iframe = $('<iframe width="595" height="485" frameborder="0" marginwidth="0" margin="0" height="0" scrolling="no" allowfullscreen></iframe>');
$overlay.append($iframe);

$('body').append($overlay);

$('a.card.small.invoice').click(function(event) {
    event.preventDefault();
    var id = $(this).attr("${invoice.getId()}");

    var xhr = new XMLHttpRequest();
    xhr.open('GET', id, true);
    var src = null;

    $iframe.attr('src', src);
    $overlay.show();
});

$overlay.click(function() {
    $overlay.hide();
    $iframe.attr('src', '');
});
// end invoice overlay

/*
$('#status').change(function(){
    event.preventDefault();
    $(this).closest('form').submit();
});
*/
