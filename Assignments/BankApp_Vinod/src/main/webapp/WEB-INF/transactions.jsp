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

<table>
<caption><h2>List of Transactions</h2></caption>
		<tr>
                <th>Transaction Id</th>
                <th>Decription</th>
                <th>Transaction Date</th>                
                <th>Credit</th>
                <th>Debit</th>
                <th>Balance</th>
            </tr>
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td><c:out value="${transaction.transactionId}" /></td>
                    <td><c:out value="${transaction.description}" /></td>
                    <td><c:out value="${transaction.transactionDate}" /></td>                    
                    <td><c:out value="${transaction.credit}" /></td>
                    <td><c:out value="${transaction.debit}" /></td>
                    <td><c:out value="${transaction.totalbalance}" /></td>
                </tr>
            </c:forEach>
        </table>


</body>
</html>