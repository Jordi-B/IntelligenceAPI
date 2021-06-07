package com.danielR.danielspring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "words")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    @Id
    @GeneratedValue
    @Column(name = "word_id")
    private String wordId;

    @Column(name = "word")
    private String word;

    @Column(name = "counter")
    private int counter;

    @Column(name = "percentage_of_posts")
    private int percentageOfPosts;


}
