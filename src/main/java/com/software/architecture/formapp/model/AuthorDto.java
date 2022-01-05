package com.software.architecture.formapp.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AuthorDto {

    private String firstName;
    private String lastName;
    private String email;

}
