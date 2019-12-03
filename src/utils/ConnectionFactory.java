package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conexao;
	
	public static Connection openConnection() {
		try {
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost/sgp", "postgres", "muce41");
			return conexao;
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
}
