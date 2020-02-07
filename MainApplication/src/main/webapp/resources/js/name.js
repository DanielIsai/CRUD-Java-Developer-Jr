function fvalidator(){

			var flag = true;

			var name = document.getElementById("fname").value;

			if(name == "") flag = false;

			if(!flag){
				document.getElementById("fname").focus();
				document.getElementById("message").innerHTML = "Empy name. Please enter a name.";
				return flag;
				}	

			return flag;
		
			
		}