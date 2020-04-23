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
		<%
			String nomeEroe = (String) request.getAttribute("eroe");
		%>
		<div class="container">
			<div class="row">
				<div class="col">
					<table class="table table-striped">

						<tr>
							<th><h5>
									<p class="text-md text-warning">Eroe</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">Composizione</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">Classifica</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">Punti</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">Note</p>
								</h5></th>
						</tr>
						<c:forEach items="${listaPartite}" var="singolaPartita">

							<tr>
								<td><h5>
										<p class="text-md text-white">${singolaPartita.getEroe().getNome()}</p>
									</h5></td>
								<td><h5>
										<p class="text-md text-white">${singolaPartita.getComp().getNome()}</p>
									</h5></td>
								<td><h5>
										<p class="text-md text-white">${singolaPartita.getPosizioneFinale()}</p>
									</h5></td>
								<td><h5>
										<p class="text-md text-white">${singolaPartita.getRating()}</p>
									</h5></td>
								<td><h5>
										<p class="text-md text-white">${singolaPartita.getNotePersonali()}</p>
									</h5></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="col">
					<br> <br>
					<br> <br>
					<table class="table table-striped">

						<tr>
							<th><h5>
									<p class="text-md text-warning">Totale partite giocate</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">% Top 4</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">Vittorie</p>
								</h5></th>
						</tr>


						<tr>
							<td><h5>
									<p class="text-md text-white"><%=(long) request.getAttribute("totale")%></p>
								</h5></td>
							<td><h5>
									<p class="text-md text-white"><%=(int) request.getAttribute("top4")%>%
									</p>
								</h5></td>
							<td><h5>
									<p class="text-md text-white"><%=(int) request.getAttribute("win")%></p>
								</h5></td>
						</tr>

					</table>

					<table class="table table-striped">

						<tr>
							<th><h5>
									<p class="text-md text-warning">Rating Iniziale</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">Rating Attuale</p>
								</h5></th>

						</tr>


						<tr>

							<td><h5>
									<p class="text-md text-white"><%=(long) request.getAttribute("ratingIniziale")%></p>
								</h5></td>
								<td><h5>
									<p class="text-md text-white"><%=(long) request.getAttribute("currentRating")%></p>
								</h5></td>
							

						</tr>

					</table>
					<br> <br>
					<br> <br>
					<form action="gestioneCliente" method="post">
						 <select name="eroe">

									<c:forEach items="${listaEroi}" var="singoloEroe">
										<c:out value="${singoloEroe.getNome()}" />
										<option value="${singoloEroe.getNome()}">
											${singoloEroe.getNome()}</option>
									</c:forEach>


								</select> <br> <br>
							
						<input type="submit" class="btn btn-warning"
							style="width: 250px; height: 40px; margin: auto" name="azione"
							value="Vedi statistiche eroe">
					</form>
					<br> <br>
					<table class="table table-striped">

						<tr>
							<th><h5>
									<p class="text-md text-warning">Nome Eroe</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">Totale partite giocate</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">% Top 4</p>
								</h5></th>
							<th><h5>
									<p class="text-md text-warning">Vittorie</p>
								</h5></th>
						</tr>


						<tr>
							<%
								if (nomeEroe == null) {
							%>
							<td><h5>
									<p class="text-md text-white">Scegli un Eroe</p>
								</h5></td>
							<%
								} else {
							%>
							<td><h5>
									<p class="text-md text-white"><%=nomeEroe%></p>
								</h5></td>
							<%
								}
							%>
							<td><h5>
									<p class="text-md text-white"><%=(long) request.getAttribute("totaleEroe")%></p>
								</h5></td>
						<td><h5>
									<p class="text-md text-white"><%=(int) request.getAttribute("top4Eroe")%>%</p>
								</h5></td>
							<td><h5>
									<p class="text-md text-white"><%=(int) request.getAttribute("winEroe")%></p>
								</h5></td>
							
						</tr>

					</table>

					<form action="tornaIndietro" method="post">
						<input type="submit" class="btn btn-primary btn-block"
							style="width: 150px; height: 50px; margin: auto"
							value="Torna Indietro">
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>