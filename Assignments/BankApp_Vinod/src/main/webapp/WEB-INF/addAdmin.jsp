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

<sform:form action="addAdmin" method="post"   modelAttribute="admin5">
<table>
	<caption><h2>Add Admin Form</h2></caption>
	<tr><th>name</th><td><sform:input  path="name"/></td></tr>	
	<tr><td colspan='2'><input type="submit"/></td></tr>
</table>
	
</sform:form>
<hr>
<table>
<caption><h2>List of Admins</h2></caption>
		<tr>
                <th>Admin Id</th>
                <th>Name</th>                                
            </tr>
            <c:forEach var="admin" items="${admins}">
                <tr>
                    <td><c:out value="${admin.id}" /></td>
                    <td><c:out value="${admin.name}" /></td>                                        
                </tr>
            </c:forEach>
        </table>


</body>
</html>