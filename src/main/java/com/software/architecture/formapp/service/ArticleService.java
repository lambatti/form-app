package com.software.architecture.formapp.service;

import com.software.architecture.formapp.model.Article;
import com.software.architecture.formapp.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void addArticle(Article article) {
        articleRepository.save(article);
    }
}