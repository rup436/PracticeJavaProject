<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cust SignUp</title>
</head>
<body style="background-color: gray">
<form action="CustomerController" method="get">
<input type="hidden" name="action" value="signup">

<label>Customer Name</label>
<input type="text" name="custname"><br>

<label>Customer Address</label>
<input type="text" name="custaddress"><br>

<label>Customer Contact Number</label>
<input type="text" name="custcontactnumber"><br>

<label>Customer Account Balance</label>
<input type="text" name="custaccountbalance"><br>

<label>Customer Gender</label>
Male<input type="radio" name="custgender" value="Male"><br>
Female<input type="radio" name="custgender" value="Female"><br>

<label>Customer DOB</label>
<input type="text" name="custdob"><br>

<label>Customer Email</label>
<input type="text" name="custemailid"><br>

<label>Customer Password</label>
<input type="text" name="custpassword"><br>

 <input type="submit" value="SignUp">
</form>
</body>
</html>