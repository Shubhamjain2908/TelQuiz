package com.telusko.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.quiz.entity.SubjectModel;

/**
 * Repository for Subject entity
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 */
public interface SubjectRepository extends JpaRepository<SubjectModel, String> {
	public SubjectModel findByName(String name);
}
