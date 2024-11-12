<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer SignUp</title>
</head>
<body style="background-color: pink">

	<form action="CustomerController" method="get"
		style="text-align: center;">
		<input type="hidden" name="action" value="signup"> Customer
		Name<input type="text" name="custname"><br> Customer
		Address<input type="text" name="custaddress"><br> Contact
		Number<input type="text" name="custcontactnumber"><br>
		Account Balance<input type="text" name="custaccountbalance"><br>
		Gender<br> Male<input type="radio" name="custgender" value="Male"><br>
		Female<input type="radio" name="custgender" value="Female"><br>
		Customer DOB<input type="text" name="custdob"><br>
		EmailId<input type="text" name="custemailid"><br>
		Password<input type="password" name="custpassword"><br> <input
			type="submit" value="SignUp"> <input type="reset"
			value="Clear">
	</form>
</body>
</html>