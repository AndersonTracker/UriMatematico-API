package com.uri.mathematizing.repository;

import com.uri.mathematizing.modelo.questions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<questions, Long> {
    @Query("SELECT q FROM questions q WHERE q.questions_topics_id = :topicsId")
    List<questions> findByQuestionsTopicsId(Long topicsId);
}