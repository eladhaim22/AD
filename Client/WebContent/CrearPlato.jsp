<%@ page import="java.util.ArrayList"%>
<%@ page import="BusinessDelgate.BusinessDelegate"%>
<%@ page import="dto.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1" lang="es">
	<title>Crear Plato</title>
	<script type="text/javascript">
		var ingredientes = 0;
        function GetXmlHttpObject()
        {
            if (window.XMLHttpRequest)
            {
                return new XMLHttpRequest();
            }
            if (window.ActiveXObject)
            {
                return new ActiveXObject("Microsoft.XMLHTTP");
            }
            return null;
        }


        function cargarCartaPorSucursal(){
            req =GetXmlHttpObject();
            if (req==null)
            {
                alert ("Your browser does not support Ajax HTTP");
                return;
            }
            var sucursal =document.getElementById("comboSucursales");
            if(sucursal.value != "")
            {
                //esta será nuestra petición
                var url='<%=request.getContextPath()%>/CartasPorSucursal?sucursalId='+sucursal.value;
                //obtenemos el objeto para manejar peticiones en XML...

                //asociamos un metodo alevento que se ejecuta a medida que vaya leyendo el XML
                req.onreadystatechange = processRequestCarta;
                //pedimos el xml
                req.open("GET", url, true);
                //no enviamos nada y termina
                req.send(null);
            }
        }

        function processRequestCarta(){
            /** los estados pueden ser
             0: no se ha iniciado
             1: esta cargando
             2: ya ha cargado
             3: esta intercambiando con el cliente
             4: ha terminado
             */
            if (req.readyState==4){
                /*y cuando haya terminado procesa el mensaje
                 (200: el requerimiento ha sido satisfactorio)*/
                if (req.status==200) parseMessagesCartas();
                //sino, hubo un problema al obtener el XML
                else alert("no se pudo obtener los datos de las mesas");
            }

        }

        function parseMessagesCartas(){
            //obtenemos el XML
            var response=req.responseXML.documentElement;
            //obtenemos de nuestro HTML la zona donde escribiremos el resultado
            var cboCartas =document.getElementById("comboCarta");
            cboCartas.disabled=false;
            var cartas =response.getElementsByTagName("carta");
            cboCartas.options.length= cartas.length;
            if(cartas.length > 0){
                for(i=0;i<cartas.length;i++){
                    var m=cartas[i];
                    cboCartas.options[i].value= m.getAttribute("id");
                    cboCartas.options[i].innerHTML= m.firstChild.data;
                }
            }
            else{
                alert('No existen mesas abiertas para la sucursal seleccionada');
            }
        }

        function agregarItemIngrediente()
        {
            var tbl = document.getElementById('tablePlato');
            var myRow = document.createElement("tr");
            var myCellPlate = document.createElement("td");
            var myCellCant = document.createElement("td");
			var myCellUnidad = document.createElement("td");
            tbl.appendChild(myRow);

            var platos =document.getElementById("comboIngrediente");
            var plato = platos.options[platos.options.selectedIndex];
            myRow.appendChild(myCellPlate);
            var textNode = document.createTextNode(plato.innerHTML);
            var hidden = document.createElement('input');
            hidden.type = 'hidden';
            hidden.name = 'hddRow' + ingredientes;
            hidden.id = 'hddRow' + ingredientes;
            hidden.value = plato.value.split(";")[0];
            myCellPlate.appendChild(textNode);
            myCellPlate.appendChild(hidden);

            myRow.appendChild(myCellCant);
            var el = document.createElement('input');
            el.type = 'number';
            el.name = 'txtRow' + ingredientes;
            el.id = 'txtRow' + ingredientes;
            myCellCant.appendChild(el);
            txtElement = document.createTextNode(plato.value.split(";")[1]);
            myCellUnidad.appendChild(txtElement);
            myRow.appendChild(myCellUnidad);
            ingredientes++;
        }


	</script>
</head>
<body>
<div>
	<h2>Crear Plato </h2>
</div>
<form name="frmCargarPedido" id="formulario" method="POST" action="CrearPlato" >
		<table id="tablePlato">
			<!--tr>
				<td>Sucursal:</td>
				<td>
					<select name="cbSucursal" id="comboSucursales" onchange="cargarCartaPorSucursal()">
						<option value="">Elija una sucursal</option>
						 <%-- for (SucursalDto m : BusinessDelegate.getInstance().obtenerSucursales()) { %>
						<option value="<%= m.getSucursalId() %>">
							<%=//m.getNombre() %>
						</option>
						<% } --%>
					</select>
				</td>
				<td>&nbsp;</td>
				<td>Carta:</td>
				<td>
					<select name="cartaId" id="comboCarta" disabled="disabled">
						<option value=" ">Elija una carta</option>
					</select>
				</td>
			</tr-->
			<tr>
				<td>Nombre:</td>
				<td><input name="nombre" type="text" id="txtnombre"/></td>
			</tr>
			<tr>
				<td>Rubro:</td>
				<td><input name="rubro" type="text" id="txtrubro"/></td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>Unidad de medida:</td>
				<td><input name="unidadMedida" type="text" id="txtunidadMedida"/></td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>Porciones x unidad:</td>
				<td><input name="porcionesXUnidad" type="number" id="txtporcionesXUnidad"/></td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>Receta:</td>
				<td><textarea name="receta" cols="30" rows="7"></textarea></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr>
				<td>Comentarios:</td>
				<td><textarea name="comentarios" cols="30" rows="7"></textarea></td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>Area:</td>
				<td>
					<select name="areaId" id="comboArea">
						<option value=" ">Elija una area:</option>
						<% for (AreaDto areaDto : BusinessDelegate.getInstance().obtenerAreas()) { %>
						<option value="<%= areaDto.getAreaId() %>">
							<%=areaDto.getNombre() %>
						</option>
						<% } %>
					</select>
				</td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>Carta:</td>
				<td>
					<select name="areaId" id="comboIngrediente">
						<option value=" ">Elija un ingrediente:</option>
						<% for (IngredienteDto ingredienteDto : BusinessDelegate.getInstance().obtenerIngredientes()) { %>
						<option value="<%= ingredienteDto.getIngredienteId() + ";" + ingredienteDto.getUnidadDeMedida() %>">
							<%=ingredienteDto.getNombre() %>
						</option>
						<% } %>
					</select>
				</td>
				<td colspan="2" align="center"><input name="btnAgregar" type="button" value="Agregar Ingrediente" onclick="agregarItemIngrediente()"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td>Ingrediente</td>
				<td>Cantidad</td>
				<td colspan="2">Unidad de medida</td>
			</tr>
		</table>
		<br>
		<br>

	<input name="btnAceptar" type="submit" value="Aceptar">

</form>
</br>
<a href='MenuMozo.jsp'>volver al menu</a>
</body>
</html>