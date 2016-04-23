<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Clases.Usuario" %>
<%
	Usuario usuario = (Usuario)session.getAttribute("usuario"); 
	int id = usuario.getId();
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco UTN</title>
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
	if(history.forward(1))
		location.replace(history.forward(1))
	$(document).ready(function() {
		
		$(".CtaCte").hide();
		$(".CajaAhorro").hide();
		$("#btnCtaCte").click(function(event){
			$(".CtaCte").show();
			$(".CajaAhorro").hide();
			$("#mensajeCC").hide();
			$("#formExtraccionCC").hide();
			$("#formDepositoCC").hide();
		});
		
		$("#btnConsultaSaldoCC").click(function(event){
			$("#mensajeCC").show();
			$("#formExtraccionCC").hide();
			$("#formDepositoCC").hide();
		});
		
		$("#btnExtraccionCC").click(function(event){
			$("#formExtraccionCC").show();
			$("#formDepositoCC").hide();
			$("#mensajeCC").hide();
		});
		
		$("#btnDepositoCC").click(function(event){
			$("#formDepositoCC").show();
			$("#formExtraccionCC").hide();
			$("#mensajeCC").hide();
		});
		
		$("#btnCajaAhorro").click(function(event){
			$(".CtaCte").hide();
			$(".CajaAhorro").show();
			$("#mensajeCA").hide();
			$("#formExtraccionCA").hide();
			$("#formDepositoCA").hide();
		});
		
		$("#btnExtraccionCA").click(function(event){
			$("#formExtraccionCA").show();
			$("#formDepositoCA").hide();
			$("#mensajeCA").hide();
		});
		
		$("#btnDepositoCA").click(function(event){
			$("#formDepositoCA").show();
			$("#formExtraccionCA").hide();
			$("#mensajeCA").hide();
		});
		
		$('#btnDepositarCA').click(function(event){
			var idUsuario = $('#idUsuario').val();
			var valor = $('#txtSaldoDepositoCA').val();
			$.post('DepositoCA', {
				id: idUsuario,
				valor: valor,
			}, function(respuesta) {
				$('#mensajeCA').html(respuesta);
				$('#mensajeCA').show();
			});
		});
	});
</script>
</head>
<body>

	<h1>
		<span>Bienvenido <%=usuario.getNombre_usuario()%></span>
	</h1>
		<h2>Elija opción: </h2>
		
		<br>
		<button id="btnCtaCte">Cuenta Corriente</button>
		<br>
		
	 	<button id="btnExtraccionCC" class="CtaCte">Extracción</button> 
	 	<form class="CtaCte" id="formExtraccionCC" method="post" action="ExtraccionCC">
	 		<input type="text" name="txtSaldoExtraccionCC">
	 		<input type="hidden" name="idUsuario" value="<%=id%>">
	 		<input type="submit" id="btnExtraerCC" value="Extraer">
	 	</form>
	 	
	 	<button id="btnDepositoCC" class="CtaCte">Depósito</button>
	 	<form class="CtaCte" id="formDepositoCC" method="post" action="DepositoCC">
	 		<input type="text" name="txtSaldoDepositoCC">
	 		<input type="hidden" name="idUsuario" value="<%=id%>">
	 		<input type="submit" id="btnDepositarCC" value="Depositar">
	 	</form>
	 	
	 	<form class="CtaCte" id="formConsultaCC" method="post" action="ConsultaCC">
	 		<input type="hidden" name="idUsuario" value="<%=id%>">
			<input type="submit" id="btnConsultaSaldoCC" value="Consulta" class="CtaCte"/>  
	 	</form>
	 	
		
		<br>
		<br>
		
		
		<button id="btnCajaAhorro">Caja de ahorro</button>
		<br>
		
	 	<button id="btnExtraccionCA" class="CajaAhorro">Extracción</button> 
	 	<form class="CajaAhorro" id="formExtraccionCA"  method="post" action="ExtraccionCA">
	 		<input type="text" name="txtSaldoExtraccionCA">
	 		<input type="hidden" name="idUsuario" value="<%=id%>">
	 		<input type="submit" id="btnExtraerCA" value="Extraer">
	 	</form>
	 	
	 	<button id="btnDepositoCA" class="CajaAhorro">Depósito</button>
	 	<form class="CajaAhorro" id="formDepositoCA" method="post" action="DepositoCA">
	 		<input type="text" name="txtSaldoDepositoCA">
	 		<input type="hidden" name="idUsuario" value="<%=id%>">
	 		<input type="submit" id="btnDepositarCA" value="Depositar">
	 	</form>
	 	
	 	<form class="CajaAhorro" id="formConsultaCA" method="post" action="ConsultaCA">
	 		<input type="hidden" name="idUsuario" value="<%=id%>">
			<input type="submit" id="btnConsultaSaldoCA" value="Consulta" class="CajaAhorro"/>  
	 	</form>
		
		<br>
		
	
	<h3>
		<a href="modificaPIN.jsp">Modificar PIN</a>
		<br>
		<a href="cerrarSesion.jsp">Cerrar Sesión</a>
	</h3>
</body>
</html>