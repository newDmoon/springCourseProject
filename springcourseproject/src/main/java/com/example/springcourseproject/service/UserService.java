package com.example.springcourseproject.service;

import com.example.springcourseproject.entity.UserEntity;
import com.example.springcourseproject.exceptions.UserAlreadyExistsException;
import com.example.springcourseproject.exceptions.UserNotFoundException;
import com.example.springcourseproject.model.User;
import com.example.springcourseproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistsException {
        if (userRepo.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistsException("Произошла ошибка. Пользователь с таким именем существует");
        }
        return userRepo.save(userEntity);
    }

    public User getOne(Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepo.findById(id);

        if (user.isPresent()) {
            return User.toModel(user.get());
        } else {
            throw new UserNotFoundException("Пользователь с таким айди не был найден");
        }
    }

    public Long deleteOne(Long id) {
        userRepo.deleteById(id);
        
        return id;
    }
}
