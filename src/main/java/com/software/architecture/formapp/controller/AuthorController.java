package com.software.architecture.formapp.controller;

import com.software.architecture.formapp.model.Author;
import com.software.architecture.formapp.model.AuthorDto;
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
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/author/{id}")
    ResponseEntity<Optional<Author>> getAuthorById(@PathVariable int id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping("/author")
    ResponseEntity<Author> addAuthor(@RequestBody AuthorDto authorDto) {
        Author a = Author.builder()
                .firstName(authorDto.getFirstName())
                .lastName(authorDto.getLastName())
                .email(authorDto.getEmail())
                .build();
        authorService.addAuthor(a);
        return ResponseEntity.ok(a);
    }

    @DeleteMapping("/author/{id}")
    ResponseEntity<Author> deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }
}
