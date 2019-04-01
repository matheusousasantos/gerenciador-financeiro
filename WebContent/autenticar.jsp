<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Autenticar Usuário</h1>
	
	<!-- 13° Vamos criar um formulário de autenticação do usuário -->
	
	<form action="servletAutenticacao" method="POST">
		
		<input id="url" name="url" value="<%= request.getParameter("url") %>"/>
	
		<table>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="login" id="login"/></td>
			</tr>
			
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha" id="senha"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Logar"/></td>
			</tr>
			
		</table>
	</form>
	
	
	<!-- 14° Agora vamos enviar pro Servlet -->
	
</body>

</html>