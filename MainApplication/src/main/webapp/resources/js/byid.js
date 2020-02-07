/**
 * 
 */


function fvalidator(){

	var flag = true;

	var id = document.getElementById("fid").value;

	if(id == "") flag = false;
	
	if(!flag){
		document.getElementById("fid").focus();
		document.getElementById("message").innerHTML = "Empy Id. Please enter a Id.";
		return flag;
	}	

	return flag;

}