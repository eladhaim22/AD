<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<H2 ALIGN="CENTER">Ingrese Usuario y Password</H2>
		
		<FORM ACTION="/WebClient/Login" METHOD="post">
			Usuario : <INPUT TYPE="text" NAME="usuario"><BR>
			Password: <INPUT TYPE="password" NAME="passwd"><BR>
			<CENTER>
				<INPUT TYPE="submit" VALUE="Ingresar"></INPUT>
			</CENTER>
		</FORM>
		<% String m = (String)request.getAttribute("mensaje");%>
		<% if (m!=null) {%>
		<%=m %>
		<% } %>		
</body>
</html>