package com.uri.mathematizing.controller.dto;

import com.uri.mathematizing.modelo.questions;

import java.util.List;
import java.util.stream.Collectors;

public class questionsDTO {

    private Long questions_id;
    private String questions_name;
    private String questions_description;
    private Long questions_user_id;
    private String questions_user_name;
    private String questions_discipline_name;
    private Long questions_topics_id;
    private String questions_text;
    private String questions_correct_alternative;
    private String questions_correct_alternative_description;
    private String questions_video_url_description;
    private String questions_image_url;


    public questionsDTO(questions question) {
        this.questions_id = question.getQuestions_id();
        this.questions_name = question.getQuestions_name();
        this.questions_description = question.getQuestions_description();
        this.questions_user_id = question.getQuestions_user_id();
        this.questions_user_name = question.getQuestions_user_name();
        this.questions_discipline_name = question.getQuestions_discipline_name();
        this.questions_topics_id = question.getQuestions_topics_id();
        this.questions_text = question.getQuestions_text();
        this.questions_correct_alternative = question.getQuestions_correct_alternative();
        this.questions_correct_alternative_description = question.getQuestions_correct_alternative_description();
        this.questions_image_url = question.getQuestions_image_url();
        this.questions_video_url_description = question.getQuestions_video_url_description();
    }

    public String getQuestions_image_url() {
        return questions_image_url;
    }

    public Long getQuestions_id() {
        return questions_id;
    }

    public String getQuestions_name() {
        return questions_name;
    }

    public String getQuestions_description() {
        return questions_description;
    }

    public Long getQuestions_topics_id() {
        return questions_topics_id;
    }

    public String getQuestions_text() {
        return questions_text;
    }

    public String getQuestions_correct_alternative() {
        return questions_correct_alternative;
    }

    public String getQuestions_correct_alternative_description() {
        return questions_correct_alternative_description;
    }

    public static List<questionsDTO> converter(List<questions> question) {
        return question.stream().map(questionsDTO::new).collect(Collectors.toList());
    }

    public Long getQuestions_user_id() {
        return questions_user_id;
    }

    public String getQuestions_user_name() {
        return questions_user_name;
    }

    public String getQuestions_discipline_name() {
        return questions_discipline_name;
    }

    public String getQuestions_video_url_description() {
        return questions_video_url_description;
    }
}
