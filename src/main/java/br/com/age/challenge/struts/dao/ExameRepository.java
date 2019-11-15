package br.com.age.challenge.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.age.challenge.struts.configuration.DB;
import br.com.age.challenge.struts.exceptions.DBException;
import br.com.age.challenge.struts.model.Exame;

public class ExameRepository {

	private Connection connection = null;

	public ExameRepository() throws ClassNotFoundException {
		connection = DB.connection();
	}

	public void create(Exame exame) throws Exception {
		
		System.out.println(exame);

		String query = "insert into exames (nome, telefone, email, cpf, idade, data, hora, descricao) values (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			
			
			preparedStatement.setString(1, exame.getNome());
			preparedStatement.setString(2, exame.getTelefone());
			preparedStatement.setString(3, exame.getEmail());
			preparedStatement.setString(4, exame.getCpf());
			preparedStatement.setInt(5, exame.getIdade());
			preparedStatement.setString(6, exame.getData());
			preparedStatement.setString(7, exame.getHora());
			preparedStatement.setString(8, exame.getDescricao());

			preparedStatement.executeUpdate();
			
		} catch(Exception e) {			
			throw new DBException(e.getMessage());
		} finally {
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

	public void update(Integer id, Exame exame)
			throws SQLException {

		this.connection.setAutoCommit(false);
		
		String query = "update exames set nome=?, telefone=?, email=?, idade=?, data=?, hora=?, descricao=? , cpf=? where id=?";

		try {

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setString(1, exame.getNome());
			prepareStatement.setString(2, exame.getTelefone());
			prepareStatement.setString(3, exame.getEmail());
			prepareStatement.setInt(4, exame.getIdade());
			prepareStatement.setString(5, exame.getData());
			prepareStatement.setString(6, exame.getHora());
			prepareStatement.setString(7, exame.getDescricao());
			prepareStatement.setString(8, exame.getCpf());
			prepareStatement.setInt(9, id);

			prepareStatement.executeUpdate();
			
			this.connection.commit();
			
		} catch (SQLException e) {
			this.connection.rollback();
		} finally {
			this.connection.close();
		}

	}

	public void delete(Integer id) throws SQLException {

		this.connection.setAutoCommit(false);

		String query = "delete from exames where id=?";

		try {

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setInt(1, id);

			prepareStatement.executeUpdate();
			
			this.connection.commit();

		} catch (SQLException e) {
			this.connection.rollback();
		} finally {
			this.connection.close();
		}
	}

	public ResultSet findExameById(Integer id) {
		
		String query = "select * from exames where id=?";

		try {
			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setInt(1, id);
			
			return prepareStatement.executeQuery();
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}

}