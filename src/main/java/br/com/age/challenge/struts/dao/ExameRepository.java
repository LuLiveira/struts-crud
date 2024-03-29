package br.com.age.challenge.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;

import br.com.age.challenge.struts.configuration.DB;
import br.com.age.challenge.struts.exceptions.DBException;
import br.com.age.challenge.struts.model.Exame;

public class ExameRepository {

	private final Locale locale = new Locale("pt", "BR");
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm", locale);

	private Connection connection = null;

	public ExameRepository() {
		connection = DB.connection();
	}

	public Long create(Exame exame) {

		String query = "insert into exames (nome, telefone, email, cpf, idade, data, descricao) values (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, exame.getNome());
			preparedStatement.setString(2, exame.getTelefone());
			preparedStatement.setString(3, exame.getEmail());
			preparedStatement.setString(4, exame.getCpf());
			preparedStatement.setInt(5, exame.getIdade());
			preparedStatement.setString(6, this.sdf.format(exame.getData()));
			preparedStatement.setString(7, exame.getDescricao());

			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			return resultSet.next() ? resultSet.getLong(1) : null;

		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	public List<Exame> read() {
		
		List<Exame> list = new ArrayList<Exame>();

		String query = "select exames.* from exames as exames";

		try {

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			if (resultSet != null) {

			try {

				while (resultSet.next()) {
					Exame exame = new Exame();

					exame.setId(resultSet.getInt("id"));
					exame.setNome(resultSet.getString("nome"));
					exame.setTelefone(resultSet.getString("telefone"));
					exame.setEmail(resultSet.getString("email"));
					exame.setCpf(resultSet.getString("cpf"));
					exame.setData(this.sdf.parse(resultSet.getString("data")));
					exame.setDescricao(resultSet.getString("descricao"));
					exame.setIdade(resultSet.getInt("idade"));

					list.add(exame);
				}
				resultSet.close();

				return list;
				
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}

	}

	public Integer update(Exame exame) {

		try {
			this.connection.setAutoCommit(false);

			String query = "update exames set nome=?, telefone=?, email=?, idade=?, data=?, descricao=?, cpf=? where id=?";

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setString(1, exame.getNome());
			prepareStatement.setString(2, exame.getTelefone());
			prepareStatement.setString(3, exame.getEmail());
			prepareStatement.setInt(4, exame.getIdade());
			prepareStatement.setString(5, this.sdf.format(exame.getData()));
			prepareStatement.setString(6, exame.getDescricao());
			prepareStatement.setString(7, exame.getCpf());
			prepareStatement.setInt(8, exame.getId());

			int executeUpdate = prepareStatement.executeUpdate();

			this.connection.commit();

			return executeUpdate;

		} catch (SQLException e) {
			try {
				this.connection.rollback();
			} catch (SQLException e1) {
				throw new DBException(e1.getMessage());
			}
			throw new DBException(e.getMessage());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}

	}

	public Integer delete(Integer id) {

		try {
			this.connection.setAutoCommit(false);

			String query = "delete from exames where id=?";

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setInt(1, id);

			int executeUpdate = prepareStatement.executeUpdate();

			this.connection.commit();

			return executeUpdate;

		} catch (SQLException e) {
			try {
				this.connection.rollback();
			} catch (SQLException e1) {
				throw new DBException(e.getMessage());
			}
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		return 0;
	}

	public ResultSet findExameById(Long id) {

		String query = "select exame.* from exames as exame where id=?";

		try {
			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setLong(1, id);

			return prepareStatement.executeQuery();
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}

	public boolean findByDateAndCpf(String date, String nextDate, String cpf) {
		String query = "select exame.id from exames as exame where data between ? and ? and cpf=?";
		
		try {
			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setString(1, date);
			prepareStatement.setString(2, nextDate);
			prepareStatement.setString(3, cpf);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			if (resultSet.next()) {
				return true;
			}
			resultSet.close();
			return false;
			
		}catch(Exception e) {
			throw new DBException(e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		
	}

}
