/**
 * 
 */

$(document).ready(function(){
    $('.table .eBtn').on('click',function(event){
    	event.preventDefault();
    	var href = $(this).attr('href');
	    	$.get(href, function(customer,status){
	    		$('.myForm #id').val(customer.id);
	    		$('.myForm #firstname').val(customer.firstname);
	    		$('.myForm #lastname').val(customer.lastname);
	    		$('.myForm #email').val(customer.email);
	    		$('.myForm #address').val(customer.address);
	    		$('.myForm #city').val(customer.city);
	    		$('.myForm #state').val(customer.state);
	    		$('.myForm #zip').val(customer.zip);
	    	});
	       
    });
    
    $('.table .delBtn').on('click',function(event){
    	event.preventDefault();
    	var href = $(this).attr('href');
    	$('#myModal #delRef').attr('href', href);
    	$('#myModal').modal();
    });
});
