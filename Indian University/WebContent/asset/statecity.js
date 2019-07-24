
$(document).ready(function(){
	
	$.getJSON('GetAllStatesJSON',{ajax:true},function(data){
	$.each(data,function(i,item){ 
	$('#ustate').append($('<option>').text(item.STATENAME).val(item.STATEID));	 
	}); 	});

	$('#ustate').change(function(){
		$.getJSON('getAllCitiesJSON',{ajax:true,stateid:$('#ustate').val()},function(data){
			$('#city').empty();
			$('#city').append($('<option>').text('-City-'));
			$.each(data,function(i,item){ 
			$('#city').append($('<option>').text(item.CITYNAME).val(item.CITYID));	 
			}); 	});
		
	});
	
});