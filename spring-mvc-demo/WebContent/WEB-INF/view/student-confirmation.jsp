<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>

	The student is confirmed as ${student.firstName} ${student.lastName}
	<br><br>
	Country : ${student.country}
	<br><br>
	The favorite language ${student.favoriteLanguage}
	<br>
	Operating System(s):
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
		<li>${temp}</li>
		</c:forEach>
	</ul>

</body>
</html>