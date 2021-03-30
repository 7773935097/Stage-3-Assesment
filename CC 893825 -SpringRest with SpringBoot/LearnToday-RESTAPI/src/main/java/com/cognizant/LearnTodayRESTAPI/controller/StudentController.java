package com.cognizant.LearnTodayRESTAPI.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.dao.CourseDao;
import com.cognizant.LearnTodayRESTAPI.dao.StudentDao;
import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidEnrollmentIdException;
import com.cognizant.LearnTodayRESTAPI.dao.impl.CourseDaoImpl;
import com.cognizant.LearnTodayRESTAPI.dao.impl.StudentDaoImpl;
import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.model.Student;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@GetMapping("/getAllCourses")
	public ResponseEntity<Object> getAllCourses(){
		CourseDao dao = new CourseDaoImpl();
		List<Course> courses =  dao.getAllCourses();
		if(courses.size()==0) {
			return new ResponseEntity<>("No courses found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	@PostMapping("/postStudent")
	public ResponseEntity<Object> postStudent(@RequestBody Student student){
		StudentDao dao = new StudentDaoImpl();
		try {
			dao.register(student);
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteStudentEnrollment/{enrollmentId}")
	public ResponseEntity<Object> deleteStudentEnrollment(@PathVariable int enrollmentId){
		StudentDao dao = new StudentDaoImpl();
			try {
				dao.delete(enrollmentId);
				return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
			} catch (InvalidEnrollmentIdException e) {
				return new ResponseEntity<>("No enrollment information found", HttpStatus.BAD_REQUEST);
			}
	}
}
