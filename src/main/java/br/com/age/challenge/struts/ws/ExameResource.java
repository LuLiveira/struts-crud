package br.com.age.challenge.struts.ws;

import br.com.age.challenge.struts.model.Exame;
import br.com.age.challenge.struts.services.ExameService;

public class ExameResource {
	
	public Exame list (Long id) {
		
		ExameService exameService = new ExameService();
		Exame exame = exameService.findExameById(id);

		return exame;
	}
}
