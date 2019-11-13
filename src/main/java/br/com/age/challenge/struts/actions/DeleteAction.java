package br.com.age.challenge.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.dao.repositories.ExameRepository;

public class DeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String response;
	
	private ExameRepository exameRepository = null;
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}



	@Override
	public String execute() {
		
		try {
			
			exameRepository = new ExameRepository();
			Integer rows = exameRepository.delete(id);

			if(rows > 0) {
				setResponse("Exame deletado com sucesso!");
			}else {
				setResponse("Erro ao deletar exame");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}
	

}
