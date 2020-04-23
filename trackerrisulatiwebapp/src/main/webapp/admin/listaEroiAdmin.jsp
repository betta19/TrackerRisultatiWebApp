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
<title>Insert title here</title>
</head>
<body>
	<div class="bgtl">
		<br>
		<%
			String messaggio = (String) request.getAttribute("messaggio");
			if (messaggio != null) {
		%>

		<p class="text-md-center text-white"><%=messaggio%></p>

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
							<th><h5><p class="text-md text-warning">Immagine</p></h5></th>
							<th><h5><p class="text-md text-warning">Costo Hero Power</p></h5></th>
							<th><h5><p class="text-md text-warning">Descrizione Hero Power</p></h5></th>
							<th><h5><p class="text-md text-warning">Elimina</p></h5></th>
							<th><h5><p class="text-md text-warning">Modifica</p></h5></th>
						</tr>
						<c:forEach items="${listaEroi}" var="singoloEroe">

							<tr>
								<td><h5><p class="text-md text-white"><c:out value="${singoloEroe.getNome()}" /></p></h5></td>
								<td><img width="45" height="60"
									src="data:image/png;base64,<c:out value="${singoloEroe.getImmagine()}" />">
								</td>
								<td><h5><p class="text-md text-white"><c:out value="${singoloEroe.getHeroPower()}" /></p></h5></td>
								<td><h5><p class="text-md text-white"><c:out value="${singoloEroe.getHeroDescrizione()}" /></p></h5></td>
								<td>
									<form action="gestioneAdmin" method="post">
										<input type="submit" class="btn btn-danger"
											name="azione" value="Elimina"> <input type="hidden"
											id="nomeE" name="nomeE"
											value="<c:out value='${singoloEroe.getNome()}'></c:out>" />
									</form>
								</td>
								<td>
									<form action="gestioneAdmin" method="post">
										<input type="submit" class="btn btn-info"
											name="azione" value="Modifica"> <input type="hidden"
											id="nomeE" name="nomeE"
											value="<c:out value='${singoloEroe.getNome()}'></c:out>" />
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
				</div>
</body>
</html>