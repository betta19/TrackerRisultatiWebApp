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
<title></title>
</head>
<body>

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
	<form action="tornaIndietro" method = "post">
  <input type="submit"  class="btn btn-outline-secondary btn-block" style="width:150px; height:50px;margin:auto" value="Torna Indietro">
</form>
	
</body>
</html>