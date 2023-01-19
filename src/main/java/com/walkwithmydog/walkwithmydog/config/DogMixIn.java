package com.walkwithmydog.walkwithmydog.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.walkwithmydog.walkwithmydog.user.User;
import com.walkwithmydog.walkwithmydog.utils.dog.Gender;

public abstract class DogMixIn {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private Gender gender;
    @JsonIgnore
    private User user;
}
