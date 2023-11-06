package com.uri.mathematizing.modelo;

import jakarta.persistence.*;

@Entity(name = "questions")
@Table(name = "questions")
public class questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questions_id;
    private String questions_name;
    private String questions_description;
    private Long questions_user_id;
    private String questions_user_name;
    private Long questions_topics_id;
    private String questions_text;
    private String questions_correct_alternative;
    private String questions_correct_alternative_description;
    private String questions_video_url_description;
    private String questions_image_url;

    public String getQuestions_image_url() {
        return questions_image_url;
    }

    public void setQuestions_image_url(String questions_image_url) {
        this.questions_image_url = questions_image_url;
    }

    public Long getQuestions_id() {
        return questions_id;
    }

    public void setQuestions_id(Long questions_id) {
        this.questions_id = questions_id;
    }

    public String getQuestions_name() {
        return questions_name;
    }

    public void setQuestions_name(String questions_name) {
        this.questions_name = questions_name;
    }

    public String getQuestions_description() {
        return questions_description;
    }

    public void setQuestions_description(String questions_description) {
        this.questions_description = questions_description;
    }

    public String getQuestions_text() {
        return questions_text;
    }

    public void setQuestions_text(String questions_text) {
        this.questions_text = questions_text;
    }

    public String getQuestions_correct_alternative() {
        return questions_correct_alternative;
    }

    public void setQuestions_correct_alternative(String questions_correct_alternative) {
        this.questions_correct_alternative = questions_correct_alternative;
    }

    public String getQuestions_correct_alternative_description() {
        return questions_correct_alternative_description;
    }

    public void setQuestions_correct_alternative_description(String questions_correct_alternative_description) {
        this.questions_correct_alternative_description = questions_correct_alternative_description;
    }

    public Long getQuestions_user_id() {
        return questions_user_id;
    }

    public void setQuestions_user_id(Long questions_user_id) {
        this.questions_user_id = questions_user_id;
    }

    public String getQuestions_user_name() {
        return questions_user_name;
    }

    public void setQuestions_user_name(String questions_user_name) {
        this.questions_user_name = questions_user_name;
    }

    public Long getQuestions_topics_id() {
        return questions_topics_id;
    }

    public void setQuestions_topics_id(Long questions_topics_id) {
        this.questions_topics_id = questions_topics_id;
    }

    public String getQuestions_video_url_description() {
        return questions_video_url_description;
    }

    public void setQuestions_video_url_description(String questions_video_url_description) {
        this.questions_video_url_description = questions_video_url_description;
    }

}
