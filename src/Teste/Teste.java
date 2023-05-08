package Teste;
import java.sql.SQLException;
import java.util.List;

import model.User;
import repository.UserDAO;

public class Teste {
	
	

	public static void main(String[] args) throws SQLException{
		
		
		UserDAO dao = new UserDAO();
		User emerson = new User(0,"Emerson", "emerson@email.com", "javadocs");
		User neymar = new User(1, "Neymar Jr.", "neymar.psg@psg.com", "12345");
		User pele = new User(2, "Pele", "pele@santos.com", "1000gols");
		User messi = new User(3, "Messi", "messi@barcelona.tequiero.com", "2022qatar");
		User ceni = new User(4, "Rogerio Ceni", "rogerio@curriculo", "desempregado");
		
	
		
		List<User> userList = dao.selectAll();
		
		
		
		for(User user : userList) {
			System.out.println("ID: " + user.getId());
			System.out.println("Nome: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Senha: " + user.getPassword());
			System.out.println("Data de Registro: " + user.getDate());
			System.out.println("   ");
		}
		
		
		User teste = dao.selectById(0);
		
		System.out.println(teste.toString());
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
