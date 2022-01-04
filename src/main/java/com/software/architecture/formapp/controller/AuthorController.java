package com.software.architecture.formapp.controller;

import com.software.architecture.formapp.model.Author;
import com.software.architecture.formapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/authors")
    ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author a = authorService.addAuthor(author);
        return ResponseEntity.ok(a);
    }
}
