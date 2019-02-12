<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<p>Generate Report</p>
	<span name="generatedatetext" id="generatedatetextstyle">Select the date</span>
	<form action ="TransferGetServlet" method = "post">
			<input type="date" name="generatedate" id="generatedatestyle" value="DD/MM/YYYY"/>
			<input type="submit" name="generatedatesubmit" id ="generatedatesubmitstyle" value="Generate"/>
			</form>
	
	<table name="generatetext" id="generatetextstyle">
		<tr id="insertgeneratetextstyle">
			<td>A/C Number</td>
			<td>Beneficiary A/C Number</td>
			<td>Transaction Amount</td>
		</tr>
	</table>
	</center>
</body>
</html>