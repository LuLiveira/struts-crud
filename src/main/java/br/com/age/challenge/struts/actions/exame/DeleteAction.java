package br.com.age.challenge.struts.actions.exame;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

import br.com.age.challenge.struts.services.ExameService;

public class DeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@Inject("exameService")
	private ExameService exameService;

	@Override
	public String execute() {
		return exameService.deleteExame(getId());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ExameService getExameService() {
		return exameService;
	}

	public void setExameService(ExameService exameService) {
		this.exameService = exameService;
	}
}
