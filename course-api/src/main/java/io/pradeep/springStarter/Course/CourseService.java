package io.pradeep.springStarter.Course;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired private CourseRepository courseRepo;
	
	public List<Course> returnCourses(String topicId) {
		List<Course> course =  new ArrayList<Course>();
		Iterable<Course> iter=courseRepo.findByTopicId(topicId);	
		for (Course temp:iter) {
			course.add(temp);
		}		
		return course;
		}
	
	public Course returnCourse(String topicSent) {
		return courseRepo.findOne(topicSent);
	}

	public void addCourse(Course topic) {
		courseRepo.save(topic);
	}

	public void updateCourse(Course topic) {
		courseRepo.save(topic);
		
	}

	public void deleteCourse(String id) {
		courseRepo.delete(id);
	}
	
}
