<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Usuário</title>
  </head>
  <body>
  	<c:import url="../../header.jsp" />
  	
  	<form action="${pageContext.request.contextPath}/admin/saveUser" method="post">
  		<input name="id" type="hidden" value="${requestScope.user.id }"/>
  		<label>Apelido: </label>
  		<input name="username" type="text" value="${requestScope.user.username }" required="required" />
  		<br/>
  		<label>Senha: </label>
  		<input name="password" type="password" required="required" />
  		<br/>
  		<label>Categoria: </label>
  		<select name="category" required="required">
  			<c:forEach var="category" items="${requestScope.categories }">
  				<c:choose>
  					<c:when test="${requestScope.user.category eq category }">
		  				<option value="${category }" selected="selected">${category }</option>  					
  					</c:when>
  					<c:otherwise>
  						<option value="${category }">${category }</option>
  					</c:otherwise>
  				</c:choose>
  			</c:forEach>
  		</select>
  		<br/>
  		<br/>
  		<input value="Save" type="submit" />
  	</form>
  	
  	<c:import url="../../footer.jsp" />
  </body>
</html>