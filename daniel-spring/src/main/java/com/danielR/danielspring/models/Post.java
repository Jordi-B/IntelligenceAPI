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
    @Column(name = "post_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personId;

    @Column(name = "text")
    private String text;

    @Column(name = "num_of_likes")
    private String numOfLikes;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "scraping_date")
    private Date scrapingDate;

    @Column(name = "containing_bad_words")
    private String containingBadWords;
}
