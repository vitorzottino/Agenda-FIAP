package Teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.connection.ConnectionPool;

public class TestePoolConexoes {

	public static void main(String[] args) throws SQLException{
		for (int i = 0; i < 50; i++) {
			Connection conexao = ConnectionPool.conectar();
			System.out.println("Conexao: " + i);
		}
	
	}
	
	
	
}
