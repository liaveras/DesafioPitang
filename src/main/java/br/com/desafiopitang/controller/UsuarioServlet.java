package br.com.desafiopitang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desafiopitang.dao.UsuarioDAO;
import br.com.desafiopitang.model.Usuario;

//http://localhost:8080/desafiopitang/usuarioservlet.do
@WebServlet("/usuarioservlet.do")
public class UsuarioServlet extends HttpServlet {

	public UsuarioServlet() {

	}

	@Override
	public void init() throws ServletException {

		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
		
		if (acao.equals("excl")) {
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			if (id != null) {
				usu.setId(Integer.parseInt(id));
			}
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.excluir(usu);
			resp.sendRedirect("usuarioservlet.do?acao=list");
			
		} else if (acao.equals("list")) {
			UsuarioDAO usuDAO = new UsuarioDAO();
			List<Usuario> lista = usuDAO.buscarTodos();
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("listausu.jsp");
			dispatcher.forward(req, resp);

		} else if (acao.equals("alte")) {
			String id = req.getParameter("id");
			UsuarioDAO usuDAO = new UsuarioDAO();
			Usuario usu = usuDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("usuario", usu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("formusuario.jsp");
			dispatcher.forward(req, resp);
		}else if(acao.equals("cad")) {
			Usuario usu = new Usuario();
//			usu.setId(0);
//			usu.setNome("");
//			usu.setEmail("");
//			usu.setSenha("");
			req.setAttribute("usuario", usu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("formusuario.jsp");
			dispatcher.forward(req, resp);
			
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		long ddd = Integer.parseInt(req.getParameter("ddd"));
		String numero = req.getParameter("numero");
		String tipo = req.getParameter("tipo");

		Usuario usu = new Usuario();
//		if (id != null) {
//			usu.setId(Integer.parseInt(id));
//		}
		usu.setId(id);
		usu.setNome(nome);
		usu.setEmail(email);
		usu.setSenha(senha);
		usu.setDdd(ddd);
		usu.setNumero(numero);
		usu.setTipo(tipo);

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		List<Usuario> lista = usuDAO.buscarTodos();
		req.setAttribute("lista", lista);
		RequestDispatcher dispatcher = req.getRequestDispatcher("listausu.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}

	@Override
	public void destroy() {

		super.destroy();
	}

}
