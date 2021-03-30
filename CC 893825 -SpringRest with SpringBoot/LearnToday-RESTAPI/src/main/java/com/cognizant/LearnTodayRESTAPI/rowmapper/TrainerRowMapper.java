package com.cognizant.LearnTodayRESTAPI.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.cognizant.LearnTodayRESTAPI.model.Trainer;

public class TrainerRowMapper implements RowMapper<Trainer> {

	@Override
	public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trainer trainer = new Trainer();
		trainer.setTrainerId(rs.getInt(1));
		trainer.setPassWord(rs.getString(2));
		return trainer;
	}

}
