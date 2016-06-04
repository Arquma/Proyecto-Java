<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List"%>
<%@ page import="com.ucr.GimnasioXyzLibraryB05027.Domain.Ejercicio"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.js"></script>
<title>Insertar Nueva Rutina</title>
</head>
<body>
	
			<div class="container">
				<h1>Insertar Rutina</h1>
			</div>
	
	
<div class="container">
	<form class="form-horizontal" role="form">
	   
	   
	   <div class="form-group">
	  		<label for="comment" class="control-label col-sm-2">Cliente: </label>
	  		<div class="col-sm-6">  
			     <select class="form-control" id="clientes">
				    
				  </select>
			 </div>
		  </div>
	   
	    <div class="form-group">
	  		<label for="comment" class="control-label col-sm-2">Objetivo: </label>
	  		<div class="col-sm-6">  
			     <select class="form-control">
				      <option>Hipertrofia</option>
				      <option>Resistencia</option>
				      <option>Fuerza</option>
				      <option>Perdida de Peso</option>
				  </select>
			  </div>
		  </div>
	   
	     <div class="form-group">
	  		<label for="comment" class="control-label col-sm-2">Enfermadades del Cliente: </label>
	  		<div class="col-sm-6">    
	  		<textarea class="form-control"  rows="4" id="direccion" placeholder="Ingresar lessiones o enfermedades que padece el cliente"></textarea>
	  		</div>
		</div>
		
		<div class="panel panel-default form-group">
			  <!-- Default panel contents -->
			  <div class="panel-heading">
			  	<div class="form-group">
	  		<label for="comment" class="control-label col-sm-3">Ejercicios Disponibles </label>
		  		<div class="col-sm-6">  
				     <div class="dropdown">
					    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Seleccionar
					    <span class="caret"></span></button>
					    <ul class="dropdown-menu">
					    	<li><a href="#">Desplantes</a></li>
				      		<li><a href="#">Press Militar</a></li>
					    </ul>
					 </div>
				 </div>
				 
				 
			 	 </div>
			  </div>
			  <div class="panel-body">
			    <p>Ejercicios de la Rutina</p>
			  </div>
			
			  <!-- Table -->
			  <div class="table-responsive">        
			  <table class="table">
			    	<thead> 
				    	<tr> 
					    	<th>#</th>
					    	<th>Ejercicio</th> 
					    	<th>Categoria</th> 
					    	<th>Series</th> 
					    	<th>Repeticiones</th> 
					    	<th>Descanso<footer><small>Series/Repeticiones</small></footer></th> 
					    	<th>Eliminar</th> 
				    	</tr> 
			    	 </thead>
			    	 </tbody>
			    	 	<tr> 
					    	<td>02</td>
					    	<td>Flexión de Codo</td> 
					    	<td>Biceps</td> 
					    	<td>4</td> 
					    	<td>12</td> 
					    	<td>1 min / 3 seg</td> 
					    	<td>  <button type="submit" class="btn btn-danger" id="btnGuardar"><span class="glyphicon glyphicon-remove"></span></button>
</td> 
				    	</tr> 
			    	 </tbody>
			  </table>
			  </div>
		</div>
		
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-6">
	        <button type="submit" class="btn btn-success" id="btnGuardar">Guardar</button>
	      </div>
	    </div>
  </form>
  
</div>

	<script>
		$(function()
			{
			    $.ajax({
			    	url: "clientes",
			    	dataType: "json",
			    	type: 'GET',
			    	success: function(result)
			    	{
			    		var data = $(result);
			    		$( data ).each(function( index, info ) {
			        		$("#clientes").append("<option>"+info.nombreCliente +" "+ info.apellidoCliente+"</option>");
			        		
			        	});
			        	
			        	
			   		 },
				    error: function(xhr){
				        alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
				    }
			    });
			});
	</script>


</body>



</html>