package com.danielR.danielspring.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordDTO {
    private String word;
    private int counter;
    private int percentageOfPosts;
}
