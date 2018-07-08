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
 * Model class for comments posted by Users
 * @author SHUBHAM
 * @since 30-06-2018
 */
@Entity
@Table(name = "Comments")
@Data
@JsonInclude(Include.NON_EMPTY)
public class CommentModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Comment_Id")
	public Integer CId;
	
	@Column(name = "message")
	public String message;
	
	@Column(name = "User_Name")
	public String userName;
	
	@Column(name = "Time")
	public String time;
	
}
