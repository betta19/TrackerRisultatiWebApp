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
<div class="container">
		<div class="row">
		
			<div class="col-xl align-self-center ">
	<form action="modificaComp" method="post">
	
		<p class="text-xl-center">Inserisci nome</p>
		<input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${comp.getNome()}" />"
			style="width: 250px; height: 50px; margin: auto" placeholder="Nome">
		
		<br> <input type="submit"
			class="btn btn-outline-primary btn-block"
			style="width: 150px; height: 45px; margin: auto" name=action
			value="Effettua modifica">
			<input type="hidden" id="nomeVecchioC" name="nomeVecchioC"
            value="<c:out value='${comp.getNome()}'></c:out>"/>

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