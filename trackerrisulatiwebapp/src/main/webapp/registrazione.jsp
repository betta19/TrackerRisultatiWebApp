<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
	<form action="registrazione" method="post" enctype="multipart/form-data">
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