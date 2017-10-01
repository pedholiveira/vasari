<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <title>List of users</title>
  </head>
  <body>
    <table>
    	<thead>
    		<tr>
    			<td>Username</td>
    			<td>Category</td>
    			<td></td>
    			<td></td>
    		</tr>
    	</thead>
    	<tbody>
	    	<c:forEach var="user" items="${requestScope.users}">
    			<tr>
    				<td>${user.username }</td>
    				<td>${user.category }</td>
    				<td><a href="#">Editar</a></td>
    				<td><a href="#">Excluir</a></td>
    			</tr>
			</c:forEach>
    	</tbody>
    </table>
  </body>
</html>