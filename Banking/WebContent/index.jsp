<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="loginform" action="LoginServlet" method="post">
		<table>
			<tr><td>
				<span id="logintextstyle">Username: </span><input type="text" name="loginuserfield" id="loginuserstyle"/>
			</td></tr>
			<tr><td>
				<span id="logintextstyle">Password: </span><input type="password" name="loginpassfield" id="loginpassstyle"/>
			</td></tr>
			<tr><td>
				<input type="submit" value="Login"/>
			</td></tr>
		</table>
	</form>
</body>
</html>