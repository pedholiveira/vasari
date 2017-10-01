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
    				<td><a href="${pageContext.request.contextPath}/admin/saveUser?id=${user.id }">Update</a></td>
    				<td><a href="${pageContext.request.contextPath}/admin/deleteUser?id=${user.id }">Delete</a></td>
    			</tr>
			</c:forEach>
    	</tbody>
    </table>
	<br/>
	<a href="${pageContext.request.contextPath}/admin/saveUser">New user</a>
  </body>
</html>