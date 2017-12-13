<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Mozo</title>
</head>
<body>
<h1> Menu Mozo </h1>
<form>
<input type="button" value="Abrir Mesa" onClick="parent.location='AbrirMesa.jsp'"/><br><br>
<input type="button" value="Cargar Pedido" onClick="parent.location='CargarPedido.jsp'"/><br><br>
<input type="button" value="Cerrar Mesa" onClick="parent.location='CerrarMesa.jsp'"/><br><br>
<input type="button" value="Pagar Factura" onClick="parent.location='RegistrarPagoFactura.jsp'"/><br><br>
</form>
</body>
</html>