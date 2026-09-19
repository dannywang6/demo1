package com.exercise.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VocabularyDTO {
    @NotBlank(message = "kana 不能为空2222")
    private String kana;
    private String kanji;
    private String romaji;
    private String meaning;
    private String english;
    private String example;
    private String note;
    private Integer important;
}
