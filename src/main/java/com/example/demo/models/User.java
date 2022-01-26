package com.example.demo.models;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;

@Entity(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private String occupation;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age=age;
    }
}
