package br.com.desafiopitang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_desafio_pitang?useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "Rodrigo@2502");
		} catch (SQLException e) {
			//Relançando a exception
			throw new RuntimeException(e);
		}
	}

}
