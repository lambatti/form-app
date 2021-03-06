package com.software.architecture.formapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany
    @JoinTable(name = "articles_authors",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> articles;

    @ManyToMany
    @JoinTable(name = "articles_reviewers",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> reviewers;
}
