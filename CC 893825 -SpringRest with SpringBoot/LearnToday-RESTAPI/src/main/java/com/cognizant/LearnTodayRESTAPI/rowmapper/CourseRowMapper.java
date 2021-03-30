package com.cognizant.LearnTodayRESTAPI.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.LearnTodayRESTAPI.dao.impl.StudentDaoImpl;
import com.cognizant.LearnTodayRESTAPI.model.Course;


public class CourseRowMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getInt(1));
		course.setTitle(rs.getString(2));
		course.setFees(rs.getFloat(3));
		course.setDescription(rs.getString(4));
		course.setTrainer(rs.getString(5));
		course.setStartDate(rs.getDate(6));
		StudentDaoImpl dao = new StudentDaoImpl();
		course.setStudents(dao.getStudentByCourseId(rs.getInt(1)));
		return course;
	}
}
