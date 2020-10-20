package com.lovemesomecoding.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(value = Include.NON_NULL)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    private Long   id;

    private String firstName;

    private String lastName;

    private String email;

}
