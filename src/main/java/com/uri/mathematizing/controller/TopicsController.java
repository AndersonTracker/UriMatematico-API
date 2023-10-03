package com.uri.mathematizing.controller;

import com.uri.mathematizing.controller.dto.topicsDTO;
import com.uri.mathematizing.modelo.topics;
import com.uri.mathematizing.repository.TopicsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
}