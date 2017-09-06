$(document).ready(function() {
	
	$( "#acprofessisons" ).click(function() {
		  alert( "Handler for .click() called." );
		});
	
	$(function() {      
        $("#acprofesssionss").autocomplete({
            source: function (request, response) {
                $.getJSON("/getSelectItemProfessions", {term: request.term}, response);
            }
        });
    });
	
	$('#searchProfessionTitle').autocomplete({
		serviceUrl : '/reviewhub/getSelectItemProfessions',
		paramName : "pInput",
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