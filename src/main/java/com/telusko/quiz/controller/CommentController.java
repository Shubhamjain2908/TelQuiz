package com.telusko.quiz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="")
public class CommentController {
	public void co(@PathVariable("id") int id) 
	{
		
	}
}
