$(document).ready(function(){
	$.getJSON('GetAllUniversitiesJSON',{ajax:true},function(data){
		$.each(data,function(i,item){
		$('#buniversityname').append($('<option>').text(item.UNIVERSITYNAME).val(item.UNIVERSITYID));
	});
	
	});

	$('#buniversityname').change(function(){
		$.getJSON('GetAllBranchesJSON',{ajax:true,universityid:$('#buniversityname').val()},function(data){
			$('#bname').empty();
			$('#bname').append($('<option>').text('-Branch-'));
			$.each(data,function(i,item){ 
				$('#bname').append($('<option>').text(item.BRANCHNAME).val(item.BRANCHID));	 
			}); 	
		});
	});

	$('#ssem').change(function(){
		$.getJSON('GetAllSubjectsJSON',{ajax:true,semester:$('#ssem').val(),bid:$('#bname').val()},function(data){
			$('#subs').empty();
			$('#subs').append($('<option>').text('-Subject-'));
			$.each(data,function(i,item){ 
			$('#subs').append($('<option>').text(item.SUBJECTNAME).val(item.SUBJECTID));
			});
		});
	});
	
});
