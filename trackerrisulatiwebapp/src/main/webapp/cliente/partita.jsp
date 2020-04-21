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
					String messaggio = (String) request.getAttribute("mess");
					if (messaggio != null) {
				%>

				<p class="text-md-center text-danger"><%=messaggio%></p>

				<%
					}
				%>
		<form action="creaPartita" method="post">
<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-sm"><label
					for="eroe">Eroe</label></span> <select name="eroe">
					
	<c:forEach items="${listaEroi}" var="singoloEroe">
	<c:out value="${singoloEroe.getNome()}" />
					<option value="${singoloEroe.getNome()}">
					${singoloEroe.getNome()}
				</option>

						</c:forEach>

				</select> <br>
				<br>
			</div>
		</div>
		<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-sm"><label
					for="comp">Composizione</label></span> <select name="comp">
					
	<c:forEach items="${listaComp}" var="singolaComp">
	<c:out value="${singolaComp.getNome()}" />
					<option value="${singolaComp.getNome()}">
					${singolaComp.getNome()}
				</option>

						</c:forEach>

				</select> <br>
				<br>
			</div>
		</div>
		<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-sm"><label
					for="rank">Rank</label></span> <select name="rank">
					
	
					<%
						for (int i=1; i<9; i++) {
					%>
					<option value="<%=i%>">
						<%=i%></option>

					<%
						}
					%>

				</select> <br>
				<br>
			</div>
		</div>
		
		<input type="text" class="form-control" id="note" name="note" style="width:250px; height:50px;margin:auto" placeholder="Annotazioni"> <br>
		
		<br>
		<input type="number" class="form-control" id="punti" name="punti" style="width:250px; height:50px;margin:auto" placeholder="Punti partita"> <br>
			<input type="submit" class="btn btn-outline-primary btn-block"
						style="width: 300px; height: 60px; margin: auto" name="azione"
						value="Aggiungi">
							
		</form>
		<br>
		<form action="tornaIndietro" method="post">
  <input type="submit"  class="btn btn-outline-secondary btn-block" style="width:150px; height:50px;margin:auto" value="Torna Indietro">
</form>
</body>
</html>