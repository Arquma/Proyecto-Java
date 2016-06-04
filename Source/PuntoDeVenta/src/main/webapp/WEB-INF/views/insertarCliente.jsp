<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.js"></script>
<script src="/resources/css/bootstrap.css"></script>

<title>Insertar Cliente</title>
</head>
<body>
	<div class="container">
		<div class="bs-example">
		    <div class="alert alert-success fade in" id=MensajeExito>
		        <a href="#" class="close" data-dismiss="alert">&times;</a>
		        <strong>Success!</strong> El cliente se inserto correctamente.
		    </div>
		</div>
    </div>
	<div class="container">
		<h1>Insertar Cliente</h1>
	</div>
	
	
	<div class="container">
<div class="form-horizontal" >
    <div class="form-group">
      <label class="control-label col-sm-2" for="nombre">Nombre:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="nombre" placeholder="Ingresar el nombre">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="apellidos">Apellidos:</label>
      <div class="col-sm-6">          
        <input type="text" class="form-control" id="apellidos" placeholder="Ingresar los apellidos">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="telefono">Telefono:</label>
      <div class="col-sm-6">          
        <input type="text" class="form-control" id="telefono" placeholder="Ingresar el telefono">
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="fechanacimento">Fecha Nacimiento:</label>
      <div class="col-sm-6">          
        <input type="text" class="form-control" id="fechaNacimiento" placeholder="Año-Mes-Dia">
      </div>
    </div>
    
     <div class="form-group">
  		<label for="comment" class="control-label col-sm-2">Direccion:</label>
  		<div class="col-sm-6">    
  		<textarea class="form-control"  rows="4" id="direccion" placeholder="Ingresar la direccion"></textarea>
  		</div>
	</div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="nombreContacto">Contacto de emergencia:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="contactoEmergencia" placeholder="Ingresar el nombre del contacto">
      </div>
     </div>
      
      <div class="form-group">
      <label class="control-label col-sm-2" for="telefonoEmergencia">Telefono de emergencia:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="telefonoContacto" placeholder="Ingresar el telefono del contacto">
      </div>
      </div>
	
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-6">
        <button type="submit" class="btn btn-success" id="btnGuardar">Guardar</button>
      </div>
    </div>
  </div>
  
	</div>
</body>

<script>
//asi se relacion el evento del boton con el javascript 
window.onload = function()
{
  var botonCrear;
  botonCrear=document.getElementById("btnGuardar");
  botonCrear.onclick= llamadaAjax;//asigna el metodo llamadaAjax al onclick 
  $('#MensajeExito').hide();
}

window.onerror = function(message, url, lineNumber) {
	  // detect if the error is something you know how to handle
	  if (errorCanBeHandled) {
	    // display an error message to the user
	    displayErrorMessage(message);
	    // return true to short-circuit default error behavior
	    return true;
	  } else {
	    // run the default error handling of the browser
	    return false;
	  }
	}



function llamadaAjax()
{
	
	
	$.ajax({
		url: 'cliente',
		data: {
			Nombre: $('#nombre').val(),
			Apellidos: $('#apellidos').val(),
			Telefono: $('#telefono').val(),
			FechaNacimiento: $('#fechaNacimiento').val(),
			Direccion: $('#direccion').val(),
			ContactoEmergencia: $('#contactoEmergencia').val(),
			TelefonoEmergencia: $('#telefonoContacto').val()
			},
		type: 'POST',
		
		 success: function(data) {
			  $('#MensajeExito').show();
			  }, 
			  error: function(data){
			  	alert("error");
			  }
	});
	
	
}
</script>
</html>