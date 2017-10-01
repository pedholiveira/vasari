<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Creating a new user</title>
  </head>
  <body>
  	<form action="${pageContext.request.contextPath}/admin/createUser" method="post">
  		<label>Username: </label>
  		<input name="username" type="text" />
  		<br/>
  		<label>Password: </label>
  		<input name="password" type="password" />
  		<br/>
  		<label>Category: </label>
  		<select name="category">
  			<c:forEach var="category" items="${requestScope.categories }">
  				<option value="${category }">${category }</option>
  			</c:forEach>
  		</select>
  		<br/>
  		<br/>
  		<input value="Create" type="submit" />
  	</form>
  </body>
</html>