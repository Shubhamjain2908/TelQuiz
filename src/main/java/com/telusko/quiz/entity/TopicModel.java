package com.telusko.quiz.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Topic_Id")
	public Integer TopicId;
	
	@Column(name="Topic_Name")
	public String name;
	
	@ElementCollection
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Topic_Questions",
            joinColumns = @JoinColumn(name = "Topic_Id"),
            inverseJoinColumns = @JoinColumn(name = "Question_Id") 
    )
	public Set<QuestionModel> questions;
	
} 
