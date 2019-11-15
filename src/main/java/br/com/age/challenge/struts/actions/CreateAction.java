package br.com.age.challenge.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.dao.ExameRepository;
import br.com.age.challenge.struts.model.Exame;

public class CreateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Exame exame;
	private ExameRepository exameRepository;

	@Override
	public String execute() throws Exception {

		exameRepository = new ExameRepository();
		exameRepository.create(exame);
		return SUCCESS;
	}

	@Override
	public void validate() {

		if (exame.getNome().length() == 0) {
			addFieldError("exame.nome", "O nome é obrigatório.");
		}

		if (exame.getIdade() <= 0) {
			addFieldError("exame.idade", "A idade informada é inválida");
		}

		if (exame.getCpf().length() < 11) {
			addFieldError("exame.cpf", "O CPF informado é inválido! Não use caracteres especiais ( . , - )");
		}
		
		if(exame.getDescricao().length() == 0) {
			addFieldError("exame.descricao", "A descrição do exame irá ajudar o médico. Por favor, informe uma descrição.");
		}
		
		if(exame.getTelefone().length() == 0) {
			addFieldError("exame.telefone", "Telefone inválido. Digite um telefone válido. Não use caracteres especiais");
		}
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

}
