package com.genuslee.blog.user.services.interfaces;

import com.genuslee.blog.user.dto.UserCreateDto;
import com.genuslee.blog.user.dto.UserUpdateDto;
import com.genuslee.blog.user.entities.User;

import java.util.List;

public interface UserServiceInterface {

    User createUser(UserCreateDto userCreateDto);

    User updateUser(Long userId, UserUpdateDto userUpdateDto);

    User findUserById(Long userId);

    List<User> findAllUsers();

    String deleteUser(Long userId);

}
