package com.uri.mathematizing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uri.mathematizing.repository.AlternativesRepository;
import com.uri.mathematizing.modelo.alternatives;
import com.uri.mathematizing.controller.dto.alternativesDTO;

@CrossOrigin
@RestController
@RequestMapping("/alternatives")
@ResponseBody
public class AlternativeController {

    @Autowired
    private AlternativesRepository alternativesRepository;

    @GetMapping("/{id}")
    public List<alternativesDTO> getAlternatives(@PathVariable Long id){
        List<alternatives> alternative = alternativesRepository.findByAlternativesQuestionId(id);
        return alternativesDTO.converter(alternative);
    }

    @PostMapping("/create")
    public void createAlternative(@RequestBody List<alternativesDTO> requestDTO) {
        System.out.println("aqui");
        for (alternativesDTO item : requestDTO) {
            alternatives newAlternative = new alternatives();
            newAlternative.setAlternatives_id(item.getAlternatives_id());
            newAlternative.setAlternatives_description(item.getAlternatives_description());;
            newAlternative.setAlternatives_questions_id(item.getAlternatives_questions_id());
            if(item.getAlternatives_description().isEmpty()){
                System.out.println("id " + item.getAlternatives_id());
                alternativesRepository.deleteById(item.getAlternatives_id());
            }else if(item.getAlternatives_edition() != null){
                alternativesRepository.save(newAlternative);
            }else{
                
            }
        }
    }
}
