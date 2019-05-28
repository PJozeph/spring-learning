<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
	
	Firstname : <form:input path="firstName"/>
	<br><br>
	Last name : <form:input path="lastName"/>
	<br><br>
	Country :
	<form:select path="country">
	
		<form:options items="${student.countryOptions}" />
		
	</form:select>
	
	<br><br>
	Favorite language :
	Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	C <form:radiobutton path="favoriteLanguage" value="C"/>
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
	<br><br>
	Operatin Systems:
	Linux <form:checkbox path="operatingSystem" value="linux"/>
	Mac <form:checkbox path="operatingSystem" value="mac"/>
	Ms Windows <form:checkbox path="operatingSystem" value="windows"/>
		
	<br><br>
	
	<input type="submit" value="Submit">
	
	</form:form>
	
</body>
</html>