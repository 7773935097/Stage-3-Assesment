package com.cognizant.LearnTodayRESTAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.dao.CourseDao;
import com.cognizant.LearnTodayRESTAPI.dao.impl.CourseDaoImpl;
import com.cognizant.LearnTodayRESTAPI.model.Course;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<Object> getAllCourses(){
		CourseDao dao = new CourseDaoImpl();
		List<Course> courses =  dao.getAllCourses();
		if(courses.size()==0) {
			return new ResponseEntity<>("No courses found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	@GetMapping("/getCourseById/{courseId}")
	public ResponseEntity<Object> getCourseById(@PathVariable int courseId){
		CourseDao dao = new CourseDaoImpl();
		List<Course> courses =  dao.getCourseById(courseId);
		if(courses.isEmpty()) {
			return new ResponseEntity<>("Searched Data not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
}
