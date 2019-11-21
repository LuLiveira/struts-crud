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

	@Validations(requiredFields = {
			@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", message = "A idade do paciente é obrigatória."),
			@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.data", message = "A data do exame é obrigatória.") }, emails = {
					@EmailValidator(type = ValidatorType.SIMPLE, fieldName = "exame.email", message = "O e-mail inserido é inválido.") }, intRangeFields = {
							@IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", min = "1", max = "150", message = "Idade do paciente deve ser maior que ${min}.") })
	public String execute() {
		setId(exameService.createExame(getExame()));
		return getId() > 0 ? SUCCESS : ERROR;
	}

	public String message() {
		setExame(exameService.findExameById(getId()));
		return getExame() != null ? SUCCESS : ERROR;
	}

	@Override
	public void validate() {

		if (getExame().getTelefone().length() == 0) {
			addFieldError("exame.telefone", "O telefone do paciente é obrigatório.");
		}

		if (getExame().getEmail().length() == 0) {
			addFieldError("exame.email", "O e-mail do paciente é obrigatório");
		}

		if (getExame().getCpf().length() == 0) {
			addFieldError("exame.cpf", "O CPF é obrigatório");
		}

		if (getExame().getDescricao().length() < 50) {
			addFieldError("exame.descricao", "Informe o tipo de exame e as observações do mesmo.");
		}

		if (getExame().getNome().length() < 10) {
			addFieldError("exame.nome", "Insira o nome completo do paciente.");
		}

		if (getExame().getData() != null) {
			if (exameService.findByDateAndCpf(getExame().getData(), getExame().getCpf())) {
				addFieldError("exame.data", "O paciente ja possui exame marcado para a data.");
			}
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
