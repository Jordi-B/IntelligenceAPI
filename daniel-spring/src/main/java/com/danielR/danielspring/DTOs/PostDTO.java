package com.danielR.danielspring.DTOs;

import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.models.Word;

import java.util.ArrayList;
import java.util.Date;

public class PostDTO {
    private String id;
    private Person personId;
    private String text;
    private Date publishDate;
    private Date scrapingDate;
    private ArrayList<String> listOfBadWords;
}
