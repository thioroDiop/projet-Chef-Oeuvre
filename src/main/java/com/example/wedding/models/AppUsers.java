package com.example.wedding.models;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
public class AppUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_generator")
    @SequenceGenerator(name = "app_user_generator")
    private Long id;

    @Column(length = 50)
    private String username;

    @JsonIgnore
    @Column(length = 64)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Roles> roleList;



    // Constructors ...
public AppUsers(){}

    public AppUsers(String username, String password, List<Roles> roleList) {
        this.username = username;
        this.password = password;
        this.roleList = roleList;
    }

    // Getters ...

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Roles> getRoleList() {
        return roleList;
    }
}