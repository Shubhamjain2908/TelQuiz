package com.telusko.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.quiz.entity.TopicModel;

/**
 * Repository for Topic entity
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 */
public interface TopicRepository extends JpaRepository<TopicModel, String> {
	
}
