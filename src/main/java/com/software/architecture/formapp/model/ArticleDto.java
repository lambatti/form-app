package com.software.architecture.formapp.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private String title;
    private String content;
    private String affiliation;
    private List<AuthorDto> authors;
    private List<AuthorDto> reviewers;
}
