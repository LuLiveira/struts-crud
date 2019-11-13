package br.com.age.challenge.struts.dao.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.age.challenge.struts.dao.DB;
import br.com.age.challenge.struts.model.Exame;

public class ExameRepository {

	private Connection connection = null;

	public ExameRepository() throws ClassNotFoundException {
		connection = DB.connection();
	}

	public Integer create(Exame exame) throws Exception {

		String query = "insert into exames (nome, cpf, idade, data, hora, descricao) values (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS)) {
			
			
			preparedStatement.setString(1, exame.getNome());
			preparedStatement.setString(2, exame.getCpf());
			preparedStatement.setInt(3, exame.getIdade());
			preparedStatement.setString(4, exame.getData());
			preparedStatement.setString(5, exame.getHora());
			preparedStatement.setString(6, exame.getDescricao());

			Integer rows = preparedStatement.executeUpdate();
			
			return rows;
			
		} catch(Exception e) {
			
			Integer rows = 0;
			return rows;
			
		}finally {

			this.connection.close();
		}
	}

	public ResultSet read() throws SQLException {

		String query = "select * from exames";

		try {

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			return resultSet;
		} finally {
			
		}

	}

	public Integer update(Integer id, Exame exame)
			throws SQLException {

		this.connection.setAutoCommit(false);

		int rows = 0;
		
		String query = "update exames set nome=?, idade=?, data=?, hora=?, descricao=? , cpf=? where id=?";

		try {

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setString(1, exame.getNome());
			prepareStatement.setInt(2, exame.getIdade());
			prepareStatement.setString(3, exame.getData());
			prepareStatement.setString(4, exame.getHora());
			prepareStatement.setString(5, exame.getDescricao());
			prepareStatement.setString(6, exame.getCpf());
			prepareStatement.setInt(7, id);

			rows = prepareStatement.executeUpdate();
			
			this.connection.commit();
			
		} catch (SQLException e) {
			this.connection.rollback();
		} finally {
			this.connection.close();
		}
		
		return rows;

	}

	public Integer delete(Integer id) throws SQLException {
		
		int rows = 0;

		this.connection.setAutoCommit(false);

		String query = "delete from exames where id=?";

		try {

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setInt(1, id);

			rows = prepareStatement.executeUpdate();
			
			this.connection.commit();

		} catch (SQLException e) {
			this.connection.rollback();
		} finally {
			this.connection.close();
		}
		return rows;

	}

	public ResultSet findExameById(Integer id) {
		
		String query = "select * from exames where id=?";

		try {
			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setInt(1, id);
			
			return prepareStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}