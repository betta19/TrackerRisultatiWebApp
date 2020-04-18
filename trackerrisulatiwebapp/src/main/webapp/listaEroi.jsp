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

<hr>
	<ol>
		<c:forEach items="${listaEroi}" var="singoloEroe">
		<c:out value="${singoloEroe.getNome()}" />
			<img src="data:image/png;base64,<c:out value="${singoloEroe.getImmagine()}" />"> <br>
		</c:forEach>
	</ol>
	<hr>
	
	
</body>
</html>