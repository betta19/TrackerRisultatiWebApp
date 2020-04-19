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
		String nomeEroe = (String) request.getAttribute("eroe");
	%>
	<div class="container">
		<div class="row">
			<div class="col-xl align-self-center ">
				<table class="table table-striped">

					<tr>
						<th>Eroe</th>
						<th>Composizione</th>
						<th>Rank</th>
						<th>Punti</th>
						<th>Note</th>
					</tr>
					<c:forEach items="${listaPartite}" var="singolaPartita">

						<tr>
							<td><c:out value="${singolaPartita.getEroe()}" /></td>
							<td><c:out value="${singolaPartita.getComp()}" /></td>
							<td><c:out value="${singolaPartita.getPosizioneFinale()}" /></td>
							<td><c:out value="${singolaPartita.getRating()}" /></td>
							<td><c:out value="${singolaPartita.getNotePersonali()}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-xl align-self-center ">
				<table class="table table-striped">

					<tr>
						<th>Totale Partite giocate</th>
						<th>Percentuale Top 4</th>
						<th>Vittorie</th>
					</tr>


					<tr>
						<td><%=(long) request.getAttribute("totale")%></td>
						<td><%=(int) request.getAttribute("top4")%>%</td>
						<td><%=(int) request.getAttribute("win")%></td>
					</tr>

				</table>
				<form action="gestioneCliente" method="post">
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm"><label
								for="eroe">Eroe</label></span> <select name="eroe">

								<c:forEach items="${listaEroi}" var="singoloEroe">
									<c:out value="${singoloEroe.getNome()}" />
									<option value="${singoloEroe.getNome()}">
										${singoloEroe.getNome()}</option>
								</c:forEach>


							</select> <br> <br>
						</div>
					</div>
					<input type="submit" class="btn btn-outline-primary btn-block"
						style="width: 150px; height: 40px; margin: auto" name="azione"
						value="Vedi statistiche">
				</form>
				<table class="table table-striped">

					<tr>
						<th>Nome Eroe</th>
						<th>Totale Partite giocate</th>
						<th>Percentuale Top 4</th>
						<th>Vittorie</th>
					</tr>


					<tr>
						<%
							if (nomeEroe == null) {
						%>
						<td>Scegli eroe</td>
						<%
							}
							else {
						%>
						<td><%=nomeEroe%></td>
						<%
							}
						%>
						<td><%=(long) request.getAttribute("totaleEroe")%></td>
						<td><%=(int) request.getAttribute("top4Eroe")%>%</td>
						<td><%=(int) request.getAttribute("winEroe")%></td>
					</tr>

				</table>

			</div>
		</div>
	</div>
	<form action="tornaIndietro" method="post">
		<input type="submit" class="btn btn-outline-secondary btn-block"
			style="width: 150px; height: 50px; margin: auto"
			value="Torna Indietro">
	</form>

</body>
</html>