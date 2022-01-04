package com.software.architecture.formapp.controller;

import com.software.architecture.formapp.model.Article;
import com.software.architecture.formapp.model.ArticleDto;
import com.software.architecture.formapp.model.Author;
import com.software.architecture.formapp.service.ArticleService;
import com.software.architecture.formapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    private final AuthorService authorService;

    @GetMapping("/articles")
    ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("/article/{id}")
    ResponseEntity<Optional<Article>> getArticleByid(@PathVariable int id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }


    @PostMapping("/article")
    ResponseEntity<Article> addArticle(@RequestBody ArticleDto articleDto) {

        for (Author author : articleDto.getAuthors()) {
            authorService.addAuthor(author);
        }

        Article tempAuthor = Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .affiliation(articleDto.getAffiliation())
                .authors(articleDto.getAuthors())
                .build();

        Article a = articleService.addArticle(tempAuthor);
        return ResponseEntity.ok(a);
    }

}
