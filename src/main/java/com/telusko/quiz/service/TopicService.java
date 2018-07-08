package com.telusko.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quiz.entity.TopicModel;
import com.telusko.quiz.exception.BadRequestException;
import com.telusko.quiz.repository.SubjectRepository;
import com.telusko.quiz.repository.TopicRepository;

/**
 * This is a service layer which generates response
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 */
@Service
public class TopicService {

	@Autowired
	private TopicRepository tR;
	
	@Autowired
	private SubjectRepository sR;
	
	public List<TopicModel> getTopics() 
	{
		return tR.findAll();
	}
	
	public TopicModel addTopic(String subjectName, String topicName) 
	{
		if(sR.findByName(subjectName) == null) 
		{
			throw new BadRequestException("No subject exists..");
		} 
		if(tR.findById(topicName) != null) 
		{
			throw new BadRequestException("Topic already exists..");
		}
		TopicModel t = new TopicModel();
		t.setName(topicName);
		return tR.save(t);
	}
	
	public void removeTopic(String topicName) 
	{
		if(tR.findById(topicName) == null) 
		{
			throw new BadRequestException("Topic does not exists..");
		}
		tR.deleteById(topicName);
	}
}
