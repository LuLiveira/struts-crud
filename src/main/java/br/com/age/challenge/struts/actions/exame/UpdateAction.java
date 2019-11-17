package br.com.age.challenge.struts.actions.exame;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import br.com.age.challenge.struts.dao.ExameRepository;
import br.com.age.challenge.struts.exceptions.DBException;
import br.com.age.challenge.struts.model.Exame;

@Validation()
public class UpdateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Exame exame = null;

	private ExameRepository exameRepository = null;

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

	@SkipValidation
	@Override
	public String execute() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		this.exame = new Exame();

		try {

			exameRepository = new ExameRepository();
			ResultSet result = exameRepository.findExameById(getId());

			if (result != null) {
				while (result.next()) {
					this.exame.setId(result.getInt("id"));
					this.exame.setNome(result.getString("nome"));
					this.exame.setEmail(result.getString("email"));
					this.exame.setTelefone(result.getString("telefone"));
					this.exame.setCpf(result.getString("cpf"));
					this.exame.setIdade(result.getInt("idade"));
					this.exame.setData(sdf.parse(result.getString("data")));
					this.exame.setDescricao(result.getString("descricao"));
				}
			}

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
		return SUCCESS;
	}

	@Validations(
			requiredFields = {
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", message = "A idade doo paciente é obrigatória."),
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.data", message = "A data do exame é obrigatória.")}, 
			emails = {
					@EmailValidator(type = ValidatorType.SIMPLE, fieldName = "exame.email", message = "O e-mail é inválido.") }, 
			intRangeFields = {
							@IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "exame.idade", min = "1", max = "150", message = "O paciente deve ter idade maior que ${min}."),
			})
	public String update() {
		

		try {
			exameRepository = new ExameRepository();
			exameRepository.update(getExame());

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}

		return SUCCESS;
	}
	
	
}
