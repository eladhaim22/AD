<%@page import="BusinessDelgate.BusinessDelegate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dto.PedidoDto" %>
<%@ page import="dto.ItemCartaDto" %>
<%@ page import="dto.ComandaDto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	var itemsCarta = new Array();
	var cantidades = new Array();

    function actualizarPrecio(value,id){

    }

	function agregarPlato()
	{
		 var tbl = document.getElementById('tblPlatos');
		 var myTbody = tbl.getElementsByTagName("tbody")[0];
		 var myRow = document.createElement("tr");
		 var myCellPlate = document.createElement("td");
		 var myCellCant = document.createElement("td");
		 var myCellPrice = document.createElement("td");


		 myTbody.appendChild(myRow);
		 myCellPrice.id = 'priceTd' + myTbody.rows.length;
		 var platos =document.getElementById("comboItemCarta");
		 var plato = platos.options[platos.options.selectedIndex];
		 myRow.appendChild(myCellPlate);
		 var textNode = document.createTextNode(plato.innerHTML);
		 var hidden = document.createElement('input');
		 hidden.type = 'hidden';
		 hidden.name = 'hddRow' + myTbody.rows.length;
		 hidden.id = 'hddRow' + myTbody.rows.length;
		 hidden.value = plato.value.split(";")[0];
		 hidden.className = 'submitable';
		 var hiddenPrice = document.createElement('input');
         hiddenPrice.type = 'hidden';
         hiddenPrice.name = 'priceRow' + myTbody.rows.length;
         hiddenPrice.id = 'priceRow' + myTbody.rows.length;
         hiddenPrice.value = plato.value.split(";")[1];
		 myCellPlate.appendChild(textNode);
		 myCellPlate.appendChild(hidden);
		 myCellPlate.appendChild(hiddenPrice);

		 myRow.appendChild(myCellCant);
		 myRow.appendChild	(myCellPrice);
		 var el = document.createElement('input');
		 el.type = 'text';
		 el.name = 'txtRow' + myTbody.rows.length;
		 el.id = 'txtRow' + myTbody.rows.length;
         el.className = 'submitable';
         el.onchange = function(){
             if(this.value && this.id) {
                 var index = this.id.replace("txtRow", "");
                 var precio = document.getElementById("priceRow" + index).value;
                 var tdPrecio = document.getElementById("priceTd" + index);
                 if(tdPrecio.childNodes.length > 0) {
                     tdPrecio.removeChild(tdPrecio.childNodes[0]);
                 }
				 var textNode = document.createTextNode(precio * this.value);
                 tdPrecio.appendChild(textNode);
             }
		 };
		 myCellCant.appendChild(el);
	}


	
	function obtenerValores()
	{
		var tbl = document.getElementById('tblPlatos');
		var inputs = tbl.getElementsByClassName('submitable');

		for(var i=0; i < inputs.length; i++)
		{
			
			if(i%2 == 0)
			{
				itemsCarta.push(inputs[i].value);
			}
			else
			{
				cantidades.push(inputs[i].value);
			}
		}
		document.getElementById('hddItemsIds').value = itemsCarta;
		document.getElementById('hddItemsCants').value = cantidades;
		
	}
	
</script>
</head>
<body>
	<form name="frmAgregarPlatos" id="formulario" method="POST" action="CargarPlatos">
		<% PedidoDto pedido = BusinessDelegate.getInstance().obtenerPedidoPorMesa(Integer.parseInt(request.getParameter("mesaId")));%>
		<table>
			<tr>
				<td>Pedido Nro: <%= pedido.getNumeroPedido().toString() %></td>
				<td colspan="1">&nbsp;</td>
				<td>Fecha Inicio: <%= pedido.getFechaApertura().toString() %></td>
				<td colspan="1">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td>Plato:</td>
				<td>
	               <select name="cbItemCarta" id="comboItemCarta">
	           		<% for (ItemCartaDto m : BusinessDelegate.getInstance().obtenerCartaPorId(Integer.parseInt(request.getParameter("cartaId"))).getItemCartaDtos()) { %>
			            <option value="<%=m.getItemCartaId().toString() + ";" + m.getPrecio() %>">
			            	<%=m.getPlatoAsociado().getNombre() %>
			            </option>
					<% } %>
	           		</select>
				</td>
				<td colspan="2" align="center"><input name="btnAgregar" type="button" value="Agregar" onclick="agregarPlato()"></td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4">
					<table id="tblPlatos" align="center" border="1" width="400px">
						<tr align="center">
							<td width="33%%">Plato</td>
							<td width="33%">Cantidad</td>
							<td>Precio</td>
						</tr>
						<% int count =1;
							for (ComandaDto c :pedido.getComandas()){ %>
						    <tr>
								<td>
									<%= c.getItem().getPlatoAsociado().getNombre().toString() %>
								</td>
								<td>
									<%= c.getCantidad().toString() %>
								</td>
								<td>
									<%= c.getCantidad() * c.getItem().getPrecio() %>
								</td>
							</tr>
						<% }%>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input name="btnAceptar" type="submit" value="Aceptar" onclick="obtenerValores()">
					<input name="hddItemsIds" id="hddItemsIds" type="hidden">
					<input name="hddItemsCants" id="hddItemsCants" type="hidden">
					<input name="hddPedidoId" id="hddPedidoId" type="hidden" value=<%=pedido.getNumeroPedido() %>>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>