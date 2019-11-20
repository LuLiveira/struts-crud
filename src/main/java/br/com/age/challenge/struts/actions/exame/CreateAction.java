package br.com.age.challenge.struts.actions.exame;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import br.com.age.challenge.struts.model.Exame;
import br.com.age.challenge.struts.services.ExameService;

@Validation()
public class CreateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Exame exame;

	@Inject("exameService")
	private ExameService exameService;

	private Long id;

	@Validations(
			requiredFields = {
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", message = "A idade do paciente é obrigatória."),
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.data", message = "A data do exame é obrigatória."),
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.email", message = "O e-mail do paciente é obrigatório."),
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.nome", message = "O nome do paciente é obrigatório."),
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.descricao", message = "A descrição do paciente é obrigatório."),
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.cpf", message = "O CPF do paciente é obrigatório."),
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.telefone", message = "O telefone do paciente é obrigatório.")}, 
			emails = {
					@EmailValidator(type = ValidatorType.SIMPLE, fieldName = "exame.email", message = "O e-mail inserido é inválido.") }, 
			intRangeFields = {
					@IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", min = "1", max = "150", message = "Idade do paciente deve ser maior que ${min}.") })
	public String execute() {
		setId(exameService.createExame(getExame()));
		return getId() > 0 ? "success" : "error";
	}

	public String message() {
		setExame(exameService.findExameById(getId()));
		return getExame() != null ? SUCCESS : ERROR;
	}

	public String formRender() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (exame.getDescricao().length() < 50) {
			addFieldError("exame.descricao",
					"A descrição do exame irá ajudar o médico. Por favor, informe uma descrição.");
		}
		
		if (exame.getNome().length() < 10) {
			addFieldError("exame.nome",
					"Insira o nome completo do paciente.");
		}
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExameService getExameService() {
		return exameService;
	}

	public void setExameService(ExameService exameService) {
		this.exameService = exameService;
	}
}
