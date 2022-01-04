package com.software.architecture.formapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ArticleDto {

    private String title;
    private String content;
    private String affiliation;
    private List<Author> authors;

}
