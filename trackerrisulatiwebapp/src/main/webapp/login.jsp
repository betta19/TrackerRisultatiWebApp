<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%session.getAttribute("username");%>

<br>
<h2><p class="text-xl-center">Effettua Login</p></h2><br><br>
<% String mess = (String) request.getAttribute("mess"); 
	if (mess != null ){
		%>
	<h4><p class="text-md-center text-danger"><%=mess%></p></h4>
		
					
	<% }
	


%><br>
<form action="login" method="post">
  <div class="login">
    <p class="text-xl-center">Inserisci la tua mail</p>
    <input type="text" class="form-control" id="mail" name="mail" style="width:250px; height:50px;margin:auto" placeholder="Mail">
      <p class="text-xl-center">Inserisci la tua password</p>
    <input type="password" class="form-control " id="password" name="password" style="width:250px; height:50px;margin:auto" placeholder="Password">
</div>
 <br> <input type="submit"class="btn btn-outline-primary btn-block" style="width:150px; height:45px;margin:auto" name= action value="Accedi">
  
</form>
<br><br>

 
  

  
<form action="home.jsp">
  <input type="submit"  class="btn btn-outline-secondary btn-block" style="width:150px; height:50px;margin:auto" value="Torna Indietro">
</form>

</body>
</html>