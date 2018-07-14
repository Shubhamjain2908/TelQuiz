package com.telusko.quiz.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * Model class for Subjects
 * @author SHUBHAM
 * @since 21-06-2018
 */
@Entity
@Table(name = "Subjects")
@Data
@JsonInclude(Include.NON_EMPTY)
public class SubjectModel {

	@Id
	@Column(name = "Subject_Name")
	public String name;
	
	@ElementCollection
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Subject_Topic",
            joinColumns = @JoinColumn(name = "Subject_Name"),
    		inverseJoinColumns = @JoinColumn(name = "Topic_Id")
    )
	public Set<TopicModel> topics;
	
}
