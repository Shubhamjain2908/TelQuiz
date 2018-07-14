package com.telusko.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.quiz.entity.CommentModel;

/**
 * Repository for Question entity
 * 
 * @author SHUBHAM JAIN
 * @since 30-06-2018
 */
public interface CommentRepository extends JpaRepository<CommentModel, Integer> {

}
