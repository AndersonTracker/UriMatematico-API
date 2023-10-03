package com.uri.mathematizing.controller;

import com.uri.mathematizing.controller.dto.questionsDTO;
import com.uri.mathematizing.modelo.questions;
import com.uri.mathematizing.repository.QuestionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/questions")
@ResponseBody
public class QuestionsController {

    @Autowired
    private QuestionsRepository questionsRepository;

    @GetMapping("/{id}")
    public List<questionsDTO> getTopicsByDisciplineId(@PathVariable Long id) {
        List<questions> questions = questionsRepository.findByQuestionsTopicsId(id);
        return questionsDTO.converter(questions);
    }
}