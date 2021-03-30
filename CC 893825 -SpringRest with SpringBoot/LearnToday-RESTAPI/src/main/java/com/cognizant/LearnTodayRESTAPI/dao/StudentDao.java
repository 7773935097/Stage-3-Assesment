package com.cognizant.LearnTodayRESTAPI.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidEnrollmentIdException;
import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.model.Student;

public interface StudentDao {
	int register(Student student) throws DuplicateKeyException, DataIntegrityViolationException;
	Course getCourseById(int courseId);
	int delete(int enrollmentId) throws InvalidEnrollmentIdException;
	List<Student> getStudentByCourseId(int courseId);
}
