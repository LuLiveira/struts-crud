package br.com.age.challenge.struts.actions.exame;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
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
	private ExameService exameService = null;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Validations(
           requiredFields = {
        		   	@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", message = "A idade do paciente é obrigatória."),
        		   	@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.data", message = "A data do exame é obrigatória."),
        		   	@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.email", message = "O e-mail do paciente é obrigatório.")
           },
			emails = {
					@EmailValidator(type = ValidatorType.SIMPLE, fieldName = "exame.email", message = "Insira um e-mail válido.") }, 
			intRangeFields = {
					@IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", min = "1", max = "150", message = "Idade do paciente deve ser maior que ${min}.") }
	)
	public String execute() throws Exception {
		exameService = new ExameService();
		Long id = exameService.createExame(exame);
		setId(id);
		
		return getId() > 0 ? "success" : "error"; 
	}

	@Override
	public void validate() {
		if (exame.getNome().length() == 0) {
			addFieldError("exame.nome", "O nome do paciente é obrigatório.");
		}
		
		if (exame.getCpf().length() < 11) {
			addFieldError("exame.cpf", "O CPF informado é inválido!");
		}

		if (exame.getDescricao().length() == 0) {
			addFieldError("exame.descricao",
					"A descrição do exame irá ajudar o médico. Por favor, informe uma descrição.");
		}

		if (exame.getTelefone().length() == 0) {
			addFieldError("exame.telefone",
					"Telefone inválido. Digite um telefone válido.");
		}
	}
	
	
	public String message() {
		exameService = new ExameService();
		Exame exame = exameService.findExameById(getId());
		setExame(exame);	
		return SUCCESS;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

}
