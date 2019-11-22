package br.com.age.challenge.struts.services;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.age.challenge.struts.dao.ExameRepository;
import br.com.age.challenge.struts.exceptions.DBException;
import br.com.age.challenge.struts.model.Exame;

public class ExameService {

	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	
	private ExameRepository exameRepository = null;

	public Long createExame(Exame exame) {
		exameRepository = new ExameRepository();
		Long id = exameRepository.create(exame);
		return id;
	}

	public String deleteExame(Integer id) {
		exameRepository = new ExameRepository();
		Integer delete = exameRepository.delete(id);	
		return delete == 1 ? "success" : "error";
	}

	public List<Exame> listExame() {
		
		exameRepository = new ExameRepository();
		return exameRepository.read();

	}

	public Exame findExameById(Long id) {
		exameRepository = new ExameRepository();

		ResultSet resultSet = exameRepository.findExameById(id);

		Exame exame = new Exame();

		if (resultSet != null) {

			try {

				while (resultSet.next()) {

					exame.setId(resultSet.getInt("id"));
					exame.setNome(resultSet.getString("nome"));
					exame.setTelefone(resultSet.getString("telefone"));
					exame.setEmail(resultSet.getString("email"));
					exame.setCpf(resultSet.getString("cpf"));
					exame.setData(this.sdf.parse(resultSet.getString("data")));
					exame.setDescricao(resultSet.getString("descricao"));
					exame.setIdade(resultSet.getInt("idade"));
				}
				resultSet.close();
				return exame;
			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
		return null;
	}

	public Integer update(Exame exame) {

		exameRepository = new ExameRepository();
		Integer update = exameRepository.update(exame);

		return update;
	}

	public boolean findByDateAndCpf(Date data, String cpf) {
		exameRepository = new ExameRepository();
		Date incrementDate = incrementDate(data);
		boolean hasExameToday = exameRepository.findByDateAndCpf(this.sdf.format(data), this.sdf.format(incrementDate), cpf);	
		return hasExameToday;
	}
	
	private Date incrementDate(Date data) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.DATE, 1);
		Date nextDate = c.getTime();
		return nextDate;
	}

}
