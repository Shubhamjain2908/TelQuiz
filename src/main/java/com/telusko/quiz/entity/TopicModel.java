package com.telusko.quiz.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * Model class for Topics
 * @author SHUBHAM
 * @since 21-06-2018
 */
@Entity
@Table(name = "Topics")
@Data
@JsonInclude(Include.NON_EMPTY)
public class TopicModel {
	
	@Id
	@Column(name="Topic_Name")
	public String name;
	
	@ElementCollection
  //  @CollectionTable(name = "questions")
//    @Column(name = "question")
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Topic_Questions",
            joinColumns = @JoinColumn(name = "Topic_Name"),
            inverseJoinColumns = @JoinColumn(name = "Question_Id") 
    )
	public Set<QuestionModel> questions;
	
} 
