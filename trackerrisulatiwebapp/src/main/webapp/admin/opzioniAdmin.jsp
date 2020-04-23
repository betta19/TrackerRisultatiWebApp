<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../style.css">
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
	<br> <br> <br> <br> <br> <br> <br> <br> <br> 
				<%
					String messaggio = (String) request.getAttribute("messaggio");
					if (messaggio != null) {
				%>

				<h5><p class="text-md-center text-white"><%=messaggio%></p></h5>

				<%
					}
				%>
				<br> 
				<% String path = request.getContextPath(); %>
				<form action="<%=path%>/admin/gestioneAdmin" method="post">
					<input type="submit" class="btn btn-warning btn-block"
						style="width: 200px; height: 60px; margin: auto" name="azione"
						value="Aggiungi eroe"> <br> <br> <input type="submit"
						class="btn btn-warning btn-block"
						style="width: 200px; height: 60px; margin: auto" name="azione"
						value="Aggiungi composizione">
							<br> <br>
							<input type="submit" class="btn btn-warning btn-block"
						style="width: 200px; height: 60px; margin: auto" name="azione"
						value="Gestione Eroe">
						<br> <br>
						<input type="submit" class="btn btn-warning btn-block"
						style="width: 200px; height: 60px; margin: auto" name="azione"
						value="Gestione Comp">
						<br> <br>
						<input type="submit"  class="btn btn-primary btn-block" 
						style="width:150px; height:50px;margin:auto" name= "azione" value="Logout">
				</form>
				</div>
</body>
</html>