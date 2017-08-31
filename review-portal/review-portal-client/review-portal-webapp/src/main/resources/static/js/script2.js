$(document).ready(function() {
	
	$( "#acprofessisons" ).click(function() {
		  alert( "Handler for .click() called." );
		});
	
	$(function() {      
        $("#acprofesssions").autocomplete({
            source: function (request, response) {
                $.getJSON("/getSelectItemProfessions", {
                    term: request.term
                }, response);
            }
        });
    });
	
	$('#acprofessions').autocomplete({
		serviceUrl : '/getSelectItemProfessions',
		paramName : "pInput",
		delimiter : ",",
		transformResult : function(response) {

			return {

				suggestions : $.map($.parseJSON(response), function(item) {

					return {
						value : item.label,
						data : item.value
					};
				})

			};

		}

	});

});