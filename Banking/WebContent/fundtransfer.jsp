<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.mindtree.entity.Customers"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/getAccountList.js" type="text/javascript"></script>
<script src="js/getBeneficiaryList.js" type="text/javascript"></script>
<script src="js/getBeneficiaryAccList.js" type="text/javascript"></script>
<script src="js/transferCheckData.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body onload="getAccount(); getbeneficiary();">
<div id="fundtransferhome">
	<h3>Third Party Transfer</h3>
<%-- 	<%Customers cust = new Customers();
	cust.setCustomerid(1);
	cust.setFirstname("abc");
	cust.setLastname("def");
	cust.setPassword("123456");
	cust.setUsername("abc");
	HttpSession session;
	(session.setAttribute("currentUser",cust)); %>
	<p>Welcome, <%cust.getFirstname(); %></p> --%>
	<form id="tranferdetailcheck" name="transferform" onsubmit="return transferCheck();" action="TransferProcessServlet" method="get">
	<table>
		<tr>
			<td><span>Select A/C No with balance</span></td>
			<td><select class="accbox" name="AccountDrop" id="AccountStyle"></select></td>
		</tr>
		<tr>
			<td><span>Select Beneficiary</span></td>
			<td><select class="benbox" name="BeneficiaryDrop" id="BeneficiaryStyle" onchange="getbeneficiaryAcc();"></select></td>
			<td><span>Destination Account no*</span></td>
			<td><select class="benbox" name="BeneficiaryAccDrop" id="BeneficiaryAccStyle"/></select></td>
		</tr>
		<tr>
			<td><span>Transfer Amount</span></td>
			<td><input type="text" name="transferamt" id="transferamtstyle"/></td>
		</tr>
		<tr>
			<td><span>Transfer Details</span></td>
			<td><input type="text" name="transferdetail" id="transferdetailstyle"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="transferlink" id="transferlinkstyle" value="Transfer"/></td>
			
		</tr>
		
	</table>
	<a name="backlink" id="backlinkstyle" href = "home.jsp">Back</a>
</div>
</body>
</html>