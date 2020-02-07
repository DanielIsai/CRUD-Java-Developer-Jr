function fvalidator(){

			var flag = true;

			var street = document.getElementById("fstreet").value;
			if(street == "") flag = false;
			if(!flag){
				document.getElementById("fstreet").focus();
				document.getElementById("message").innerHTML = "Empy street. Please enter a street.";
				return flag;
			}	
			
			var number = document.getElementById("fnumber").value;
			if(number == "") flag = false;
			if(!flag){
				document.getElementById("fnumber").focus();
				document.getElementById("message").innerHTML = "Empy number. Please enter a number.";
				return flag;
			}	
			
			var city = document.getElementById("fcity").value;
			if(city == "") flag = false;
			if(!flag){
				document.getElementById("fcity").focus();
				document.getElementById("message").innerHTML = "Empy city. Please enter a city.";
				return flag;
			}	
			
			var country = document.getElementById("fcountry").value;
			if(country == "") flag = false;
			if(!flag){
				document.getElementById("fcountry").focus();
				document.getElementById("message").innerHTML = "Empy country. Please enter a country.";
				return flag;
			}	
			
			return flag;
		}