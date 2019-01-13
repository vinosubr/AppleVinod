<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;  
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}

input[type=button], input[type=submit], input[type=reset] {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 8px 16px;
  text-decoration: none;
  margin: 2px 1px;
  cursor: pointer;
}
</style>
</head>
<body>
<a href="/logout">logout</a><br/>
${message}
<sform:form action="transferMoney" method="post"   modelAttribute="transfer5">
<table>
	<caption><h2>Transfer Money</h2></caption>	
	<tr><th>From Customer</th>
		<td><select name="sourceCustId">
			    <c:forEach var="customer" items="${customers}">
			        <option value="${customer.accNo}">${customer.name}</option>
			    </c:forEach>
			</select>
		</td></tr>
	<tr><th>To Customer</th>
				<td>
					<select name="destCustId">
					    <c:forEach var="customer" items="${customers}">
					        <option value="${customer.accNo}">${customer.name}</option>
					    </c:forEach>
					</select>
				</td>
	</tr>
	<tr><th>Amount</th><td><sform:input  path="amount" /></td></tr>	
	<tr><td colspan='2'><input type="submit"/></td></tr>
</table>
	
</sform:form>


</body>
</html>