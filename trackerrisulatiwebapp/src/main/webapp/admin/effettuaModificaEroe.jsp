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
	<div class="bgtl"> <br> <br> <br> <br> <br> <br> <br> 
		<div class="container">
			<div class="row">
				<div class="col-8 align-self-center ">
					<img width="400" height="500"
						src="data:image/png;base64,<c:out value="${eroi.getImmagine()}" />">
				</div>
				<div class="col-4">
					<form action="modificaEroe" method="post"
						enctype="multipart/form-data">

						<h5><p class="text-xl text-warning">Nome</p></h5>
						<input type="text" class="form-control" id="nome" name="nome"
							value="<c:out value="${eroi.getNome()}" />"
							style="width: 250px; height: 50px; display: inline-block;"
							placeholder="Nome"> <br> <br>
<h5><p class="text-xl text-warning">Costo Hero Power</p></h5>
						 <select name="heroPower">


									<option value="<c:out value="${eroi.getHeroPower()}" />">
										${eroi.getHeroPower()}</option>
									<option value="passivo">Passivo</option>
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>


								</select> <br> <br>
							

						
						<h5><p class="text-xl text-warning">Hero Descrizione</p></h5>
						<input type="text" class="form-control" id="heroDescrizione"
							name="heroDescrizione"
							value="<c:out value="${eroi.getHeroDescrizione()}" />"
							style="width: 250px; height: 50px; display: inline-block"
							placeholder="Hero Power"> <br><br>


						<p class="text-xl">
							<label for="file-upload" class="custom-file-upload">
								Cambia Immagine </label> <input type="file" id="file-upload"
								name="image">

						</p>

<br>
						<br> <input type="submit"
							class="btn btn-warning btn-block"
							style="width: 150px; height: 45px" name=action
							value="Effettua modifica"> <input type="hidden"
							id="nomeVecchio" name="nomeVecchio"
							value="<c:out value='${eroi.getNome()}'></c:out>" />

					</form>


					<br> <br>


					<form action="indietro" method="post">
						<input type="submit" class="btn btn-primary btn-block"
							style="width: 150px; height: 50px;"
							value="Torna Indietro">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>