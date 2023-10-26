package com.genuslee.blog.user.controller;

import com.genuslee.blog.user.dto.UserCreateDto;
import com.genuslee.blog.user.entities.User;
import com.genuslee.blog.user.services.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody  UserCreateDto userCreateDto){
        try {
            User user = userService.createUser(userCreateDto);
            return  ResponseEntity.accepted().body(user);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
