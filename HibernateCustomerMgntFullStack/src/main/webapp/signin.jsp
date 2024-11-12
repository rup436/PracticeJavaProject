<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer SignIn</title>
</head>
<body style="background-color: gray">

<%
    if(null!=request.getAttribute("message"))
    {
        out.println(request.getAttribute("message"));
    }
%>

<form action="CustomerController" method="get" style="text-align: center;">
<input type="hidden" name="action" value="signin">

EmailId<input type="text" name="custemailid"><br>
Password<input type="password" name="custpassword"><br>

<input type="submit" value="SignIn">

</form>

</body>
</html>