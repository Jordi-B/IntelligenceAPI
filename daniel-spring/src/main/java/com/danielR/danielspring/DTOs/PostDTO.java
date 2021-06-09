package com.danielR.danielspring.DTOs;

import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.models.Word;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int id;
    private Person personId;
    private String text;
    private Date publishDate;
    private Date scrapingDate;
    private ArrayList<Word> listOfBadWords;
}
