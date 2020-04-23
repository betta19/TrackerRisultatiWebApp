<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<div class="bgtl">
	<br>
		<br><br>
		<br>
		<%
			session.getAttribute("username");
		%>

		<br>
	<br>
		<br>
		<br>
		<br>
		<%
			String mess = (String) request.getAttribute("mess");
			if (mess != null) {
		%>
		<h4>
			<p class="text-md-center text-white"><%=mess%></p>
		</h4>
		<%
			}
		%><br>
		<br>
		<form action="login" method="post">
			<div class="login">
				<h4><p class="text-xl-center text-warning">Inserisci la tua mail</p></h4>
				<input type="text" class="form-control" id="mail" name="mail"style="width: 250px; height: 50px; margin: auto"
					 placeholder="Mail">
					<br>
				<h4><p class="text-xl-center text-warning">Inserisci la tua password</p></h4>
				<input type="password" class="form-control " id="password"
					name="password" style="width: 250px; height: 50px; margin: auto"
					placeholder="Password">
			</div>
			<br> <input type="submit"
				class="btn btn-warning btn-block"
				style="width: 150px; height: 45px; margin: auto" name=action
				value="Accedi">

		</form>
		<br>
		<br>





		<%
			String path = request.getContextPath();
		%>
		<form action="<%=path%>/" method="post">
			<input type="submit" class="btn btn-primary btn-block"
				style="width: 150px; height: 50px; margin: auto"
				value="Torna Indietro">
		</form>
	</div>
</body>
</html>