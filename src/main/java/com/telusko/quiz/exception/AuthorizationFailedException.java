package com.telusko.quiz.exception;

/**
 * Class to handle AuthorizationFailedException
 * 
 * @author SHUBHAM
 * @since 22-06-2018
 */
public class AuthorizationFailedException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public AuthorizationFailedException(String message) 
	{
		super(message);
	}
}