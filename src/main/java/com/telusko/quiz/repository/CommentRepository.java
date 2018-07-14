package com.telusko.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.quiz.entity.CommentModel;

public interface CommentRepository extends JpaRepository<CommentModel, Integer> {

}
