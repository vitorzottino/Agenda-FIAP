package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionFactory;
import model.User;

public class UserDAO {

	private Connection conexao;

	public UserDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	public void insert(User user) throws SQLException {
		String sql = "insert into REGISTROS(ID, NOME, EMAIL, SENHA, DATA_REGISTRO) values (?, ?, ?, ?, ?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, user.getId());
		stmt.setString(2, user.getName());
		stmt.setString(3, user.getEmail());
		stmt.setString(4, user.getPassword());
		stmt.setDate(5, user.getDate());

		stmt.execute();
		stmt.close();

	}

	public void update(User user) throws SQLException {

		String sql = "update REGISTROS set nome=?, email=?, senha=? where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getPassword());
		stmt.setInt(4, user.getId());

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

	public List<User> selectAll() throws SQLException{
		
		List<User> userList = new ArrayList<User>();
		String sql = "select * from registros order by id";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("nome"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("senha"));
			user.setDate(rs.getDate("data_registro"));
			
			userList.add(user);
			
		}
		rs.close();
		stmt.close();
		return userList;
		
		
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
