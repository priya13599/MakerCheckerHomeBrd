function validateemail()
{
	
	var x = document.myform.email.value;
	var y = document.myform.pincode.value;
	var name = document.myform.customername.value;
	var code = document.myform.customercode.value;
	var atposition = x.indexOf("@");
	var dotposition = x.lastIndexOf(".");
	
	if(code.length<10)
	{
	alert("Customer Code Should Less than 10");
	return false;
	}

	if(atposition<1||dotposition<atposition+2||dotposition+2>=x.length)
		{
		   alert("Please enter a valid e-mail address");
		   return false;
		
		}
	if(y.length<6)
		{
		 alert("Pincode Length should be equal to 6");
		 return false;
		}
	if(/[^a-zA-Z0-9\s]/.test(name))
		{
		alert("Customer Name Should be Alphanumeric");
		return false;
		}
	if(/[^0-9]/.test(y))
		{
		
		alert("Pincode Should contains Numeric Character");
		return false;
		}
	
	
	
	
	}
/**
 * 
 */