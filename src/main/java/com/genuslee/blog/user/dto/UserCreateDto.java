package com.genuslee.blog.user.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserCreateDto {
    private String email;
    private String firstName;
    private String phone;
    private String lastName;
    private String password;
}
