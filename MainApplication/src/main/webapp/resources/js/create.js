/**
 * http://usejsdoc.org/
 */

function fvalidator(){

			var flag = true;

			var name = document.getElementById("fname").value;

			if(name == "") flag = false;

			if(!flag){
				document.getElementById("fname").focus();
				document.getElementById("message").innerHTML = "Empy name. Please enter a name.";
				return flag;
				}	
			
			var email = document.getElementById("femail").value;
			
			
			if(email.substring(email.indexOf('@') - 1,email.indexOf('@')) == '.') 		flag = false;
			if(email.substring(email.indexOf('@') + 1,email.indexOf('@')+2) == '.') 	flag = false;
			if(email.indexOf('@') <= 0 || email.indexOf('@') == email.length-1)			flag = false;
			if(email.indexOf('.') <= 0 || email.indexOf('.') == email.length-1)			flag = false;
			if(email.indexOf('@',email.indexOf('@')+1) != -1)							flag = false;
			if(email.substring(email.length-1, email.lenght) == '.')					flag = false;
			
			if(!flag){
				document.getElementById("femail").focus();
				document.getElementById("message").innerHTML = "Invalid email. Please enter a valid email.";
				return flag;
				}	
			
			

			
			var phone = document.getElementById("fphone").value;

			if(phone.indexOf('.') != -1) 				flag = false 
			if(isNaN(phone)||phone.indexOf(" ")!=-1) 	flag = false;
			if(!(phone.length == 10)) 					flag = false;


			
			if(!flag){
				document.getElementById("fphone").focus();
				document.getElementById("message").innerHTML = "Invalid phone. Please enter a valid phone. Format XXXXXXXXXX";
				return flag;
				}	

			return flag;
		
			
		}