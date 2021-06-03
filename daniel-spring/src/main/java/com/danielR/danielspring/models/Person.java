
package com.danielR.danielspring.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "People")

public class Person {

    @Id

    @Column(name = "id")

    public Long id;


    @Column(name = "name")

    public String name;


    @Column(name = "role")

    public String role;


    public Person() {}


    public Person(long id, String name, String role) {

        this.id = id;

        this.name = name;

        this.role = role;

    }

}