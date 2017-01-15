package fr.univrouen.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


public enum Difficulty {
    EASY("EASY"),
    MEDIUM("MEDIUM"),
    HARD("HARD");

    @JsonIgnore
    private final String toJson;

    Difficulty(String toJson) {
        this.toJson = toJson;
    }

    String toJson() {
        return toJson;
    }
}
