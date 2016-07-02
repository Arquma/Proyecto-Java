<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<html>
<head>
<title><fmt:message key="title" /></title>
<meta name="viewport" content="width=device-width, user-scalable=no">

<link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="<c:url value="/resources/metisMenu.css" />" rel="stylesheet">
<!-- Timeline CSS -->
<link href="<c:url value="/resources/timeline.css" />" rel="stylesheet">
<!-- Custom CSS -->
<link href="<c:url value="/resources/sb-admin-2.css" />"
	rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="<c:url value="/resources/morris.css" />" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">
		<script src="<c:url value="/resources/jquery.min.js" />"></script>
</head>
<body>
	<br />

	
<!--Contenido de la modal -->
<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
               
                <h4 class="modal-title" id="titulo-modal"></h4>
                <spam class="pull-right" id="preciomodal"></spam>
                <input type="hidden" id="productoSeleccionado" value="">
            </div>
            <div class="modal-body" id="modal-body">
                <!--Formulario dentro de la modal -->
               

            </div>
            
        </div>
    </div>
</div><!--Fin contenido de la modal -->


	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">

				<a class="navbar-brand" href="index.html"><fmt:message
						key="title" /></a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">

				<li><a class="icon-flag" href="?language=es">Español</a></li>
				<li><a class="icon-flag-alt" href="?language=en">English</a></li>

			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<br />
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-list-alt fa-fw"></i>
							<fmt:message key="lista_de_venta" />
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="list-group">
								<a href="#" class="list-group-item"> <span
									class="pull-left text-muted small"><em>3</em></span>Lemon<span
									class="pull-right text-muted small"><em>352</em> </span>
								</a> <a href="#" class="list-group-item"> New Comment <span
									class="pull-right text-muted small"><em>2500</em> </span>
								</a>

							</div>
							<!-- /.list-group -->
							<a href="#" class="btn btn-default btn-block">Total <span
								class=" small"><em>2500</em></span>
							</a>
						</div>
						<!-- /.panel-body -->
					</div>
				</div>
				<!-- /.navbar-static-side -->
			</div>
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						<fmt:message key="productos" />
					</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row" id="listaproductos">
				

			</div>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<script>
	

	$( "#listaproductos" ).click(function( event ) {
		var target = $( event.target );
		//  $( "#titulo-modal" ).html( "clicked: " + target.find('input').val() );
		
		$( "#productoSeleccionado" ).val( target.find('input').val() );
		showMessage();
		});
	 function showMessage() {

		 $.ajax({
				url: 'ingredientes',
				data: {
					Id: $('#productoSeleccionado').val()
					},
				type: 'POST',
				
				success: function(result)
		    	{
					
		    		var data = $(JSON.parse(result));
		    		$("#titulo-modal").text(data[0]["nombre"]);
		    		$("#preciomodal").text("Precio: "+data[0]["precio"]);
		    		$("#modal-body").empty();
		    		if(data[0]["preparacion"]==true){
		    			
		    			$("#modal-body").empty();
		    			
		    		$( data[0]["ingredientes"] ).each(function( index, info ) {


		    			
		    			$("#modal-body").append(
		    					  
		 				       	
		 				                
		 				         "<div class=\"row\"> "+
		 				         "  <div class=\"col-lg-12\">"+
		 				          "     <label for=\"input_name\"></label>"+
		 				           "    <div class=\"input-group\">"+
		 				             "      <span class=\"input-group-addon\">"+
		 				              "         <label>"+
		 				               "        <input type=\"checkbox\" checked=\"checked\" aria-label=\"Over here on the right\">"+
		 				              			info.ingrediente.nombre+
		 				                 "      </label>"+
		 				      "             </span>"+
		 				       "        </div>"+
		 				               <!-- /input-group -->
		 				      "     </div>"+
		 				         
		 				     "  </div>"
		    			);
		    			
		        	});
		    		}//fin if
		        	
		   		 },
					  error: function(data){
					  	alert("error");
					  }
			});
		 
		 $("#myModal").modal('show');
	 };
	
	
	
		$(function()
			{
			    $.ajax({
			    	url: "productos",
			    	dataType: "json",
			    	type: 'GET',
			    	success: function(result)
			    	{
			    		var data = $(result);
			    		$( data ).each(function( index, info ) {
			    			var green;
			    			var icon;
			    			if(info.preparacion==1){
			    			 green=	"<div class=\" panel panel-green\">";
			    			 icon="<i class=\" fa fa-beer fa-5x\">"+
			    			 "<input type=\"hidden\" name=\"idproducto\" value=\" " + info.id+ "\">"+
			    			 "</i>";
			    			}else{
			    			 green=	"<div class=\" panel panel-primary\">"	;
			    			 icon="<i class=\" fa fa-lemon-o fa-5x\">"+
			    			 "<input type=\"hidden\" name=\"idproducto\" value=\" " + info.id+ "\">"+
			    			 "</i>";

			    			}
			        		$("#listaproductos").append(
				       // 	"<div class=\" col-lg-3 col-md-6\" data-toggle=\"modal\" data-target=\"#myModal\"  >"+
				       	 	"<div value=\" " + info.id+ "\" class=\" col-lg-3 col-md-6\"   >"+

			                  green+
			                  "<div class=\" panel-heading\">"+
			                   "<div class=\" row\">"+
			                    "<div class=\" col-xs-3\">"+
			                    icon+
			                    "<input type=\"hidden\" name=\"idproducto\" value=\" " + info.id+ "\">"+
			                    "</div>"+
			                   "<div class=\" col-xs-9 text-right\">"+
			                    "<div class=\" huge\">"+info.existencias+
			                    "<input type=\"hidden\" name=\"idproducto\" value=\" " + info.id+ "\">"+
			                    "</div>"+
			                   "<input type=\"hidden\" name=\"idproducto\" value=\" " + info.id+ "\">"+
			                     "<div>"+info.nombre +
			                     "<input type=\"hidden\" name=\"idproducto\" value=\" " + info.id+ "\">"+
			                     "</div>"+
			                    "</div>"+
			                   "</div>"+
			                  "</div>"+
			                  "</div>"+
			                "</div>");
			        		
			        		
			        	});
			        	
			   		 },
				    error: function(xhr){
				        alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
				    }
			    });
			});
	
	</script>



	<script src="<c:url value="/resources/metisMenu.min.js" />"></script>
	<script src="<c:url value="/resources/raphael-min.js" />"></script>
	
	<script src="<c:url value="/resources/sb-admin-2.js" />"></script>
	<script src="<c:url value="/resources/bootstrap.min.js" />"></script>
</body>

</html>
