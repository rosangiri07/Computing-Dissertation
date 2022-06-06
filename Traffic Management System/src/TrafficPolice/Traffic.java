package TrafficPolice;

import java.io.Serializable;

public class Traffic implements Serializable {
	
	 
	private String id, firstname, surname, username, password;
	public Traffic(String id, String firstname, String surname, String username, String password) {
		
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
