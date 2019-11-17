package br.com.age.challenge.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import br.com.age.challenge.struts.configuration.DB;
import br.com.age.challenge.struts.exceptions.DBException;
import br.com.age.challenge.struts.model.Exame;

public class ExameRepository {

	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

	private Connection connection = null;

	public ExameRepository() {
		connection = DB.connection();
	}

	public Long create(Exame exame) {

		System.out.println(exame);

		String query = "insert into exames (nome, telefone, email, cpf, idade, data, descricao) values (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, exame.getNome());
			preparedStatement.setString(2, exame.getTelefone());
			preparedStatement.setString(3, exame.getEmail());
			preparedStatement.setString(4, exame.getCpf());
			preparedStatement.setInt(5, exame.getIdade());
			preparedStatement.setString(6, sdf.format(exame.getData()));
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

	public ResultSet read() {

		String query = "select * from exames";

		try {

			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			ResultSet resultSet = prepareStatement.executeQuery();

			return resultSet;
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {

		}

	}

	public Integer update(Exame exame){

		try {
			this.connection.setAutoCommit(false);

			String query = "update exames set nome=?, telefone=?, email=?, idade=?, data=?, descricao=?, cpf=? where id=?";


			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setString(1, exame.getNome());
			prepareStatement.setString(2, exame.getTelefone());
			prepareStatement.setString(3, exame.getEmail());
			prepareStatement.setInt(4, exame.getIdade());
			prepareStatement.setString(5, sdf.format(exame.getData()));
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

		String query = "select * from exames where id=?";

		try {
			PreparedStatement prepareStatement = this.connection.prepareStatement(query);
			prepareStatement.setLong(1, id);

			return prepareStatement.executeQuery();
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}

}