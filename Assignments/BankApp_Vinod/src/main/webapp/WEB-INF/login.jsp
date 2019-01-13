<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    

<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
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

<form action="login" method="post">
<table>
	<caption><h2>Login Form</h2> ${SPRING_SECURITY_LAST_EXCEPTION.message}</caption>
	<tr><th>Username</th><td><input  type="text" name="username"/></td></tr>	
	<tr><th>password</th><td><input  type="password" name="password"/></td></tr>
	<tr><td colspan='2'><input type="submit" name="submit" value="submit"/></td></tr>
</table>
	
</form>
<hr>

</body>
</html>