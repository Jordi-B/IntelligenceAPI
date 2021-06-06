package com.danielR.danielspring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    @Column(name = "word")
    private String word;

    @Column(name = "counter")
    private int counter;

    @Column(name = "percentage_of_posts")
    private int percentageOfPosts;
}
