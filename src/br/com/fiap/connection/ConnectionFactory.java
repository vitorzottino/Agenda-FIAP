package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection conectar() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm93360", "100903");
		} catch (SQLException e) {
			System.out.print("Erro ao conectar com o db: ");
			throw new RuntimeException(e);
			
		}
		
	}

}

