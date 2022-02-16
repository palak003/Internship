package com.example.internship.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String emailId;
    private String mobileNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Groups> groupsList;
}
