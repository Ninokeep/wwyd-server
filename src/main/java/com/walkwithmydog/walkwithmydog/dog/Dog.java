package com.walkwithmydog.walkwithmydog.dog;

import com.walkwithmydog.walkwithmydog.user.User;
import com.walkwithmydog.walkwithmydog.utils.dog.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @SequenceGenerator(name = "dog_sequence", sequenceName = "dog_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dog_sequence")
    private Long id;

    private String name;

    private Gender gender;

    @OneToOne(mappedBy = "dog")
    private User user;

    public Dog(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Dog() {
    };

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}