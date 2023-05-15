package Teste;
import java.sql.SQLException;
import java.util.List;

import model.User;
import repository.UserDAO;

public class Teste {
	
	

	public static void main(String[] args) throws SQLException{
		
		
		User vitor = new User("Vitor", "vitor@fiap.com", "admin");
		UserDAO dao = new UserDAO();
		List<User> userList = dao.selectAll();
		
		dao.insert(vitor);
		
		for(User user : userList) {
			System.out.println("ID: " + user.getId());
			System.out.println("Nome: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Senha: " + user.getPassword());
			System.out.println("Data de Registro: " + user.getDate());
			System.out.println("   ");
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
