<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../style.css">
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
<%
		String messaggio = (String) request.getAttribute("messaggio");
		if (messaggio != null) {
	%>

	<h5><p class="text-md-center text-white"><%=messaggio%></p></h5>

	<%
		}
	%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-xl align-self-center ">
				<table class="table table-striped">

					<tr>
						<th><h5><p class="text-md text-warning">Nome</p></h5></th>
						<th><h5><p class="text-md text-warning">Elimina</p></h5></th>
						<th><h5><p class="text-md text-warning">Modifica</p></h5></th>
					</tr>
					<c:forEach items="${listaComp}" var="singoloComp">

						<tr>
							<td><h5><p class="text-md text-white"><c:out value="${singoloComp.getNome()}" /></p></h5></td>
							<td>
								<form action="gestioneAdmin" method="post">
									<input type="submit" class="btn btn-danger"
										name="azione" value="Elimina Comp">
										<input type="hidden" id="nomeC" name="nomeC"
						value="<c:out value='${singoloComp.getNome()}'></c:out>"/>
								</form>
							</td>
							<td>
								<form action="gestioneAdmin" method="post">
									<input type="submit" class="btn btn-info"
										name="azione" value="Modifica Comp">
										<input type="hidden" id="nomeC" name="nomeC"
						value="<c:out value='${singoloComp.getNome()}'></c:out>"/>
								</form>
							</td>
						
						</tr>
					</c:forEach>
				</table>
				<br>
				<form action="indietro" method="post">
				
		<input type="submit" class="btn btn-primary btn-block"
			style="width: 150px; height: 50px; margin: auto"
			value="Torna Indietro">
	</form>
	
	</div></div></div></div>
</body>
</html>