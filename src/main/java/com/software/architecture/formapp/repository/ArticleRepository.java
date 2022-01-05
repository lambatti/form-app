package com.software.architecture.formapp.repository;

import com.software.architecture.formapp.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
