<%@ page import="java.util.ArrayList"%>
<%@ page import="BusinessDelgate.BusinessDelegate"%>
<%@ page import="dto.SucursalDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Comisiones</title>      
</head>
<body>
    <div>
		<h2>Listar Comisiones</h2>
    </div>
    <form name="frmAperturaMesa" id="formulario" method="GET" action="CalcularComisiones">
        <blockquote>
          	<p>
            	Seleccionar sucursal: 
                <select name="cbSucursal" id="comboSucursales" size="1" >
            		<% for (SucursalDto m : BusinessDelegate.getInstance().obtenerSucursales()) { %>
			            <option value="<%=m.getSucursalId() %>">
			            	<%=m.getNombre() %>			            
			            </option>
					<% } %>
            	</select>
       	        <input name="btnAceptar" type="submit" value="Aceptar">
       	  	</p>
      	</blockquote>      	
	</form>    
	</br>
</body>
</html>