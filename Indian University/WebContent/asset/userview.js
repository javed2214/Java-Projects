$(document).ready(function(){
$.getJSON('GetAllUniversitiesJSON',{ajax:true},function(data){
	h='<table border=1 cellspacing=10 cellpadding=10>';
	c=1;
	$.each(data,function(i,item){
     if(c==1){
    	 h+='<tr>';}
       h+="<td align=center>"+item.UNIVERSITYNAME+"<br>"+item.UCITY+"<br><img src=images/uni/"+item.LOGO+" width=100 height=100><br><br><input type=button value='View Branch'>&nbsp;&nbsp;<input type=button value='More Info'></td>";
       c=c+1;
       if(c==4)
    	   {h+='</td>';
    	   c=1;
    	   }
       
	});
	h+="</table>"
	$('#result').html(h);
	});


  $('#txt').keyup(function(){
	  $.getJSON('DisplayUniversityByPatternJSON',{ajax:true,pat:$('#txt').val()},function(data){
			h='<table border=1 cellspacing=10 cellpadding=10>';
			c=1;
			$.each(data,function(i,item){
		     if(c==1){
		    	 h+='<tr>';}
		       h+="<td align=center>"+item.UNIVERSITYNAME+"<br>"+item.UCITY+"<br><img src=images/uni/"+item.LOGO+" width=100 height=100><br><br><input type=button value='View Branch'>&nbsp;&nbsp;<input type=button value='More Info'></td>";
		       c=c+1;
		       if(c==4)
		    	   {h+='</td>';
		    	   c=1;
		    	   }
		       
			});
			h+="</table>";
			$('#result').html(h);
   });
  });
 });