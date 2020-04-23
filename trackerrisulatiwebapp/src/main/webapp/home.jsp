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
	<div class="bg">
		<div class="container">
			<div class="row">
				<div class="col">

					<%
						String messaggio = (String) request.getAttribute("messaggio");
						if (messaggio != null) {
					%>

					<p class="text-md-center text-danger"><%=messaggio%></p>

					<%
						}
					%>
					<br>
					<h1><br> <br><br> <br><br>
						<p class="text-xl-center text-warning">Fai il login o registrati!</p>
					</h1>
				</div>
			</div>

			<div class="row">
		 <br><br> <br><br> <br><br> <br><br> <br><br> <br><br> <br><br> <br><br> <br>
				<div class="col-sm align-self-end">		
					<div class="float-right">

						<form action="login.jsp" method="post">

							<input type="submit" class="btn btn-outline-warning btn-block"
								style="width: 250px; height: 70px; margin: auto" name="azione"
								value="Login">
						</form>

					</div>
				</div>
				<div class="col-sm align-self-end">
					<div class="float-left">
						<form action="registrazione.jsp" method="post">

							<input type="submit" class="btn btn-outline-warning btn-block"
								style="width: 250px; height: 70px; margin: auto" name="azione"
								value="Registrati">
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>