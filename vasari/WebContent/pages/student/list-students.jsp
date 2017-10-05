<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <title>Listagem de Alunos</title>
  </head>
  <body>
	<c:import url="../../header.jsp" />
	
    <table>
    	<thead>
    		<tr>
    			<td>Username</td>
    			<td>Category</td>
    		</tr>
    	</thead>
    	<tbody>
	    	<c:forEach var="user" items="${requestScope.users}">
    			<tr>
    				<td>${user.username }</td>
    				<td>${user.category }</td>
    			</tr>
			</c:forEach>
    	</tbody>
    </table>
	
	<c:import url="../../footer.jsp" />
  </body>
</html>