<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cust SignIn</title>
</head>
<body style="background-color: blue">
<form action="CustomerController" method="get">
<input type="hidden" name="action" value="signin">

<label>Customer Email</label>
<input type="text" name="custemailid"><br>

<label>Customer Password</label>
<input type="text" name="custpassword"><br>

 <input type="submit" value="SignIn">

</form>
</body>
</html>