<%@page import="br.com.desafiopitang.model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Usuários</title>
<script type="text/javascript">
function confirmaExclusao (id){
	if(window.confirm('Tem certeza que deseja excluir?')){
		location.href="usuarioservlet.do?acao=excl&id="+id;
	}
}

</script>
</head>
<body>
<%
	List<Usuario> lista = (List<Usuario>)request.getAttribute("lista");
%>
	<a href="usuarioservlet.do?acao=cad"> Novo Usuário</a>
	<table border=1>
	<tr><th>ID</th> <th>Nome</th> <th>E-mail</th> <th>Ação</th> <th>DDD</th> <th>Número</th> <th>Tipo</th> </tr>
	
	<% for (Usuario usu:lista){ %>
		<tr>
			<td><%out.print(usu.getId());%></td>
			<td><%=usu.getNome()%></td>
			<td><%=usu.getEmail() %></td>
			<td><%=usu.getDdd() %></td>
			<td><%=usu.getNumero() %></td>
			<td><%=usu.getTipo() %></td>
			
			<td><a href="javascript:confirmaExclusao(<%=usu.getId()%>)"> excluir </a> | <a href="usuarioservlet.do?acao=alte&id=<%=usu.getId()%>">alterar</a></td>
		</tr>
	<% } %>

	</table>
</body>
</html>