package com.telusko.quiz.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.telusko.quiz.entity.QuestionModel;
import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.entity.TopicModel;
import com.telusko.quiz.exception.BadRequestException;
import com.telusko.quiz.repository.TopicRepository;
import com.telusko.quiz.repository.QuestionRepository;
import com.telusko.quiz.repository.SubjectRepository;

/**
 * This is a service layer which generates response
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 */
@Service
public class QuestionService {

	@Autowired
	private SubjectRepository sR;
	
	@Autowired
	private TopicRepository tR;
	
	@Autowired
	private QuestionRepository qR;
	
	/**
	 * Get list of all questions of all subjects
	 * @return
	 */
	public List<SubjectModel> getAllQuestions() 
	{
		return sR.findAll();
	}
	
	/**
	 * Get questions of a particular Topic in a Subject
	 * @param subjectID
	 * @param allRequestParams
	 * @return
	 */
	public SubjectModel getQuestions(String subjectID, Map<String, String> allRequestParams) 
	{
		if(allRequestParams.containsKey("topic") && !allRequestParams.get("topic").isEmpty()) 
		{
			if(null != tR.findByName(allRequestParams.get("topic"))) 
			{
				SubjectModel s = new SubjectModel();
				s.setName(subjectID);
				Set<TopicModel> topic = new HashSet<>(Arrays.asList(sR.findByName(subjectID).getTopics().stream().filter(t -> t.getName().equals(allRequestParams.get("topic"))).findFirst().get()));
				s.setTopics(topic);
				return s;
			}
			throw new BadRequestException("No topic with name " + allRequestParams.get("topic") + " present");
		}
		return sR.findByName(subjectID);
	}
	
	/**
	 * Get one questions by its ID
	 * @param id
	 * @return
	 */
	public QuestionModel getOneQuestion(Integer id) 
	{
		return qR.findById(id).get();
	}
	
	/**
	 * Add a question in a Subject
	 * @param subjectID
	 * @param topic
	 * @param question
	 * @return
	 */
	public SubjectModel addQuestions(String subjectID, String topic, QuestionModel question) 
	{	
		SubjectModel s = sR.findByName(subjectID);
		if(null == s) 
		{
			throw new BadRequestException("Subject with name " + subjectID + " is not present");
		}
		if(!StringUtils.isEmpty(topic) && null != tR.findByName(topic)) 
		{
//			TopicModel tt = s.getTopics().stream().filter(t -> t.getName().equals(topic)).findFirst().get();
//			tt.getQuestions().add(question);
			s.getTopics().stream().filter(t -> t.getName().equals(topic)).findFirst().get().getQuestions().add(question);
			return sR.save(s);
		}
		throw new BadRequestException("Mention a topic for question");
	}
}
