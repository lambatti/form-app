package com.software.architecture.formapp.controller;

import com.software.architecture.formapp.model.Article;
import com.software.architecture.formapp.model.ArticleDto;
import com.software.architecture.formapp.model.Author;
import com.software.architecture.formapp.service.ArticleService;
import com.software.architecture.formapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    private final AuthorService authorService;

    @PostMapping("/article")
    ResponseEntity<Article> addArticle(@RequestBody ArticleDto articleDto) {

        for (Author author : articleDto.getAuthors()) {
            authorService.addAuthor(author);
        }

        Article tempAuthor = Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .authors(articleDto.getAuthors())
                .build();

        Article a = articleService.addArticle(tempAuthor);
        return ResponseEntity.ok(a);
    }

}
