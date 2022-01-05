package com.software.architecture.formapp.repository;

import com.software.architecture.formapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM authors WHERE first_name = ?1 AND last_name = ?2 AND email = ?3")
    Author findByData(String firstName, String lastName, String email);

}
