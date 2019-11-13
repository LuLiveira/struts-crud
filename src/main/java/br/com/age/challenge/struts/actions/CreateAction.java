package br.com.age.challenge.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.dao.repositories.ExameRepository;
import br.com.age.challenge.struts.model.Exame;

public class CreateAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private Integer idade;
	private String data;
	private String hora;
	private String descricao;
	
	private Integer rows;
	private String response;
	
	private Exame exame;
	private ExameRepository exameRepository;
	
	
	
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


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}
	
	


	public Integer getRows() {
		return rows;
	}



	public void setRows(Integer rows) {
		this.rows = rows;
	}



	@Override
	public String execute() throws Exception {
		
		try {
			
			exame = new Exame(this.nome, this.cpf, this.idade, this.data, this.hora, this.descricao);
			exameRepository = new ExameRepository();
			rows = exameRepository.create(exame);
			
			if(rows == 0) {
				setResponse("Erro ao criar o exame.");
				return "error";
			} else {
				setResponse("Exame criado com sucesso!");
				return "success";
			}
			
		} catch (Exception e) {
			setResponse("Erro ao criar o exame.");
			return "error";
		}
	}

}
