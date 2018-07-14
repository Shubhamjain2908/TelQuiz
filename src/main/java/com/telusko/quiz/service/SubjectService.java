package com.telusko.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.exception.BadRequestException;
import com.telusko.quiz.repository.SubjectRepository;

/**
 * This is a service layer which generates response
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 */
@Service
public class SubjectService {

	@Autowired
	private SubjectRepository sR;
	
	/**
	 * Method to add a subject
	 * @param subjectName
	 * @return
	 */
	public SubjectModel addSubjects(String subjectName) 
	{
		SubjectModel sM = new SubjectModel();
		sM.setName(subjectName);
		if(sR.findByName(subjectName) != null) 
		{
			throw new BadRequestException("Subject already exists");
		}
		return sR.save(sM);
	}
	
	/**
	 * Method to remove a subject
	 * @param subjectName
	 */
	public void removeSubject(String subjectName) 
	{
		if(sR.findByName(subjectName) == null) 
		{
			throw new BadRequestException("Subject does not exists");
		}
		sR.deleteById(subjectName);
	}
}
