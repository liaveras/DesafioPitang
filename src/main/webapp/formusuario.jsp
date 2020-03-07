<%@page import="br.com.desafiopitang.model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuários</title>
</head>
<body>
	<%
	
	Usuario usu = new Usuario(); 
	usu = (Usuario)request.getAttribute("usuario");
	
	%>
	<form action="usuarioservlet.do" method="post">
		<p>Id:<input type="text" name="id" value="<%if(usu!=null){usu.getId();} %>"/>	</p>
		<p>Nome: <input type="text" name="nome" value="<%if(usu!=null){usu.getNome();}%>"/></p>
		<p>E-mail: <input type="text" name="email" value="<%if(usu!=null){usu.getEmail();}%>"/></p>
		<p>Senha: <input type="text" name="senha" value="<%if(usu!=null){usu.getSenha();}%>"/></p>
		<p>DDD: <input type="number" name="ddd" value="<%if(usu!=null){usu.getDdd();}%>"/></p>
		<p>Numero: <input type="text" name="numero" value="<%if(usu!=null){usu.getNumero();}%>"/></p>
		<p>Tipo: <input type="text" name="tipo" value="<%if(usu!=null){usu.getTipo();}%>"/></p>
		
		<input type="submit" value="Salvar">
	
	
	</form>
</body>
</html>