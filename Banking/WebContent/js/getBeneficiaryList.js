/**
 * 
 */
function getbeneficiary()
{
	document.getElementById("BeneficiaryStyle").disabled = false;
	var url = 'BeneficiaryServlet';
	var val="";
	var param = "BeneficiaryStyle="+val;
	var xmlHttp;
	var l =document.getElementById("BeneficiaryStyle").options.length;
	for(i=0;i<l;i++)
	{
		document.getElementById("BeneficiaryStyle").remove(0);
	}
		if(window.XMLHttpRequest)
		{
			xmlHttp = new XMLHttpRequest();
		}
		else if(window.ActiveXObject)
		{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
/*		window.alert(url);
		xmlHttp.open("post", url, true);*/
		xmlHttp.open("POST",url, true);
		/* xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); */
		var res = xmlHttp.responseText;
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
				var data = res.split("-");
				var arr;
				var opt;
				opt = document.createElement("OPTION");
				for(i = 0;i<data.length-1;i++)
				{
					arr=data[i];
					/* opt = new Option(arr);
					document.getElementByid("CountryDropStyle").options.add(opt); */
					/*opt = document.createElement("OPTION");
					opt.text = arr;*/
					
					opt = new Option(arr+" Account",i);
					document.getElementById("BeneficiaryStyle").options.add(opt);
				}
			}
			
		}
}