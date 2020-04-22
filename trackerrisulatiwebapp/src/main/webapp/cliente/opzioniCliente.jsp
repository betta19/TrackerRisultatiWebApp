<%@page import="trackerRisulatiWebApp.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="../style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="bgtl">
<div class="container">
<br> <br> <br> <br> <br> <br> <br> <br> <br> <br> 
		<div class="row">
			<div class="col-md-12">
				<h2>
				<%Utente utente = (Utente)session.getAttribute("utente");%>
					<p class="text-md-center text-white">Benvenuto, <%= utente.getMail() %></p>
				</h2>
			</div>
		</div>
	</div>
				<%
					String messaggio = (String) request.getAttribute("mess");
					if (messaggio != null) {
				%>

				<p class="text-md-center text-warning"><%=messaggio%></p>

				<%
					}
				%>
				<br> 
				<% String path = request.getContextPath(); %>
				<form action="<%=path%>/cliente/gestioneCliente" method="post">
					<input type="submit" class="btn btn-warning btn-block"
						style="width: 200px; height: 60px; margin: auto" name="azione"
						value="Crea partita"> <br> <br> <input type="submit"
						class="btn btn-warning btn-block"
						style="width: 245px; height: 60px; margin: auto" name="azione"
						value="Visualizza statistiche partita"><br> <br> <input type="submit"
						class="btn btn-warning btn-block"
						style="width: 200px; height: 60px; margin: auto" name="azione"
						value="Lista Eroi">
							<br> <br>
						<input type="submit"  class="btn btn-primary btn-block" 
						style="width:150px; height:50px;margin:auto" name= "azione" value="Logout">
				</form>
</div>
</body>
</html>