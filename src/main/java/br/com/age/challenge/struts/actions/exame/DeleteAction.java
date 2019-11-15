package br.com.age.challenge.struts.actions.exame;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.dao.ExameRepository;
import br.com.age.challenge.struts.exceptions.DBException;

public class DeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private ExameRepository exameRepository = null;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
