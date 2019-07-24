
	function validateForm() 
	{
    	var username = document.forms["loginform"]["username"].value;
    	var password = document.forms["loginform"]["password"].value;
    	var len = username.trim().length;
         
    	    

    	 if (len< 1)
    	 {
    		 if(username == "")
    			 {
    			 	alert("Username must be Filled Out!");
    			 	return false;
    			 }
    		
    		 else
    			 {
    			 	alert("Invalid Username");
    			 	return false;
    			 }
    	 }
    	
    	
    	if (password == "") 
    	{
        	alert("Password must be Filled Out!");
        	return false;
    	}

    	else
    	{
    		return true;
    	}
    
    }
