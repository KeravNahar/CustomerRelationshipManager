<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
<div id ="wrapper">
<div id ="header">
<h1>CRM - Customer Relationship Manager</h1>
<h2>Add Customers</h2>
</div>
<form action="AddCustomerController">
Enter First Name: <input type="text" name="fname"><br><br>
Enter Last Name: <input type="text" name="lname"><br><br>
Enter Email Address: <input type="text" name="email"><br><br>
<input type="submit" name="SAVE"><br><br>

</form>
</div>
</body>
</html>