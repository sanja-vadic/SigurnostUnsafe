<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Page Unsafe</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h3>Unsafe application</h3>
	<form action="" method="POST">
		<input type="text" name="username" placeholder="Username..." id="loginUsername"><br />
		<input type="password" name="password" placeholder="Password..." id="loginPassword"><br />
		<input type="submit">
	</form>
</body>
</html>