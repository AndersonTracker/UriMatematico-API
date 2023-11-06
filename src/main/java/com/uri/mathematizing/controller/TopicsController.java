package com.uri.mathematizing.controller;

import com.uri.mathematizing.controller.dto.topicsDTO;
import com.uri.mathematizing.modelo.topics;
import com.uri.mathematizing.repository.TopicsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
@RequestMapping("/topics")
@ResponseBody
public class TopicsController {
    
    @Autowired
    private TopicsRepository topicsRepository;

    @GetMapping()
    public List<topicsDTO> getAllTopics() {
        System.out.println("opa");
        List<topics> topics = topicsRepository.findAll();
        return topicsDTO.converter(topics);
    }

    @PostMapping("/create")
    public void createTopic(@RequestBody topicsDTO requestDTO) {
        System.out.println(requestDTO);
        topics newTopic = new topics();
        newTopic.setTopics_name(requestDTO.getTopics_name());
        newTopic.setTopics_description(requestDTO.getTopics_description());
        newTopic.setTopics_user_id(requestDTO.getTopics_user_id());
        newTopic.setTopics_user_name(requestDTO.getTopics_user_name());
        newTopic.setTopics_discipline_name(requestDTO.getTopics_discipline_name());

        topicsRepository.save(newTopic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<topicsDTO> getTopicById(@PathVariable Integer id) {
        Optional<topics> optionalTopic = topicsRepository.findById(id);
        
        if (optionalTopic.isPresent()) {
            topics topic = optionalTopic.get();
            topicsDTO topicDTO = new topicsDTO(topic);
            return ResponseEntity.ok(topicDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTopic(@PathVariable Integer id, @RequestBody topicsDTO requestDTO) {
        Optional<topics> optionalTopic = topicsRepository.findById(id);
        
        if (optionalTopic.isPresent()) {
            topics existingTopic = optionalTopic.get();
            
            // Atualize os campos do tópico existente com os valores do requestDTO
            existingTopic.setTopics_name(requestDTO.getTopics_name());
            existingTopic.setTopics_description(requestDTO.getTopics_description());
            existingTopic.setTopics_user_id(requestDTO.getTopics_user_id());
            existingTopic.setTopics_user_name(requestDTO.getTopics_user_name());
            existingTopic.setTopics_discipline_name(requestDTO.getTopics_discipline_name());
            
            // Salve o tópico atualizado
            topicsRepository.save(existingTopic);
            
            return ResponseEntity.ok("Tópico atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Integer id) {
        System.out.println("del 2");
        // Verifique se o tópico com o ID fornecido existe no banco de dados
        topicsRepository.deleteById(id);
    }
}