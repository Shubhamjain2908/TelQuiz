package com.telusko.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * Model class for questions
 * @author SHUBHAM
 * @since 21-06-2018
 */
@Entity
@Table(name = "Questions")
@Data
@JsonInclude(Include.NON_EMPTY)
public class QuestionModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Question_Id")
	public Integer QId;
	
	@Column(name = "Questions")
	public String question;
	
	@Column(name = "Option_A")
	public String optionA;
	
	@Column(name = "Option_B")
	public String optionB;
	
	@Column(name = "Option_C")
	public String optionC;

	@Column(name = "Option_D")
	public String optionD;
	
	@Column(name = "Answer")
	public String answer;
	
	@Column(name = "Question_Level")
	public String questionLevel;
	
}
