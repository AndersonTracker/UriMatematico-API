package com.uri.mathematizing.controller.dto;

import com.uri.mathematizing.modelo.topics;

import java.util.List;
import java.util.stream.Collectors;

public class topicsDTO {
    private Long topics_id;
    private String topics_name;
    private String topics_description;
    private Long topics_user_id;
    private String topics_user_name;
    private String topics_discipline_name;

    public topicsDTO() {
    }

    public topicsDTO(topics topic) {
        this.topics_id = topic.getTopics_id();
        this.topics_name = topic.getTopics_name();
        this.topics_description = topic.getTopics_description();
        this.topics_user_id = topic.getTopics_user_id();
        this.topics_user_name = topic.getTopics_user_name();
        this.topics_discipline_name = topic.getTopics_discipline_name();
    }

    public Long getTopics_id() {
        return topics_id;
    }

    public String getTopics_name() {
        return topics_name;
    }

    public String getTopics_description() {
        return topics_description;
    }

    public Long getTopics_user_id() {
        return topics_user_id;
    }

    public String getTopics_user_name() {
        return topics_user_name;
    }

    public String getTopics_discipline_name() {
        return topics_discipline_name;
    }
    
    public static List<topicsDTO> converter(List<topics> topic) {
        return topic.stream().map(topicsDTO::new).collect(Collectors.toList());
    }
}
