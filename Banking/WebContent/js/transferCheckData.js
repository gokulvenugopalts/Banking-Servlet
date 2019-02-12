/**
 * 
 */
function transferCheck()
{
	
	var transferAmt = document.getElementById("transferamtstyle").value;
	window.alert("amt"+transferAmt);
	var id = document.getElementById("AccountStyle");
	var transferAcc = id.options[id.selectedIndex].text;
	var url='TransferServlet?transferAcc='+transferAcc;//+'&transferAmt='+transferAmt;
	window.alert(url);
	var param = 'TranferServlet=';
	if(window.XMLHttpRequest)
	{
		xmlHttp = new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlHttp.open('post',url, true);
	xmlHttp.send(param);
	
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
		{
			/*var l =document.getElementById("CountryStyle").options.length;
			for(i=0;i<l;i++)
				{
				documentgetElementById("CountryStyle").remove(0);
				}*/
			/* document.getElementById("CountryDropStyle").innerHTML=""; */
			var res = xmlHttp.responseText;
			window.alert(res);
			if(!res || !res===null)
			{
				if(res == "1")
				{
					window.alert("Insufficient Amount. Please enter again.");
					return false;
				}
				else if(res == "2")
				{
					if(window.confirm("Transfering INR "+transferAmt+" to "+transferAcc+". Do you want to proceed?"))
					{
						window.alert("Transfering is in process. Please Wait.");
						return true;
					}
					else
						return false;
				}
			}
			else
			{
				window.alert("There was some error in processing your request.");
				return false;
			}
		}
	}
	var res = xmlHttp.responseText;
}