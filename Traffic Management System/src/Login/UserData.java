package Login;

import java.io.Serializable;


public class UserData implements Serializable {
	private String name, address, phonenumber, username, password;

	public UserData(String name, String address, String phonenumber, String username, String password) {
		
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.username = username;
		this.password = password;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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
