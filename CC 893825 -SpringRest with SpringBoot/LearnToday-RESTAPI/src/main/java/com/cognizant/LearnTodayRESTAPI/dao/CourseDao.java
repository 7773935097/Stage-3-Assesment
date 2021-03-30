package com.cognizant.LearnTodayRESTAPI.dao;

import java.util.List;

import com.cognizant.LearnTodayRESTAPI.model.Course;

public interface CourseDao {
	List<Course> getAllCourses();
	List<Course> getCourseById(int courseId);
}
