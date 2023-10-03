package com.uri.mathematizing.modelo;

import jakarta.persistence.*;

@Entity(name = "topics")
@Table(name = "topics")
public class topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topics_id;
    private String topics_name;
    private String topics_description;
    private Long topics_user_id;
    private String topics_user_name;
    private String topics_discipline_name;

    public Long getTopics_id() {
        return topics_id;
    }

    public void setTopics_id(Long topics_id) {
        this.topics_id = topics_id;
    }

    public String getTopics_name() {
        return topics_name;
    }

    public void setTopics_name(String topics_name) {
        this.topics_name = topics_name;
    }

    public String getTopics_description() {
        return topics_description;
    }

    public void setTopics_description(String topics_description) {
        this.topics_description = topics_description;
    }

    public Long getTopics_user_id() {
        return topics_user_id;
    }

    public void setTopics_user_id(Long topics_user_id) {
        this.topics_user_id = topics_user_id;
    }

    public String getTopics_user_name() {
        return topics_user_name;
    }

    public void setTopics_user_name(String topics_user_name) {
        this.topics_user_name = topics_user_name;
    }

    public String getTopics_discipline_name() {
        return topics_discipline_name;
    }

    public void setTopics_discipline_name(String topics_discipline_name) {
        this.topics_discipline_name = topics_discipline_name;
    }
}
