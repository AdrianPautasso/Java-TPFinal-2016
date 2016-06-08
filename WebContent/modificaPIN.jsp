<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Clases.Cliente" %>
<%
	Cliente usuario = (Cliente)session.getAttribute("usuario"); 
	int id = usuario.getId();
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar PIN</title>
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">

// 	$(document).ready(function() {
// 		$("#btnModificar").click(function(event){
// 			var idUsuario = $('#idUsuario').val();
// 			var pinActual = $('#txtPINActual').val();
// 			var pinNuevo = $('#txtNuevoPIN').val();
// 			$.post('ModificarPIN', {
// 				id: idUsuario,
// 				pinActual: pinActual,
// 				pinNuevo: pinNuevo,
// 			}, function(respuesta) {
// 				$('#respuesta').html(respuesta);
// 			});
// 		});
// 	});
</script>
</head>
<body>
	
	<form id="formModificaPIN" method="post" action="ModificarPIN">
		<input type="hidden" name="idUsuario" value="<%=id%>">
		Ingrese el pin actual: <input type="text" name="txtPINActual">
		<br>
		Ingrese el nuevo PIN: <input type="text" name="txtNuevoPIN">
		<br>
		<input type="submit" value="Modificar">
		<br>
	</form>
	<div id="respuesta"></div>
	<br>
	<a href="gestionUsuario.jsp">Volver a la gestión de usuario</a>
</body>
</html>