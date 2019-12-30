function changeUserInfoFunction(){
		var userValue=document.getElementById("userId").value;
		var namePattern="^[1-9]{1}[0-9]{3}$";
		document.getElementById("validUserInfoChange").style.color="red";
	
		if(!userValue.match(namePattern)){
	
			document.getElementById("validUserInfoChange").innerHTML="enter correct user id";
			return false;
		}
		else
			document.getElementById("validUserInfoChange").innerHTML="";
		return true;
	}