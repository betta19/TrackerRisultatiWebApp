<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Registrati!</title>
</head>
<body>
	<%
		String messaggio = (String) request.getAttribute("mess");
		if (messaggio != null) {
	%>

	<p class="text-md-center text-danger"><%=messaggio%></p>

	<%
		}
	%>
	<br>
	<h2>
		<p class="text-xl-center">Registrati!</p>
	</h2>
	<br>
	<br>
	<form action="registrazione" method="post">
		<div class="cliente">

			<p class="text-xl-center">Mail</p>
			<input type="text" class="form-control" id="mail" name="mail"
				style="width: 250px; height: 50px; margin: auto" placeholder="Mail">
		</div>
		<br>
		<div class="cliente">
			<p class="text-xl-center">Password</p>
			<input type="password" class="form-control" id="password"
				name="password" style="width: 250px; height: 50px; margin: auto"
				placeholder="Password">
		</div><br>
		
		
		<input type="submit" class="btn btn-outline-primary btn-block"
			style="width: 150px; height: 45px; margin: auto" name="azione"
			value="Registrati">
	</form>
	<br>
	<br>

</body>
</html>