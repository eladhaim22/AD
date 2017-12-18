<%@ page import="java.util.ArrayList"%>
<%@ page import="BusinessDelgate.BusinessDelegate"%>
<%@ page import="dto.SucursalDto"%>
<%@ page import="dto.PedidoDto" %>
<%@ page import="dto.ComandaDto" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.Collections" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Comandas</title>
</head>
<body>
<div>
    <h2>Listar Comandas</h2>
</div>
    <form name="frmComandas" id="formulario" method="POST" action="MarcarComandasListas">

        <%int count = 0; for (PedidoDto p : BusinessDelegate.getInstance().obtenerPedidosConComandasIniciadas()){
            boolean showPedido = false;
            for (ComandaDto c : p.getComandas()) {
                if (c.getEstado().compareTo("Iniciado") == 0) {
                    showPedido = true;
                }
            }
            if(showPedido){%>
            <h3>Pedido nro:<%= p.getNumeroPedido()%></h3>
            <h3>Pedido nro:<%= p.getFechaApertura()%></h3>
            <table width="50%">
                <tr>
                    <td>Plato</td>
                    <td>Cantidad</td>
                    <td>Estado</td>
                </tr>
                <% for (ComandaDto c : p.getComandas()){
                    if(c.getEstado().compareTo("Iniciado") == 0 && c.getItem().getPlatoAsociado().getAreaId() == Integer.parseInt(request.getParameter("areaId"))){
                %>
                <tr>
                    <td width="33%"><%= c.getItem().getPlatoAsociado().getNombre()%></td>
                    <td width="33%"><%= c.getCantidad()%></td>
                    <td> <input type="hidden" name="<%= "comanda" + count%>"
                        value="<%= c.getItemPedidoId()%>" id="<%= "comanda" + count%>"/></td>
                    <td width="33%"><select name="<%= "cbEstado" + count%>" id="<%= "cbEstado" + count%>" size="1">
                        <option value="Iniciado">Iniciado</option>
                        <option value="Finalizado">Finalizado</option>
                    </select>
                    </td>
                </tr>
                <%count++;}}}%>
            </table>
        <%}%>
        <button type="submit">Submit</button>
    </form>
</br>
</body>
</html>