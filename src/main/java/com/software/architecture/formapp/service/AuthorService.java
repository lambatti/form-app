package com.software.architecture.formapp.service;

import com.software.architecture.formapp.model.Author;
import com.software.architecture.formapp.model.AuthorDto;
import com.software.architecture.formapp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<AuthorDto> getAllAuthorsDto() {

        List<Author> tempAuthors = getAllAuthors();
        List<AuthorDto> authorsDto = new ArrayList<>();

        for (Author author : tempAuthors) {
            AuthorDto tempAuthor = AuthorDto.builder()
                    .firstName(author.getFirstName())
                    .lastName(author.getLastName())
                    .email(author.getEmail())
                    .build();
            authorsDto.add(tempAuthor);
        }

        return authorsDto;
    }

    public Optional<Author> getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    public Author getAuthorByData(AuthorDto author) {
        return authorRepository.findByData(author.getFirstName(), author.getLastName(), author.getEmail());
    }

}
