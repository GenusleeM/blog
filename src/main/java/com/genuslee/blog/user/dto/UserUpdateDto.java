package com.genuslee.blog.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserUpdateDto {
    private String email;
    private String firstName;
    private String phone;
    private String lastName;
}
