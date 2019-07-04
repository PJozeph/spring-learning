<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company home page</title>
</head>
<body>

	Welcome to the home page
	
	<p>
		User : <sec:authentication property="principal.username"/>
		<br><br>
		Roles : <sec:authentication property="principal.authorities"/>
	</p>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST" >
		<input type="submit" value="Logout">
	</form:form>
	
	<hr>
		<sec:authorize access="hasRole('MANAGER')">
			<p>
				<a href="${pageContext.request.contextPath}/leaders"> LeaderShip Meeting (Only for Managers)</a>
			</p>
		</sec:authorize>
		<br>
		<sec:authorize access="hasRole('ADMIN')">
			<p>
				<a href="${pageContext.request.contextPath}/systems"> LeaderShip Meeting (Only for Admin)</a>
			</p>
		</sec:authorize>
	<hr>
</body>
</html>