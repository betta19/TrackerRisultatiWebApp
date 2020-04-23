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
		String mess = (String) request.getAttribute("mess");
		if (mess != null) {
	%>
	<h4>
		<p class="text-md-center text-white"><%=mess%></p>
	</h4>


	<%
		}
	%><br>
	<div class="container">
		<div class="row">
		<div class="col-6 align-self-center ">
	<table class="table table-striped">

					
						<tr>
				<th><h5>
						<p class="text-md text-warning">Nome</p>
					</h5></th>
				<th><h5>
						<p class="text-md text-warning">Immagine</p>
					</h5></th>
				<th><h5>
						<p class="text-md text-warning">Costo Hero Power</p>
					</h5></th>
				<th><h5>
						<p class="text-md text-warning">Hero Power</p>
					</h5></th>

			</tr>
						
					
					<c:forEach items="${listaEroi}" var="singoloEroe">

						<tr>
					<td><h5>
							<p class="text-md text-white">${singoloEroe.getNome()}</p>
						</h5></td>
					<td><img width="120" height="150"
						src="data:image/png;base64,<c:out value="${singoloEroe.getImmagine()}" />">
					</td>
					<td><h5>
							<p class="text-md text-white">${singoloEroe.getHeroPower()}</p>
						</h5></td>
					<td><h5>
							<p class="text-md text-white">${singoloEroe.getHeroDescrizione()}</p>
						</h5></td>


				</tr>
					</c:forEach>
				</table>
	</div>
	<div class="col-2 align-self-center ">
	</div>
			<div class="col-4 align-self-center ">
	<form action="aggiungiEroe" method="post" enctype="multipart/form-data">

		<h5><p class="text-xl text-warning">Nome Eroe</p></h5>
		<input type="text" class="form-control" id="nome" name="nome"
			style="width: 250px; height: 50px; display: inline-block " placeholder="Nome">
		<br><br>	<h5><p class="text-xl text-warning">Costo Hero Power</p></h5>
		 <select name="heroPower"  >



					<option value="passivo">Passivo</option>
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>


				</select> <br> <br>
		
		
			<h5><p class="text-xl text-warning">Descrizione Hero Power</p></h5>
		<input type="text" class="form-control" id="heroDescrizione"
			name="heroDescrizione"
			style="width: 250px; height: 50px; display:inline-block"
			placeholder="Hero Power"> <br><br><br>
		<p class="text-xl">
		<label for="file-upload" class="custom-file-upload">
  Carica Immagine
</label>  <input  type="file" id="file-upload" name="image">

			
		</p>

<br>
		<br> <input type="submit"
			class="btn btn-warning btn-block"
			style="width: 150px; height: 45px;" name=action
			value="Aggiungi">


	</form>
	
	
	<br>
	


	<form action="indietro" method="post">
		<input type="submit" class="btn btn-primary btn-block"
			style="width: 150px; height: 50px; "
			value="Torna Indietro">
	</form>
	</div>
	</div>
	</div>
	</div>
</body>
</html>