package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionPool;
import br.com.fiap.model.User;

public class UserDAO {

	private Connection conexao;

	public UserDAO() throws SQLException{
		this.conexao = ConnectionPool.conectar();
	}

	public void insert(User user) throws SQLException {
		String sql = "insert into REGISTROS(NOME, EMAIL, SENHA, DATA_REGISTRO) values (?, ?, ?, ?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getPassword());
		stmt.setDate(4, user.getDate());

		stmt.execute();
		stmt.close();

	}

	public void update(User user) throws SQLException {

		String sql = "update REGISTROS set nome=?, email=?, where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setInt(3, user.getId());

		stmt.execute();
		stmt.close();

	}
	
	public void delete(int id) throws SQLException{
		String sql = "delete from registros where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		
		stmt.close();
	}

	public List<User> selectAll() {
		List<User> usuarios = new ArrayList<User>();
		String sql = "select * from registros order by id";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User usuario = new User();
				usuario.setId(rs.getInt("id"));
				usuario.setName(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("senha"));
				usuario.setDate(rs.getDate("data_registro"));

				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public User selectById(int id) throws SQLException{
		User user = null;
		String sql = "select * from registros where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("nome"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("senha"));
			user.setDate(rs.getDate("data_registro"));
			
		}
		rs.close();
		stmt.close();
		return user;
		
	}
	
	
	
}
