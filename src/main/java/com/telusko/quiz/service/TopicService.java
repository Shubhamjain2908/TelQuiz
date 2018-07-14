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
	
	/**
	 * Get list of all topics
	 * @return
	 */
	public List<TopicModel> getTopics() 
	{
		return tR.findAll();
	}
	
	/**
	 * Method to add a topic in a particular subject
	 * @param subjectName
	 * @param topicName
	 * @return
	 */
	public TopicModel addTopic(String subjectName, String topicName) 
	{
		if(null == sR.findByName(subjectName)) 
		{
			throw new BadRequestException("No subject exists..");
		} 
		if(tR.findByName(topicName) != null) 
		{
			throw new BadRequestException("Topic already exists..");
		}
		return null;
	}
	
	/**
	 * Method to remove a topic
	 * @param topicName
	 */
	public void removeTopic(String topicName) 
	{
		if(tR.findByName(topicName) == null) 
		{
			throw new BadRequestException("Topic does not exists..");
		}
		tR.deleteById(0);	// Integer
	}
}
