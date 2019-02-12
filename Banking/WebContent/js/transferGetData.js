/**
 * 
 */
function tranferGet()
{
	var url='TransferGetServlet';
	var val="";
	var param = 'TranferGetServlet='+val;
	if(window.XMLHttpRequest)
	{
		xmlHttp = new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var res = xmlHttp.responseText;
	xmlHttp.send(param);
	xmlHttp.open("POST", url, true);
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
		{
			var res = xmlHttp.responseText;
			if(!res || !res===null)
			{
				var data = res.split("-");
				var arr;
				var opt;
				opt = document.createElement("OPTION");
				for(i = 0;i<data.length-1;i++)
				{
					arr = data[i].split(":");
					insert = document.getElementById("insertgeneratetextstyle");
					new_row = insert.parentNode.insertRow(insert.rowIndex + 1 );
					
					new_row.insertCell(0).innerHTML = arr[0];
					new_row.insertCell(1).innerHTML = arr[1];
					new_row.insertCell(2).innerHTML = arr[2];
				}
			}
			else
			{
				window.alert("There is no records of transfer in the selected date.");
				window.location("fundtransfer.jsp");
			}
			}
		}
}