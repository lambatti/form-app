package com.software.architecture.formapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    private String firstName;
    private String lastName;
    private String email;
    private String affiliation;

    @ManyToMany
    @JoinTable(
            name="articles_authors",
            joinColumns = @JoinColumn(name="author_id"),
            inverseJoinColumns = @JoinColumn(name="article_id")

    )
    private List<Article> articles;
}
