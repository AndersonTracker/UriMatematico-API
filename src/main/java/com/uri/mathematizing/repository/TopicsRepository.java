package com.uri.mathematizing.repository;

import com.uri.mathematizing.modelo.topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsRepository extends JpaRepository<topics, Integer> {

}