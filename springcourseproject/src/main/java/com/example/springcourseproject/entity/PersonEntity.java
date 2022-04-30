package com.example.springcourseproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person_table")
public class PersonEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private PassportEntity passport;


}
