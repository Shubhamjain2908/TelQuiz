package com.telusko.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.service.SubjectService;

/**
 * This is a controller for handling/delegating requests to service layer.
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 * 
 */
@RestController
@RequestMapping("/subjects/{subjectName}")
public class SubjectController {

	@Autowired
	private SubjectService sS;
	
	/**
	 * Method to add a subject
	 * @param subjectName
	 * @return
	 */
	@PostMapping
	public SubjectModel addSub(@PathVariable("subjectName") String subjectName) 
	{
		return sS.addSubjects(subjectName);
	}
	
	/**
	 * Delete a subject 
	 * @param subjectName
	 * @return
	 */
	@DeleteMapping
	public String deleteSubject(@PathVariable("subjectName") String subjectName) 
	{
		sS.removeSubject(subjectName);
		return "Deleted Successfully";
	}
}
