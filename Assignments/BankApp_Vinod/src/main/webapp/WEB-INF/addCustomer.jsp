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
<sform:form action="addCustomer" method="post"  modelAttribute="customer5">
<table>
	<caption><h2>Add Customer Form</h2></caption>
	<tr><th>name</th><td><sform:input  path="name" /></td></tr>	
	<tr><td colspan='2'><input type="submit"/></td></tr>
</table>
	
</sform:form>
<hr>
<table>
<caption><h2>List of Customers</h2></caption>
		<tr>
                <th>Acc No</th>
                <th>Name</th>
                <th>Balance</th>                
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td><c:out value="${customer.accNo}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.balance}" /></td>                    
                </tr>
            </c:forEach>
        </table>


</body>
</html>