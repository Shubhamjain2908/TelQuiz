package com.telusko.quiz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.service.QuestionService;
import org.springframework.http.HttpStatus;
/**
 * This is a controller for handling/delegating requests to service layer.
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 * 
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService qS;
	
	@GetMapping
	public ResponseEntity<List<SubjectModel>> getSubjects() 
	{
		return new ResponseEntity<List<SubjectModel>>(qS.getAllQuestions(), HttpStatus.FOUND);
	}
	
	@GetMapping(value="/{subjectID}")
	public ResponseEntity<SubjectModel> getSubject(@PathVariable("subjectID") String subjectID, @RequestParam Map<String,String> allRequestParam) 
	{
		return new ResponseEntity<SubjectModel>(qS.getQuestions(subjectID, allRequestParam), HttpStatus.FOUND);
	}

}
