package com.exercise.vo;

import lombok.Data;

@Data
public class VocabularyVO {

    private Long id;
    private String kana;
    private String kanji;
    private String romaji;
    private String meaning;
    private String english;
}