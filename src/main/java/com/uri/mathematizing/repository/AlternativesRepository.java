package com.uri.mathematizing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uri.mathematizing.modelo.alternatives;

@Repository
public interface AlternativesRepository extends JpaRepository<alternatives, Long>  {

     @Query("SELECT a FROM alternatives a WHERE a.alternatives_questions_id = :alternativesId")
    List<alternatives> findByAlternativesQuestionId(Long alternativesId);

    //
}