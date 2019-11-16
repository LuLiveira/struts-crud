package br.com.age.challenge.struts.services;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.age.challenge.struts.dao.ExameRepository;
import br.com.age.challenge.struts.exceptions.DBException;
import br.com.age.challenge.struts.model.Exame;

public class ExameService {

	private ExameRepository exameRepository = null;

	public String createExame(Exame exame) {
		exameRepository = new ExameRepository();
		Integer create = exameRepository.create(exame);

		if (create > 0) {
			return "success";
		}

		return "error";
	}

	public String deleteExame(Integer id) {
		exameRepository = new ExameRepository();
		Integer delete = exameRepository.delete(id);

		if (delete > 0) {
			return "success";
		}

		return "error";

	}

	public List<Exame> listExame() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		ArrayList<Exame> exameList = new ArrayList<Exame>();

		exameRepository = new ExameRepository();

		ResultSet resultSet = exameRepository.read();

		if (resultSet != null) {

			try {

				while (resultSet.next()) {
					Exame exame = new Exame();

					exame.setId(resultSet.getInt("id"));
					exame.setNome(resultSet.getString("nome"));
					exame.setTelefone(resultSet.getString("telefone"));
					exame.setEmail(resultSet.getString("email"));
					exame.setCpf(resultSet.getString("cpf"));
					exame.setData(sdf.parse(resultSet.getString("data")));
					exame.setDescricao(resultSet.getString("descricao"));
					exame.setIdade(resultSet.getInt("idade"));

					exameList.add(exame);
				}
				resultSet.close();

				return exameList;

			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
		return null;

	}

}
