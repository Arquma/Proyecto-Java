<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="?language=en">Cambiar idioma a Inglés</a><br />
 <a href="?language=es">Cambiar idioma a Español</a>  
<h1>
	
</h1>
<!-- JSTL -->
<h1><fmt:message key="hello" /></h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
