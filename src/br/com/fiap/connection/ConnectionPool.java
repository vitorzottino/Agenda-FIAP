package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {

	private static String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static DataSource conexao = null;

	// singleton para um único pool de conexões
	private ConnectionPool() {

	}

	public static Connection conectar() throws SQLException {
		if (conexao == null) {
			final ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(ORACLE);
			comboPooledDataSource.setUser("rm93360");
			comboPooledDataSource.setPassword("100903");
			// número máximo de conexões
			comboPooledDataSource.setMaxPoolSize(5);
			conexao = comboPooledDataSource;
		}
		return conexao.getConnection();
	}

}
