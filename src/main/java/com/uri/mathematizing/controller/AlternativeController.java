package com.uri.mathematizing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uri.mathematizing.repository.AlternativesRepository;
import com.uri.mathematizing.modelo.alternatives;
import com.uri.mathematizing.controller.dto.alternativesDTO;

@RestController
public class AlternativeController {

    @Autowired
    private AlternativesRepository alternativesRepository;

    @GetMapping("/{id}")
    public List<alternativesDTO> getAlternatives(@PathVariable Long id){
        List<alternatives> alternative = alternativesRepository.findByAlternativesQuestionsId(id);
        return alternativesDTO.converter(alternative);
        

    }
    
}
