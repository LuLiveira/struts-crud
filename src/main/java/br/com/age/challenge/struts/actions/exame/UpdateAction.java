package br.com.age.challenge.struts.actions.exame;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import br.com.age.challenge.struts.model.Exame;
import br.com.age.challenge.struts.services.ExameService;

@Validation()
public class UpdateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Exame exame;
	
	@Inject("exameService")
	private ExameService exameService;


	@SkipValidation
	@Override
	public String execute() {
		setExame(exameService.findExameById(getId()));
		return getExame() != null ? SUCCESS : ERROR; 
	}

	@Validations(
			emails = {
					@EmailValidator(type = ValidatorType.SIMPLE, fieldName = "exame.email", message = "O e-mail é inválido.") }, 
			intRangeFields = {
							@IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", min = "1", max = "150", message = "O paciente deve ter idade maior que ${min}."),
			})
	public String update() {
		Integer update = exameService.update(getExame());
		return update == 1 ? SUCCESS : ERROR;
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
}
