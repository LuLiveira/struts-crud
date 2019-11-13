package br.com.age.challenge.struts.actions;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.dao.repositories.ExameRepository;
import br.com.age.challenge.struts.model.Exame;

public class UpdateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String cpf;
	private Integer idade;
	private String data;
	private String hora;
	private String descricao;
	
	private Exame exame;

	private String response;

	private ExameRepository exameRepository = null;

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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ExameRepository getExameRepository() {
		return exameRepository;
	}

	public void setExameRepository(ExameRepository exameRepository) {
		this.exameRepository = exameRepository;
	}

	@Override
	public String execute() {

		try {

			exameRepository = new ExameRepository();
			ResultSet result = exameRepository.findExameById(id);

			if (result != null) {
				while (result.next()) {
					this.id = result.getInt("id");
					this.nome = result.getString("nome");
					this.cpf = result.getString("cpf");
					this.idade = result.getInt("idade");
					this.data = result.getString("data");
					this.hora = result.getString("hora");
					this.descricao = result.getString("descricao");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "EXAME";
	}
	
	public String update() {		
		try {
			
			exame = new Exame(nome, cpf, idade, data, hora, descricao);
			
			exameRepository = new ExameRepository();
			
			Integer update = exameRepository.update(id, exame);
			
			if(update == 0) {

			} else {
				setResponse("Exame atualizado com sucesso!");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return "UPDATED";
	}
}
