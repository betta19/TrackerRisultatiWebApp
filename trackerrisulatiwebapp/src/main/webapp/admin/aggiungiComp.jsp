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
<div class="container">
		<div class="row">
		<div class="col-xl align-self-center ">
		<br><br><br>
		</div></div>
		<div class="row">
		<div class="col-xl align-self-center ">
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
	<hr>
	<ul>
		<c:forEach items="${listaComp}" var="singoloComp">
			<li> <h5><p class="text-xl text-warning"><c:out value="${singoloComp.getNome()}" /></p></h5></li>
		</c:forEach>
	</ul>
	<hr>
	</div>
	<div class="col-xl align-self-center ">
	<form action="aggiungiComp" method="post" >

    <h5><p class="text-xl-center text-warning">Inserisci nome</p></h5>
    <input type="text" class="form-control" id="nome" name="nome" style="width:250px; height:50px;margin:auto" placeholder="Nome"> <br>
<br>
  <input type="submit"class="btn btn-warning btn-block" style="width:150px; height:45px;margin:auto" name= action value="Aggiungi">


</form>
<br><br>

  
<form action="indietro" method="post">
  <input type="submit"  class="btn btn-primary btn-block" style="width:150px; height:50px;margin:auto" value="Torna Indietro">
</form>
</div></div></div></div>
</body>
</html>