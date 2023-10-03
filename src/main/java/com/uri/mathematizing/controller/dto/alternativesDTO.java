package com.uri.mathematizing.controller.dto;

import com.uri.mathematizing.modelo.alternatives;

import java.util.List;
import java.util.stream.Collectors;

public class alternativesDTO {
    
    private Long alternatives_id;
    private String alternatives_description;
    private Long alternatives_questions_id;

    public alternativesDTO(alternatives alternative) {
        this.alternatives_id = alternative.getAlternatives_questions_id();
        this.alternatives_description = alternative.getAlternatives_description();
        this.alternatives_questions_id = alternative.getAlternatives_questions_id();
    }

    public Long getAlternatives_id() {
        return alternatives_id;
    }
    public String getAlternatives_description() {
        return alternatives_description;
    }
    public Long getAlternatives_questions_id() {
        return alternatives_questions_id;
    }

    public static List<alternativesDTO> converter(List<alternatives> alternative) {
        return alternative.stream().map(alternativesDTO::new).collect(Collectors.toList());
    }
}
