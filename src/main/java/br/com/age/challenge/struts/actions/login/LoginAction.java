package br.com.age.challenge.struts.actions.login;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String usuario;

	private String senha;

	public String authenticate() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (!this.usuario.equals("admin") && !this.senha.equals("admin")) {
			addFieldError("usuario", "Usuário incorreto.");
			addFieldError("senha", "Senha incorreta.");
		} else if (!this.usuario.equals("admin")) {
			addFieldError("usuario", "Usuário incorreto.");
		} else if (!this.senha.equals("admin")) {
			addFieldError("senha", "Senha incorreta.");
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
