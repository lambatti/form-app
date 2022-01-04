package com.software.architecture.formapp.repository;

import com.software.architecture.formapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
