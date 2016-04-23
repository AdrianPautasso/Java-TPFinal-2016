<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar usuario</title>
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
// 	$(document).ready(function() {
// 		$('#submit').click(function(event) {
// 			var txtNombreUsuario = $('#txtNombreUsuario').val();
// 			var txtPIN = $('#txtPIN').val();
// 			var txtSaldoCA = $("#txtSaldoCA").val();
// 			var txtSaldoCC = $("#txtSaldoCC").val();
// 			$.post('RegistrarUsuario', {
// 				usuario : txtNombreUsuario,
// 				PIN: txtPIN,
// 				saldoCA: txtSaldoCA,
// 				saldoCC: txtSaldoCC,
// 			}, function(respuesta) {
// 				$('#respuesta').html(respuesta);
// 			});
// 		});
// 	});
</script>
</head>
<body>
	<form id="registro" method="post" action="RegistrarUsuario">
		Usuario: <input type="text" name="txtNombreUsuario"> <br>
		PIN: <input type="text" name="txtPIN"> <br>
		Saldo Caja Ahorro: <input type="text" name="txtSaldoCA"> <br>
		Saldo Cuenta Corriente: <input type="text" name="txtSaldoCC"> <br>
		<input type="submit" value="Registrar nuevo usuario" />
		<br>
	</form>
	<div id="respuesta"></div>
	<br>
	<a href="login.jsp">Volver al inicio</a>
</body>

</html>