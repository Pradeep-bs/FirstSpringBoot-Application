package io.pradeep.springStarter.Course;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.pradeep.springStarter.TopicController.Topic;

@RestController
public class CourseController {

	@Autowired private CourseService Course;
	
		@GetMapping("/topics/{id}/courses")
		public List<Course> getCourses(@PathVariable String id){
			return Course.returnCourses(id);
		}
	
		@GetMapping("/topics/{topicId}/courses/{id}")
		public Course getCourse(@PathVariable String id) {
			return Course.returnCourse(id);
					
		}
		
		@PostMapping("/topics/{topicId}/courses")
		public void addCourse(@RequestBody Course course ,@PathVariable String topicId ) {
			course.setTopic(new Topic(topicId,"",""));
			Course.addCourse(course);
		}
		
		@PutMapping("/topics/{topicId}/courses/{id}")
		public void updateCourse(@RequestBody Course course ,@PathVariable String topicId, @PathVariable String id) {
			Course.updateCourse(course);
		}
		
		@DeleteMapping("/topics/{topicId}/courses/{id}")
		public void deleteCourse(@PathVariable String id) {
			Course.deleteCourse(id);
		}
		
}
	