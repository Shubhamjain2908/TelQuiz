package com.telusko.quiz.exception;

import lombok.Data;

/**
 * Class used for error response when API throws error
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 *
 */
@Data
public class ApiErrorResponse 
{
	private String error;
	private int status;
	private String url;
	private String message;

}
