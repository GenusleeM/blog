package com.genuslee.blog.user.services.implementation;

import com.genuslee.blog.exception.ResourceNotFoundException;
import com.genuslee.blog.user.dto.UserCreateDto;
import com.genuslee.blog.user.dto.UserUpdateDto;
import com.genuslee.blog.user.entities.User;
import com.genuslee.blog.user.repositories.UserRepository;
import com.genuslee.blog.user.services.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepository userRepository;
    @Override
    public User createUser(UserCreateDto userCreateDto) {

        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setPhone(userCreateDto.getPhone());
        user.setPassword(userCreateDto.getPassword());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());

        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with that Id [%s] not found".formatted(userId)));
    }
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User updateUser(Long userId, UserUpdateDto userUpdateDto) {

        boolean updates = false;
        User foundUser = findUserById(userId);

        if (!(foundUser.getFirstName().equals(userUpdateDto.getFirstName()))){
            foundUser.setFirstName(userUpdateDto.getFirstName());
            updates = true;
        }
        if (!(foundUser.getLastName().equals(userUpdateDto.getLastName()))){
            foundUser.setLastName(userUpdateDto.getLastName());
            updates = true;
        }

        if (!(foundUser.getPhone().equals(userUpdateDto.getPhone()))){
            foundUser.setPhone(userUpdateDto.getPhone());
            updates = true;
        }
        if (!(foundUser.getEmail().equals(userUpdateDto.getEmail()))){
            foundUser.setEmail(userUpdateDto.getEmail());
            updates = true;
        }

        if (updates){
            userRepository.save(foundUser);
        }

        return foundUser;
    }

    @Override
    public String deleteUser(Long userId) {

        User user = findUserById(userId);
        if (user != null){
            userRepository.deleteById(userId);
            return "User with ID [%s] deleted successfully".formatted(userId);
        }else {
            throw new ResourceNotFoundException("User with id [%s] not found".formatted(userId));
        }
    }
}
