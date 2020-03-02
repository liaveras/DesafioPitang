package br.com.desafiopitang;

import br.com.desafiopitang.dao.UsuarioDAO;
import br.com.desafiopitang.model.Usuario;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		testExcluir();
		
	}
	
	public static void testCadastrar() {
		//Criando usuario
				Usuario usu = new Usuario();
				usu.setNome("Rita Veras");
				usu.setEmail("ritaveras@gmail.com");
				usu.setSenha("87654321");
				
				//Cadastrando usuário no banco de dados
				UsuarioDAO usuDAO = new UsuarioDAO();
				usuDAO.cadastrar(usu);
				
				System.out.println("Cadastrado com sucesso!");

	}
	
	public static void testAlterar() {
		//Criando usuario
				Usuario usu = new Usuario();
				usu.setId(3);
				usu.setNome("Rita Veras da Silva");
				usu.setEmail("ritaverasdasilva@gmail.com");
				usu.setSenha("22222222");
				
				//Alterando usuário no banco de dados
				UsuarioDAO usuDAO = new UsuarioDAO();
				usuDAO.alterar(usu);
				
				System.out.println("Alterado com sucesso!");

	}
	
	public static void testExcluir() {
		//Criando usuario
				Usuario usu = new Usuario();
				usu.setId(3);
				
				//Excluindo usuário no banco de dados
				UsuarioDAO usuDAO = new UsuarioDAO();
				usuDAO.excluir(usu);
				
				System.out.println("Excluido com sucesso!");

	}
	
}
