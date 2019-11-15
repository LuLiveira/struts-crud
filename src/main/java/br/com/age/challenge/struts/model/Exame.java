package br.com.age.challenge.struts.model;

public class Exame {

	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private Integer idade;
	private String data;
	private String hora;
	private String descricao;
	
	

	public Exame() {
	}

	public Exame(String nome, String cpf, Integer idade, String data, String hora, String descricao) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\n Telefone: " + telefone + "\n E-mail: " + email + "\n CPF: " + cpf + "\n Idade: " + idade + "\n Data: " + data + "\n Hora: "
				+ hora + "\n Descricao: " + descricao;
	}

}
