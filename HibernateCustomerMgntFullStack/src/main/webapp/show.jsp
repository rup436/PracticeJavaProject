
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>


<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Customer List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>



	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div>
				<a href="http://www.fullstackjavadeveloper.in" class="navbar-brand">
					User Customer Mgnt App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Customer</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">

				<a href="signup.jsp" class="btn btn-success">Add New Customer
					Data</a>
			</div>
			<form action="EmployeeController" method="get">
				<input type="hidden" name="action" value="filterbyaccountbalance">
				<input type="text" name="custaccountbalance"> <input
					type="submit" value="Filter by Balance">
			</form>

			<form action="CustomerController" method="get">
				<input type="hidden" name="action" value="searchbyid"> <input
					type="text" name="custid"> <input type="submit"
					value="Search By Id">
			</form>

			<form action="CustomerController" method="get">
				<input type="hidden" name="action" value="searchbyname"> <input
					type="text" name="custname"> <input type="submit"
					value="Search By Name">
			</form>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th><a href="CustomerController?action=sortbyname">Name</a></th>
						<th>Address</th>
						<th><a href="CustomerController?action=sortbyage">Contact
								Number</a></th>
						<th>Account Balance</th>
						<th>Gender</th>
						<th>DOB</th>
						<th>Email</th>
						<th>Password</th>


						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="customer" items="${customerList}">

						<tr>
							<td><c:out value="${customer.custId}" /></td>
							<td><c:out value="${customer.custName}" /></td>
							<td><c:out value="${customer.custAddress}" /></td>
							<td><c:out value="${customer.custContactNumber}" /></td>

							<td><c:out value="${customer.custAccountBalance}" /></td>
							<td><c:out value="${customer.custGender}" /></td>
							<td><fmt:formatDate value="${customer.custDOB}" type="date"
									pattern="dd-MM-yyyy" /></td>
							<td><c:out value="${customer.custEmailId}" /></td>
							<td><c:out value="${customer.custPassword}" /></td>
							<td><a
								href="CustomerController?action=edit_form&custid=<c:out value='${customer.custId}' />">Update</a>
								<a
								href="CustomerController?action=delete&custid=<c:out value='${customer.custId}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>



			<a href="CustomerController?action=deletealldata">Delete All Data</a>
		</div>
	</div>
</body>
</html>
