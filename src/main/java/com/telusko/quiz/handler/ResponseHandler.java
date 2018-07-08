package com.telusko.quiz.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.telusko.quiz.controller.QuestionController;
import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.exception.ApiErrorResponse;


/**
 * Global response handler for all APIs
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 *
 */
@ControllerAdvice(basePackageClasses=QuestionController.class)
public class ResponseHandler implements ResponseBodyAdvice<Object> 
{
	/**
	 * 
	 * @param methodParameter
	 * @param request
	 * @return
	 */
	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> request) 
	{
		return true;
	}
	
	/**
	 * 
	 * @param body
	 * @param returnType
	 * @param selectedContentType
	 * @param selectedConverterType
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) 
	{
		if (body instanceof ApiErrorResponse || body instanceof Exception) 
		{
			return body;
		}

		ServletServerHttpRequest httpRequest = (ServletServerHttpRequest) request;
		ServletServerHttpResponse httpResponse = (ServletServerHttpResponse) response;

		ApiResponse apiResponse = new ApiResponse();
		
		int statusCode = httpResponse.getServletResponse().getStatus();
		apiResponse.setCode(String.valueOf(statusCode));
		apiResponse.setStatus(HttpStatus.valueOf(statusCode).name());

		if (httpRequest.getMethod().equals(HttpMethod.GET) && body instanceof SubjectModel ) 
		{
			apiResponse.setMessage("Questions found");
			apiResponse.setSubject((SubjectModel) body);
		}
		
		if (httpRequest.getMethod().equals(HttpMethod.POST) && body instanceof SubjectModel ) 
		{
			apiResponse.setMessage("Question successfully added");
			apiResponse.setSubject((SubjectModel) body);
		}
		
		if (httpRequest.getMethod().equals(HttpMethod.PUT) && body instanceof SubjectModel ) 
		{
			apiResponse.setMessage("Question successfully updated");
			apiResponse.setSubject((SubjectModel) body);
		}
		
		if (body instanceof String ) 
		{
			apiResponse.setMessage("Successfully executed");
			return body;
		}
		
//		return apiResponse;
		return body;
	}

}
