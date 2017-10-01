<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>User</title>
  </head>
  <body>
  	<form action="${pageContext.request.contextPath}/admin/saveUser" method="post">
  		<input name="id" type="hidden" value="${requestScope.user.id }"/>
  		<label>Username: </label>
  		<input name="username" type="text" value="${requestScope.user.username }" />
  		<br/>
  		<label>Password: </label>
  		<input name="password" type="password" value="${requestScope.user.password }" />
  		<br/>
  		<label>Category: </label>
  		<select name="category">
  			<c:forEach var="category" items="${requestScope.categories }">
  				<option value="${category }">${category }</option>
  			</c:forEach>
  		</select>
  		<br/>
  		<br/>
  		<input value="Save" type="submit" />
  	</form>
  </body>
</html>