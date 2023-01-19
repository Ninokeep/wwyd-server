package com.walkwithmydog.walkwithmydog.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.walkwithmydog.walkwithmydog.dog.Dog;

public abstract class UserMixIn {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private Dog dog;
}
