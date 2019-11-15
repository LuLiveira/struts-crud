package br.com.age.challenge.struts.actions;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.dao.ExameRepository;
import br.com.age.challenge.struts.exceptions.DBException;
import br.com.age.challenge.struts.model.Exame;

public class UpdateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Exame exame = null;

	private ExameRepository exameRepository = null;
	

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String execute() {
		
		this.exame = new Exame();
		
		try {
			
			exameRepository = new ExameRepository();
			ResultSet result = exameRepository.findExameById(getId());
			

			if (result != null) {
				while (result.next()) {
					this.exame.setId(result.getInt("id"));
					this.exame.setNome(result.getString("nome"));
					this.exame.setCpf(result.getString("cpf"));
					this.exame.setIdade(result.getInt("idade"));
					this.exame.setData(result.getString("data"));
					this.exame.setHora(result.getString("hora"));
					this.exame.setDescricao(result.getString("descricao"));
				}
			}
		}catch(Exception e) {
			throw new DBException(e.getMessage());
		}
		return SUCCESS;
	}
	
	public String update() {	
		
		try {
			
			exameRepository = new ExameRepository();
			exameRepository.update(getId(), this.exame);

			
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}	
		
		return SUCCESS;
	}	
	
}
