function call()
{
	password=document.getElementById('password');
	conpassword=document.getElementById('conpassword');
	img=document.getElementById('img');
	if(password.value==conpassword.value)
	{
		img.src='tick.png';
	}
	else
	{
		img.src='crs.png';
	}
}