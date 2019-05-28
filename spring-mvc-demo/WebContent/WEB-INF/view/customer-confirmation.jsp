<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>

	The customer is ${customer.firstName} ${customer.lastName}
	<br><br>
	 Customer free passes is ${customer.freePasses}
	<br><br>
	 Customer's postal code is ${customer.postalCode}
	<br><br> 
	The course code is ${customer.courseCode}

</body>
</html>