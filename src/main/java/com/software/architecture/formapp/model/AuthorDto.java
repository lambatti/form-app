package com.software.architecture.formapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class AuthorDto {

    private String firstName;
    private String lastName;
    private String email;

}
