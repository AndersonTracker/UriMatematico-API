package com.uri.mathematizing.modelo;
import jakarta.persistence.*;

@Entity(name = "alternatives")
@Table(name = "alternatives")
public class alternatives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alternatives_id;
    private String alternatives_description;
    private Long alternatives_questions_id;
    
    public Long getAlternatives_questions_id() {
        return alternatives_questions_id;
    }
    public void setAlternatives_questions_id(Long alternatives_questions_id) {
        this.alternatives_questions_id = alternatives_questions_id;
    }
    public String getAlternatives_description() {
        return alternatives_description;
    }
    public void setAlternatives_description(String alternatives_description) {
        this.alternatives_description = alternatives_description;
    }
}
