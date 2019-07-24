$(document).ready(function(){
	$('#bname').change(function(){
		$.getJSON('GetBranchSemesterJSON',{ajax:true,bid:$('#bname').val()},function(data){
		//	alert(data[0].SEMESTER);
			$('#ssem').empty();
			$('#ssem').append($('<option>').text('-Sem-'));
			for(i=1;i<=data[0].SEMESTER;i++){ 
			$('#ssem').append($('<option>').text(i));	 
			}	});
		
	});
	
	
});