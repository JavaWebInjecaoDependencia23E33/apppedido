<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>AppPedido</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-3">
	  <h2>Cadastramento de Bebidas</h2>
	  
	  <form action="/bebida/incluir" method="post">
	  
		<c:import url="/WEB-INF/jsp/produto/cadastro.jsp"/>
		
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" name="gelada" value="true" checked>
		  <label class="form-check-label">Gelada</label>
		</div>		

	    <div class="mb-3 mt-3">
	      <label for="tamanho">Tamanho:</label>
	      <input type="text" class="form-control" value="99" id="tamanho" placeholder="Entre com o seu tamanho" name="tamanho">
	    </div>

	    <div class="mb-3 mt-3">
	      <label for="marca">Marca:</label>
	      <input type="text" class="form-control" value="Marca" id="marca" placeholder="Entre com a sua marca" name="marca">
	    </div>

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>
</body>
</html>