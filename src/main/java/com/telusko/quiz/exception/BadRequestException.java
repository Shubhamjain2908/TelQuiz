package com.telusko.quiz.exception;

/**
 * Class to handle BadRequestException
 * 
 * @author SHUBHAM
 * @since 22-06-2018
 */
public class BadRequestException extends RuntimeException
{
	private static final long serialVersionUID = 758342286647924480L;
	
	public BadRequestException(String message) 
	{
		super(message);
	}	
}