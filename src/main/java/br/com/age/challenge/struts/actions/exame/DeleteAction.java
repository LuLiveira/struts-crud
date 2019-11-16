package br.com.age.challenge.struts.actions.exame;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.services.ExameService;

public class DeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private ExameService exameService = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String execute() {

		exameService = new ExameService();
		return exameService.deleteExame(getId());

	}
}
