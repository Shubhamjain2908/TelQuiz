package com.telusko.quiz.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telusko.quiz.entity.SubjectModel;

import lombok.Data;

/**
 * Class used when API return response
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 */
@Data
@JsonInclude(Include.NON_EMPTY)
public class ApiResponse 
{	
	private String status;
	private String code;
	private SubjectModel subject; 
	private String message;
}
