package br.com.age.challenge.struts.actions;

public class LoginAction {
	
	private String username;
	
	private String password;
	
	public String authenticate() {
		if(this.username.equals("admin") && this.password.equals("admin"))
			return "success";
		else
			return "error";
		
		
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
