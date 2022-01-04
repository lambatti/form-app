package com.software.architecture.formapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "articles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int articleId;

    private String title;
    private String content;
    private String affiliation;

    @ManyToMany
    @JoinTable(name = "articles_authors",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    //@ManyToMany
    //private List<Author> reviewers;

}
