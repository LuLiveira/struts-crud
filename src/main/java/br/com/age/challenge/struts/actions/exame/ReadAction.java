package br.com.age.challenge.struts.actions.exame;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

import br.com.age.challenge.struts.model.Exame;
import br.com.age.challenge.struts.services.ExameService;

public class ReadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	List<Exame> exameList = null;

	@Inject("exameService")
	private ExameService exameService;

	@Override
	public String execute() {
		setExameList(exameService.listExame());
		return getExameList().size() > 0 ? SUCCESS : ERROR;
	}

	public List<Exame> getExameList() {
		return exameList;
	}

	public void setExameList(List<Exame> exameList) {
		this.exameList = exameList;
	}

	public ExameService getExameService() {
		return exameService;
	}

	public void setExameService(ExameService exameService) {
		this.exameService = exameService;
	}
}
