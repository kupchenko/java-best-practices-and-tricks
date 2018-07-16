package me.kupchenko.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<Role> roles = new HashSet<>();

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
