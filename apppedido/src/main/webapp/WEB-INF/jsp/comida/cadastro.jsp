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
	  <h2>Cadastramento de Comidas</h2>
	  
	  <form action="/comida/incluir" method="post">
	  
		<c:import url="/WEB-INF/jsp/produto/cadastro.jsp"/>
		
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" name="vegano" value="true" checked>
		  <label class="form-check-label">Vegano</label>
		</div>		

	    <div class="mb-3 mt-3">
	      <label>Peso:</label>
	      <input type="text" class="form-control" value="99" placeholder="Entre com o seu peso" name="peso">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Ingredientes:</label>
	      <input type="text" class="form-control" value="Arroz com feijão" placeholder="Entre com os seus ingredientes" name="ingredientes">
	    </div>

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>
</body>
</html>