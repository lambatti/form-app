package com.software.architecture.formapp.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private String firstName;
    private String lastName;
    private String email;

}
