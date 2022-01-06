package com.software.architecture.formapp.controller;

import com.software.architecture.formapp.model.Article;
import com.software.architecture.formapp.model.ArticleDto;
import com.software.architecture.formapp.model.Author;
import com.software.architecture.formapp.model.AuthorDto;
import com.software.architecture.formapp.service.ArticleService;
import com.software.architecture.formapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
@CrossOrigin
public class ArticleController {

    private final ArticleService articleService;

    private final AuthorService authorService;

    @GetMapping("/articles")
    ResponseEntity<List<ArticleDto>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("/article/{id}")
    ResponseEntity<Optional<Article>> getArticleByid(@PathVariable int id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }


    @PostMapping("/article")
    ResponseEntity<Article> addArticle(@RequestBody ArticleDto articleDto) {

        // load all previously added authors (DTO)
        List<AuthorDto> existingAuthors = authorService.getAllAuthorsDto();

        // load all authors from the request
        List<AuthorDto> authors = articleDto.getAuthors();

        // check if the authors already exist
        for (AuthorDto author : authors) {
            log.info("author: " + author.toString());
            if (existingAuthors.contains(author)) {
                existingAuthors.remove(author);
            } else {
                Author tempAuthor = Author.builder()
                        .firstName(author.getFirstName())
                        .lastName(author.getLastName())
                        .email(author.getEmail()).build();
                authorService.addAuthor(tempAuthor);
            }
        }

        // check if there is 3 available authors
        // if not, return error

        int availableReviewers = existingAuthors.size();
        log.info("Available reviewers: {}", availableReviewers);

        if (availableReviewers < 3) {
            log.info("Not enough reviewers");
            return ResponseEntity.badRequest().build();
        }

        // convert authorsDto to authors
        List<Author> authorsList = new ArrayList<>();
        for (AuthorDto authorDto : authors) {
            authorsList.add(authorService.getAuthorByData(authorDto));
        }

        // randomly choose 3 reviewers
        List<Author> reviewersList = new ArrayList<Author>();
        for (int i = 0; i < 3; i++) {
            int randomIndex = (int) (Math.random() * existingAuthors.size());
            AuthorDto tempAuthor = existingAuthors.get(randomIndex);
            Author author = authorService.getAuthorByData(tempAuthor);
            reviewersList.add(author);
            existingAuthors.remove(randomIndex);
        }


        log.info("Authors: {}", authorsList);
        log.info("Reviewers: {}", reviewersList);

        Article tempArticle = Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .affiliation(articleDto.getAffiliation())
                .authors(authorsList)
                .reviewers(reviewersList)
                .build();

        Article a = articleService.addArticle(tempArticle);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/articles")
    ResponseEntity<?> deleteAllArticles() {
        articleService.deleteAllArticles();
        return ResponseEntity.noContent().build();
    }

}
