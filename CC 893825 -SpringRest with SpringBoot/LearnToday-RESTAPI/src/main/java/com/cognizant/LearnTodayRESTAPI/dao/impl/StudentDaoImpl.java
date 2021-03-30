package com.cognizant.LearnTodayRESTAPI.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.LearnTodayRESTAPI.dao.StudentDao;
import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidEnrollmentIdException;
import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.model.Student;
import com.cognizant.LearnTodayRESTAPI.rowmapper.CourseRowMapper;
import com.cognizant.LearnTodayRESTAPI.rowmapper.StudentRowMapper;

public class StudentDaoImpl implements StudentDao {

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
	public int register(Student student) throws DuplicateKeyException, DataIntegrityViolationException{
		String sql = "insert into student values (?,?,?)";
		int rowAffected = template.update(sql, student.getEnrollmentId(), student.getStudentId(), student.getCourseId());
		return rowAffected;
	}

	@Override
	public Course getCourseById(int courseId) {
		String sql = "select * from course where CourseId=?";
		CourseRowMapper crm = new CourseRowMapper();
		Course course = template.queryForObject(sql, crm, courseId);
		return course;
	}

	@Override
	public int delete(int enrollmentId) throws InvalidEnrollmentIdException {
		String sql = "delete from student where EnrollmentId =?";
		int rowAffected = template.update(sql, enrollmentId);
		if(rowAffected==0) {
			throw new InvalidEnrollmentIdException("No enrollment information found");
		}
		return rowAffected;
	}
	
	@Override
	public List<Student> getStudentByCourseId(int courseId){
		String sql = "select enrollmentid, studentid, s.courseid from student s, course c where c.courseId = s.courseId and c.courseId =?";
		StudentRowMapper srm = new StudentRowMapper();
		List<Student> students = template.query(sql, srm, courseId);
		return students;
	}

}
