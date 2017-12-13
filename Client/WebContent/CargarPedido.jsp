<%@ page import="java.util.ArrayList"%>
<%@ page import="BusinessDelgate.BusinessDelegate"%>
<%@ page import="dto.SucursalDto"%>
<%@ page import="dto.MesaDto"%>
<%@ page import="dto.CartaDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1" lang="es">
    <title>Cargar Pedido</title>
    <script type="text/javascript">
		
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
    
           function cargarMesasAbiertas(){
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
	               var url='<%=request.getContextPath()%>/MesasAbiertaPorSucursal?sucursalId='+sucursal.value;
	               //obtenemos el objeto para manejar peticiones en XML...
	
	               //asociamos un metodo alevento que se ejecuta a medida que vaya leyendo el XML
	               req.onreadystatechange = processRequest;
	               //pedimos el xml
	               req.open("GET", url, true);
	               //no enviamos nada y termina
	               req.send(null);
               }
           }    

           function processRequest(){
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
                   if (req.status==200) parseMessages();
                   //sino, hubo un problema al obtener el XML
                   else alert("no se pudo obtener los datos de las mesas");
               }
               
           }
           function parseMessages(){
               //obtenemos el XML
               var response=req.responseXML.documentElement;
               //obtenemos de nuestro HTML la zona donde escribiremos el resultado
               var cboMesas =document.getElementById("comboMesas");
               cboMesas.disabled=false;
               var mesas =response.getElementsByTagName("mesa");
               cboMesas.options.length= mesas.length;
               if(mesas.length > 0){
	               for(i=0;i<mesas.length;i++){
	                 var m=mesas[i];
	                 cboMesas.options[i].value= m.getAttribute("id");
	                 cboMesas.options[i].innerHTML= m.firstChild.data;
	               }
               }
               else{ 
               	alert('No existen mesas abiertas para la sucursal seleccionada');
	               cboMesas.options[0].value= "";
	               cboMesas.options[0].innerHTML= "Elija una mesa";               	
               	}
               
               cargarCartaPorSucursal();
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
    </script>      
</head>
<body>
    <div>
		<h2>Cargar Pedido</h2>
    </div>
    <form name="frmCargarPedido" id="formulario" method="GET" action="CargarPedido">
        <blockquote>
        	<table>
        		<tr>
        			<td>Sucursal:</td>
        			<td>
		               <select name="cbSucursal" id="comboSucursales" onchange="cargarMesasAbiertas()">
		               	<option value="">Elija una sucursal</option>
		           		<% for (SucursalDto m : BusinessDelegate.getInstance().obtenerSucursales()) { %>
				            <option value="<%=m.getSucursalId() %>">
				            	<%=m.getNombre() %>			            
				            </option>
						<% } %>
		           		</select>
        			</td>
        			<td>&nbsp;</td>
        			<td>Mesa:</td>
        			<td>
		               <select name="cbMesas" id="comboMesas" size="1" disabled="disabled">
							<option value=" ">Elija una mesa</option>
		           		</select>
        			</td>     
        			<td>&nbsp;</td>   		
        			<td>Carta:</td>
        			<td>
		               <select name="cbCarta" id="comboCarta" disabled="disabled">
		               		<option value=" ">Elija una carta</option>
		           		</select>
        			</td>        				
        		</tr>
        		<tr>
        			<td colspan="5">&nbsp;</td>
        		</tr>
        		<tr>
        			<td colspan="4">&nbsp;</td>
        			<td><input name="btnAceptar" type="submit" value="Aceptar"></td>
        		</tr>
        	</table>
      	</blockquote>      	
	</form>    
	</br>
<a href='MenuMozo.jsp'>volver al menu</a>
</body>
</html>