package com.software.architecture.formapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class ArticleDto {

    private String title;
    private String content;
    private String affiliation;
    private List<AuthorDto> authors;
    private List<AuthorDto> reviewers;
}
