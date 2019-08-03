package io.pradeep.springStarter.TopicController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired private TopicRepository topicRepo;
	
	public List<Topic> returnTopics() {
		List<Topic> topic =  new ArrayList<Topic>();
		Iterable<Topic> iter=topicRepo.findAll();	
		for (Topic temp:iter) {
			topic.add(temp);
		}		
		return topic;
		}
	
	public Topic returnTopic(String topicSent) {
		return topicRepo.findOne(topicSent);
	}

	public void addTopic(Topic topic) {
		topicRepo.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepo.save(topic);
		
	}

	public void deleteTopic(String id) {
		topicRepo.delete(id);
	}
	
}
