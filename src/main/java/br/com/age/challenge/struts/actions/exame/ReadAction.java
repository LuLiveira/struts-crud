package br.com.age.challenge.struts.actions.exame;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.model.Exame;
import br.com.age.challenge.struts.services.ExameService;

public class ReadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	List<Exame> exameList = null;

	private ExameService exameService = null;

	public List<Exame> getExameList() {
		return exameList;
	}

	public void setExameList(List<Exame> exameList) {
		this.exameList = exameList;
	}

	@Override
	public String execute() throws Exception {

		exameService = new ExameService();
		setExameList(exameService.listExame());

		if (getExameList().size() > 0) {
			return SUCCESS;
		}
		return ERROR;
	}

}
