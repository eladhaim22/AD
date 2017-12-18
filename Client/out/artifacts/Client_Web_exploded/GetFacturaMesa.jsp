<%@page import="BusinessDelgate.BusinessDelegate"%>
<%@ page import="dto.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
		<title></title>
	</head>

	<body>
	<% FacturaDto factura = BusinessDelegate.getInstance().getDatosFactura(Integer.parseInt(request.getParameter("mesaId")));%>
		<div>
		<form name="frmMozos" id="formularioMozos" method="GET" action="ConfirmarPago" >
			<h1> Datos de la factura</h1>\
			<h3> Numero factura: <%= String.valueOf(factura.getNumeroFactura().intValue()) %></h3>
			<h3> Fecha: <%= String.valueOf(factura.getFecha())%>  </h3>
			<table width="40%">
				<tr>
					<td width="25%">Plato</td>
					<td width="25%">Cantidad</td>
					<td width="25%">Precio</td>
					<td width="25%">Total</td>
				</tr>
				<% for(ItemFacturaDto item : factura.getItemsFacutra()) { %>
					<tr>
						<td><%= item.getNombrePlato().toString() %></td>
						<td><%= String.valueOf(item.getCantidad()) %></td>
						<td><%= String.valueOf(item.getPrecio()) %></td>
						<td><%= String.valueOf(item.getPrecio() * item.getCantidad()) %></td>
					</tr>
				<%}%>
			</table>
			<h3> Monto a pagar:  <%=String.valueOf(factura.getMonto())%></h3>
			<h3> Medio de Pago: </h3>
			<div>
				<select name="cbMedioPago" id="comboMediosPago" size="1" >
					<option value="Efectivo">Efectivo</option>
					<option value="Debito">Debito</option>
					<option value="Tarjeta">Tarjeta</option>
				</select>
			</div>
		<input type="hidden" name="cbMesaId" id="cbMesa" value="<%=request.getParameter("cbMesa")%>"/>
		<input type="hidden" name="cbFacturaId" id="cbFac" value="<%=factura.getNumeroFactura()%>"/>
		<input name="btnGetMesas" type="submit" value="Pagar Factura">
	</form>
	<a href='MenuMozo.jsp'>Menu Principal</a>
</body>
</html>

</body>
</html>