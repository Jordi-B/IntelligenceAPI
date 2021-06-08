package com.danielR.danielspring.DTOs;

import com.danielR.danielspring.models.Suspect;
import com.danielR.danielspring.models.Word;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuspectDTO {
    private Suspect suspect;
    private ArrayList<Word> listOfBadWords;
}
