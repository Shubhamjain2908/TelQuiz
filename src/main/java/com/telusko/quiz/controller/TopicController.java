package com.telusko.quiz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz.entity.TopicModel;
import com.telusko.quiz.service.TopicService;

/**
 * This is a controller for handling/delegating requests to service layer.
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 * 
 */
@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService tS;
	
	@GetMapping
	public List<TopicModel> getTopics() 
	{
		return tS.getTopics();
	}
	
	@PostMapping
	public TopicModel addTopic(@RequestParam(value="subject") String subjectName, @RequestParam(value="topic") String topicName) 
	{
		return tS.addTopic(subjectName, topicName);
	}
	
	@DeleteMapping
	public String deleteTopic(@RequestParam(value="topic") String topicName) 
	{
		tS.removeTopic(topicName);
		return "Deleted Successfully";
	}

}
