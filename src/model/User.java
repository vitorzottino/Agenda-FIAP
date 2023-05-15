package model;

import java.sql.Date;

import br.com.fiap.util.CriptoUtil;

//javabeans
public class User {

	private int id;
	private String name;
	private String email;
	private Date date = new Date(System.currentTimeMillis());
	private String password;

	public User() {

	}

	public User(String name, String email, String password) {

		this.name = name;
		this.email = email;
		setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			this.password = CriptoUtil.criptografar(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return "User= " + id + " \nNome= " + name + " \nEmail= " + email + " \nDate= " + date + " \nPassword= "
				+ password;
	}

}
