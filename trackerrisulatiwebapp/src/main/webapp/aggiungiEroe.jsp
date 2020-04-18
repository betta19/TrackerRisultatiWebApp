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
<% String mess = (String) request.getAttribute("mess"); 
	if (mess != null ){
		%>
	<h4><p class="text-md-center text-danger"><%=mess%></p></h4>
		
					
	<% }
	


%><br>
	<hr>
	<ol>
		<c:forEach items="${listaEroi}" var="singoloEroe">
			<li><c:out value="${singoloEroe.getNome()}" /></li>
		</c:forEach>
	</ol>
	<hr>
	<form action="aggiungiEroe" method="post" enctype = "multipart/form-data">

    <p class="text-xl-center">Inserisci nome</p>
    <input type="text" class="form-control" id="nome" name="nome" style="width:250px; height:50px;margin:auto" placeholder="Nome"> <br>
      <p class="text-xl-center">Inserisci hero power</p>
    <input type="number" class="form-control" id="heroPower" name="heroPower" style="width:250px; height:50px;margin:auto" placeholder="Hero Power">
 <br> 
  <p class="text-xl-center">Inserisci hero descrizione</p>
    <input type="text" class="form-control" id="heroDescrizione" name="heroDescrizione" style="width:250px; height:50px;margin:auto" placeholder="Hero Descrizione"> <br><p class="text-xl-center"> 
 <input type="file"  id="image" name="image" placeholder="Inserisci immagine hero">
 </p>
   

<br>
  <input type="submit"class="btn btn-outline-primary btn-block" style="width:150px; height:45px;margin:auto" name= action value="Aggiungi">


</form>
<br><br>

  
<form action="opzioniAdmin.jsp">
  <input type="submit"  class="btn btn-outline-secondary btn-block" style="width:150px; height:50px;margin:auto" value="Torna Indietro">
</form>
</body>
</html>