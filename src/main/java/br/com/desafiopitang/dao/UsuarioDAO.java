package br.com.desafiopitang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.desafiopitang.model.Usuario;

public class UsuarioDAO {
	
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome, email, senha, ddd, numero, tipo) values (?,?,?,?,?,?)";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getEmail());
			preparador.setString(3, usu.getSenha());
			preparador.setLong(4, usu.getDdd());
			preparador.setString(5, usu.getNumero());
			preparador.setString(6, usu.getTipo());

			
			preparador.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void alterar(Usuario usu) {

		String sql = "update usuario set nome=?, email=?, senha=?, ddd=?, numero=?, tipo=? where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getEmail());
			preparador.setString(3, usu.getSenha());
			preparador.setLong(4, usu.getDdd());
			preparador.setString(5, usu.getNumero());
			preparador.setString(6, usu.getTipo());
			preparador.setInt(7, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario usu) {
		
		String sql = "delete from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void salvar(Usuario usu) {
		if(usu!=null && usu.getId()!=0) {
			alterar(usu);
		}else {
			cadastrar(usu);
		}
	}
	
	/**
	 * Busca de um registro no banco de dados pelo número do id do usuario
	 * @param id É um inteiro que representa o número do id do usuário a ser buscado
	 * @return Um objeto usuário quando encontra ou null quando não encontra
	 */
	public Usuario buscarPorId(int id) {
		
		String sql = "Select * from usuario where id =?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			//Posicionando o cursor no primeiro registro
			if(resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setEmail(resultado.getString("email"));
				usu.setSenha(resultado.getString("senha"));
				usu.setDdd(resultado.getLong("ddd"));
				usu.setNumero(resultado.getString("numero"));
				usu.setTipo(resultado.getString("tipo"));
				
				return usu;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Realiza a busca de todos registros da tabela de usuario
	 * @return Uma lista de objetos Usuario contendo zero elementos quando não tiver registro 
	 * ou n elementos quando tiver resultado
	 */
	public List<Usuario> buscarTodos() {
		
		String sql = "Select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
			ResultSet resultado = preparador.executeQuery();
			//Posicionando o cursor no primeiro registro
			while(resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setEmail(resultado.getString("email"));
				usu.setSenha(resultado.getString("senha"));
				usu.setDdd(resultado.getLong("ddd"));
				usu.setNumero(resultado.getString("numero"));
				usu.setTipo(resultado.getString("tipo"));

				//Adicionando usuario na lista
				lista.add(usu);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Usuario autenticar(Usuario usuConsulta) {
		
		String sql = "Select * from usuario where email=? and senha=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usuConsulta.getEmail());
			preparador.setString(2, usuConsulta.getSenha());
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
			Usuario usu = new Usuario();
			usu.setId(resultado.getInt("id"));
			usu.setNome(resultado.getString("nome"));
			usu.setEmail(resultado.getString("email"));
			usu.setSenha(resultado.getString("senha"));
			
			return usu;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

}
