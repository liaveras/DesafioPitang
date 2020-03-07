package br.com.desafiopitang;

import java.util.List;

import br.com.desafiopitang.dao.UsuarioDAO;
import br.com.desafiopitang.model.Usuario;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		testSalvar();

	}

	private static void testAutenticar() {
		UsuarioDAO usuDAO = new UsuarioDAO();

		Usuario usu = new Usuario();
		usu.setEmail("liaveras@gmail.com");
		usu.setSenha("12345678");

		Usuario usuRetorno = usuDAO.autenticar(usu);
		System.out.println(usuRetorno);
	}

	private static void testBuscarTodos() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> lista = usuDAO.buscarTodos();
		for (Usuario usu : lista) {
			System.out.println(usu);
		}
	}

	private static void testBuscarPorId() {

		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usu = usuDAO.buscarPorId(1);
		System.out.println(usu);

	}

	public static void testCadastrar() {
		// Criando usuario
		Usuario usu = new Usuario();
		usu.setNome("Lilico da Silva");
		usu.setEmail("lilico@gmail.com");
		usu.setSenha("11111111");

		// Cadastrando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("Cadastrado com sucesso!");

	}

	public static void testAlterar() {
		// Criando usuario
		Usuario usu = new Usuario();
		usu.setId(7);
		usu.setNome("Rodrigo Jose Albuquerque Grimaldi");
		usu.setEmail("rodrigogrimaldi@gmail.com");
		usu.setSenha("22222222");

		// Alterando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Alterado com sucesso!");

	}

	public static void testExcluir() {
		// Criando usuario
		Usuario usu = new Usuario();
		usu.setId(3);
		// Excluindo usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Excluido com sucesso!");

	}

	public static void testSalvar() {

		Usuario usu = new Usuario();
		//usu.setId(4);
		usu.setNome("Marcos Cirano Veras");
		usu.setEmail("ciranoveras@gmail.com");
		usu.setSenha("99999999");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);

		System.out.println("Salvo com sucesso!");

	}

}
