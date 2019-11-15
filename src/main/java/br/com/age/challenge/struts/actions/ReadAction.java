package br.com.age.challenge.struts.actions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.age.challenge.struts.dao.ExameRepository;
import br.com.age.challenge.struts.exceptions.DBException;
import br.com.age.challenge.struts.model.Exame;

public class ReadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	 Exame exame = null;
	
	 ResultSet resultSet = null;

	 List<Exame> exameList = null;

	 ExameRepository exameRepository;
	
	 boolean exists = true;

	public List<Exame> getExameList() {
		return exameList;
	}

	public void setExameList(List<Exame> exameList) {
		this.exameList = exameList;
	}
	

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	@Override
	public String execute() throws Exception {
		try {

			exameList = new ArrayList<Exame>();
			
			exameRepository = new ExameRepository();

			resultSet = exameRepository.read();
			
			if (resultSet != null) {	

				while (resultSet.next()) {
					exame = new Exame();

					exame.setId(resultSet.getInt("id"));
					exame.setNome(resultSet.getString("nome"));
					exame.setTelefone(resultSet.getString("telefone"));
					exame.setEmail(resultSet.getString("email"));
					exame.setCpf(resultSet.getString("cpf"));
					exame.setData(resultSet.getString("data"));
					exame.setHora(resultSet.getString("hora"));
					exame.setDescricao(resultSet.getString("descricao"));
					exame.setIdade(resultSet.getInt("idade"));

					exameList.add(exame);
				}
				resultSet.close();
			}

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
		
		return SUCCESS;
	}

}
