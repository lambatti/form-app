package com.software.architecture.formapp.service;

import com.software.architecture.formapp.model.Article;
import com.software.architecture.formapp.model.ArticleDto;
import com.software.architecture.formapp.model.Author;
import com.software.architecture.formapp.model.AuthorDto;
import com.software.architecture.formapp.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<ArticleDto> getAllArticles() {
        List<Article> tempArticles = articleRepository.findAll();

        List<ArticleDto> articles = new ArrayList<ArticleDto>();

        for (Article article : tempArticles) {

            List<Author> authors = article.getAuthors();
            List<Author> reviewers = article.getReviewers();

            // convert authors and reviewers to AuthorDto
            List<AuthorDto> authorsDto = new ArrayList<AuthorDto>();
            List<AuthorDto> reviewersDto = new ArrayList<AuthorDto>();

            authors.forEach(author -> {
                AuthorDto tempAuthorDto = AuthorDto.builder()
                        .firstName(author.getFirstName())
                        .lastName(author.getLastName())
                        .email(author.getEmail())
                        .build();
                authorsDto.add(tempAuthorDto);
            });

            reviewers.forEach(reviewer -> {
                AuthorDto tempReviewerDto = AuthorDto.builder()
                        .firstName(reviewer.getFirstName())
                        .lastName(reviewer.getLastName())
                        .email(reviewer.getEmail())
                        .build();
                reviewersDto.add(tempReviewerDto);
            });

            ArticleDto tempArticleDto = ArticleDto.builder()
                    .title(article.getTitle())
                    .content(article.getContent())
                    .affiliation(article.getAffiliation())
                    .authors(authorsDto)
                    .reviewers(reviewersDto)
                    .build();

            articles.add(tempArticleDto);
        }
        return articles;
    }

    public Optional<Article> getArticleById(int id) {
        return articleRepository.findById(id);
    }

    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }
}
