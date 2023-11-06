package com.uri.mathematizing.repository;

import com.uri.mathematizing.modelo.questions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<questions, Integer> {
    @Query("SELECT q FROM questions q WHERE q.questions_topics_id = :topicsId")
    List<questions> findByQuestionsTopicsId(Integer topicsId);

    @Query("SELECT q FROM questions q WHERE q.questions_name = :questionsName and q.questions_description = :questionsDescription and q.questions_user_id = :questionsUserId and q.questions_user_name = :questionsUserName and q.questions_text = :questionsText and q.questions_topics_id = :questionTopicId")
    questions findByQuestionsNameAndQuestionsDescriptionAndQuestionsUserIdAndQuestionsUserName(String questionsName, String questionsDescription, Long questionsUserId, String questionsUserName, String questionsText, Long questionTopicId);
}