package io.pradeep.springStarter.TopicController;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired private TopicService Topic;
	
		@GetMapping("/topics")
		public List<Topic> getTopics(){
			return Topic.returnTopics();
		}
	
		@GetMapping("/topics/{id}")
		public Topic getTopics(@PathVariable String id) {
			return Topic.returnTopic(id);
					
		}
		
		@PostMapping("/topics")
		public void addTopic(@RequestBody Topic topic) {
			Topic.addTopic(topic);
		}
		
		@PutMapping("/topics/{id}")
		public void updateTopic(@RequestBody Topic topic , @PathVariable String id) {
			Topic.updateTopic(id,topic);
		}
		
		@DeleteMapping("/topics/{id}")
		public void deleteTopics(@PathVariable String id) {
			 Topic.deleteTopic(id);
		}
		
}
	