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
	<br>
	<%
		String mess = (String) request.getAttribute("mess");
		if (mess != null) {
	%>
	<h4>
		<p class="text-md-center text-danger"><%=mess%></p>
	</h4>


	<%
		}
	%><br>
	<div class="container">
		<div class="row">
		<div class="col-xl align-self-center ">
	<table class="table table-striped">

					<tr>
						<th>Nome</th>
						<th>Immagine</th>
						<th>Costo HeroPower</th>
						<th>HeroPower</th>
						
					</tr>
					<c:forEach items="${listaEroi}" var="singoloEroe">

						<tr>
							<td><c:out value="${singoloEroe.getNome()}" /></td>
							<td><img
								width="45" height="45" src="data:image/png;base64,<c:out value="${singoloEroe.getImmagine()}" />" > </td>
							<td><c:out value="${singoloEroe.getHeroPower()}" /></td>
							<td><c:out value="${singoloEroe.getHeroDescrizione()}" /></td>
						
						
						</tr>
					</c:forEach>
				</table>
	</div>
			<div class="col-xl align-self-center ">
	<form action="aggiungiEroe" method="post" enctype="multipart/form-data">

		<p class="text-xl-center">Inserisci nome</p>
		<input type="text" class="form-control" id="nome" name="nome"
			style="width: 250px; height: 50px; margin: auto" placeholder="Nome">
		<br>
		<div class="input-group input-group-sm mb-3" >
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-sm" ><label
					for="rank">Inserisci hero power</label></span> <select name="heroPower" >



					<option value="passivo">Passivo</option>
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>


				</select> <br> <br>
			</div>
		</div>
		<br>
		<p class="text-xl-center">Inserisci hero descrizione</p>
		<input type="text" class="form-control" id="heroDescrizione"
			name="heroDescrizione"
			style="width: 250px; height: 50px; margin: auto"
			placeholder="Hero Power"> <br>
		<p class="text-xl-center">
			<input type="file" id="image" name="image"
				placeholder="Inserisci immagine hero">
		</p>


		<br> <input type="submit"
			class="btn btn-outline-primary btn-block"
			style="width: 150px; height: 45px; margin: auto" name=action
			value="Aggiungi">


	</form>
	
	
	<br>
	<br>


	<form action="indietro" method="post">
		<input type="submit" class="btn btn-outline-secondary btn-block"
			style="width: 150px; height: 50px; margin: auto"
			value="Torna Indietro">
	</form>
	</div>
	</div>
	</div>
</body>
</html>