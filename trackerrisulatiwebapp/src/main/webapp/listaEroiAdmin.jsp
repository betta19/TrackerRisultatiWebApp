<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String messaggio = (String) request.getAttribute("messaggio");
		if (messaggio != null) {
	%>

	<p class="text-md-center text-danger"><%=messaggio%></p>

	<%
		}
	%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-xl align-self-center ">
				<table class="table table-striped">

					<tr>
						<th>Nome</th>
						<th>Immagine</th>
						<th>Costo HeroPower</th>
						<th>HeroPower</th>
						<th>Elimina</th>
					</tr>
					<c:forEach items="${listaEroi}" var="singoloEroe">

						<tr>
							<td><c:out value="${singoloEroe.getNome()}" /></td>
							<td><img
								width="45" height="45" src="data:image/png;base64,<c:out value="${singoloEroe.getImmagine()}" />" > </td>
							<td><c:out value="${singoloEroe.getHeroPower()}" /></td>
							<td><c:out value="${singoloEroe.getHeroDescrizione()}" /></td>
							<td>
								<form action="gestioneAdmin" method="post">
									<input type="submit" class="btn btn-outline-secondary"
										name="azione" value="Elimina">
										<input type="hidden" id="nomeE" name="nomeE"
						value="<c:out value='${singoloEroe.getNome()}'></c:out>"/>
								</form>
							</td>
						
						</tr>
					</c:forEach>
				</table>
				<br>
				<form action="indietro" method="post">
				
		<input type="submit" class="btn btn-outline-secondary btn-block"
			style="width: 150px; height: 50px; margin: auto"
			value="Torna Indietro">
	</form>
</body>
</html>