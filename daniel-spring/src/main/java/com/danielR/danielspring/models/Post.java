package com.danielR.danielspring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personId;

    @Column(name = "text")
    private String text;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "scraping_date")
    private Date scrapingDate;
}
