package com.cognizant.LearnTodayRESTAPI.dao.impl;

import javax.sql.DataSource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidTrainerIdException;
import com.cognizant.LearnTodayRESTAPI.model.Trainer;

public class TrainerDaoImpl implements com.cognizant.LearnTodayRESTAPI.dao.TrainerDao {

	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/learntodayrestapidb");
		dataSource.setUsername("Debajyoti");
		dataSource.setPassword("abcd1234");
		return dataSource;
	}

	JdbcTemplate template = new JdbcTemplate(dataSource());
	
	@Override
	public int signUp(Trainer trainer) throws DuplicateKeyException {
		String sql = "insert into trainer values (?,?)";
		int rowsAffected = template.update(sql, trainer.getTrainerId(), trainer.getPassWord());
		return rowsAffected;
	}

	@Override
	public int updatePassWord(int trainerId, Trainer trainer) throws InvalidTrainerIdException {
		String sql = "update trainer set Password=? where TrainerId=?";
		int rowsAffected = template.update(sql, trainer.getPassWord(), trainerId);
		if(rowsAffected==0)
			throw new InvalidTrainerIdException("Searched data not found");
		return rowsAffected;
	}

}
