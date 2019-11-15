package br.com.age.challenge.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.dao.ExameRepository;
import br.com.age.challenge.struts.exceptions.DBException;

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
			exameRepository.delete(id);

		}catch(Exception e) {
			throw new DBException(e.getMessage());
		}
		return SUCCESS;
	}
	

}
