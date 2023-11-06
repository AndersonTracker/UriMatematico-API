package com.uri.mathematizing.controller;

import com.uri.mathematizing.controller.dto.questionsDTO;
import com.uri.mathematizing.controller.dto.topicsDTO;
import com.uri.mathematizing.modelo.questions;
import com.uri.mathematizing.modelo.topics;
import com.uri.mathematizing.repository.QuestionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/questions")
@ResponseBody
public class QuestionsController {

    @Autowired
    private QuestionsRepository questionsRepository;

     @GetMapping("/{id}")
    public ResponseEntity<questionsDTO> getQuestionById(@PathVariable Integer id) {
        Optional<questions> optionalQuestion = questionsRepository.findById(id);
        
        if (optionalQuestion.isPresent()) {
            questions question = optionalQuestion.get();
            questionsDTO questionDTO = new questionsDTO(question);
            return ResponseEntity.ok(questionDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("topics/{id}")
    public List<questionsDTO> getTopicsByDisciplineId(@PathVariable Integer id) {
        List<questions> questions = questionsRepository.findByQuestionsTopicsId(id);
        return questionsDTO.converter(questions);
    }

    @PostMapping("/create")
    public ResponseEntity<questions> createTopic(@RequestBody questionsDTO requestDTO) {
        System.out.println(requestDTO);
        questions newQuestion = new questions();
        newQuestion.setQuestions_name(requestDTO.getQuestions_name());
        newQuestion.setQuestions_description(requestDTO.getQuestions_description());
        newQuestion.setQuestions_user_id(requestDTO.getQuestions_user_id());
        newQuestion.setQuestions_user_name(requestDTO.getQuestions_user_name());
        newQuestion.setQuestions_topics_id(requestDTO.getQuestions_topics_id());
        newQuestion.setQuestions_text(requestDTO.getQuestions_text());
        newQuestion.setQuestions_correct_alternative(requestDTO.getQuestions_correct_alternative());
        newQuestion.setQuestions_correct_alternative_description(requestDTO.getQuestions_correct_alternative_description());
        newQuestion.setQuestions_video_url_description(requestDTO.getQuestions_video_url_description());
        newQuestion.setQuestions_image_url(requestDTO.getQuestions_image_url());
        
        questionsRepository.save(newQuestion);

        questions retrievedQuestion = questionsRepository.findByQuestionsNameAndQuestionsDescriptionAndQuestionsUserIdAndQuestionsUserName(newQuestion.getQuestions_name(), newQuestion.getQuestions_description(), newQuestion.getQuestions_user_id(), newQuestion.getQuestions_user_name(), newQuestion.getQuestions_text(), newQuestion.getQuestions_topics_id());

            if (retrievedQuestion != null) {
                return ResponseEntity.ok(retrievedQuestion);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @PutMapping("/{id}")
    public ResponseEntity<questions> updateQuestion(@PathVariable Integer id, @RequestBody questionsDTO requestDTO) {
        Optional<questions> optionalQuestion = questionsRepository.findById(id);
        
        if (optionalQuestion.isPresent()) {
            questions existingQuestion = optionalQuestion.get();
            System.out.println("alterando");
            existingQuestion.setQuestions_id(requestDTO.getQuestions_id());
            existingQuestion.setQuestions_name(requestDTO.getQuestions_name());
            existingQuestion.setQuestions_description(requestDTO.getQuestions_description());
            existingQuestion.setQuestions_user_id(requestDTO.getQuestions_user_id());
            existingQuestion.setQuestions_user_name(requestDTO.getQuestions_user_name());
            existingQuestion.setQuestions_topics_id(requestDTO.getQuestions_topics_id());
            existingQuestion.setQuestions_text(requestDTO.getQuestions_text());
            existingQuestion.setQuestions_correct_alternative(requestDTO.getQuestions_correct_alternative());
            existingQuestion.setQuestions_correct_alternative_description(requestDTO.getQuestions_correct_alternative_description());
            existingQuestion.setQuestions_video_url_description(requestDTO.getQuestions_video_url_description());
            existingQuestion.setQuestions_image_url(requestDTO.getQuestions_image_url());
            // Salve o tópico atualizado
            questionsRepository.save(existingQuestion);
            return ResponseEntity.ok(existingQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        // Verifique se o tópico com o ID fornecido existe no banco de dados
        questionsRepository.deleteById(id);
    }

}