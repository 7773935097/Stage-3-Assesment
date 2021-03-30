package com.cognizant.LearnTodayRESTAPI.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.LearnTodayRESTAPI.model.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setEnrollmentId(rs.getInt(1));
		student.setStudentId(rs.getInt(2));
		student.setCourseId(rs.getInt(3));
		return student;
	}

}
