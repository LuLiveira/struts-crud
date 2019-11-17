package br.com.age.challenge.struts.ws;

import br.com.age.challenge.struts.model.Exame;
import br.com.age.challenge.struts.services.ExameService;

public class ExameResource {
	
	private ExameService exameService = null;
	
	public Exame list (Long id) {
		
		exameService = new ExameService();
		Exame exame = exameService.findExameById(id);

		return exame;
	}
}
