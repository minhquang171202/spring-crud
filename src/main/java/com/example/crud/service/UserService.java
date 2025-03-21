package com.example.crud.service;

import com.example.crud.dto.request.UserCreationRequest;
import com.example.crud.dto.request.UserUpdateRequest;
import com.example.crud.entity.User;
import com.example.crud.exception.AppException;
import com.example.crud.exception.ErrorCode;
import com.example.crud.mapper.UserMapper;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public User createUser(UserCreationRequest request) {
        //User user = new User();

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED); // nem ra ngoai le ton tai user
        }
        User user = userMapper.toUser(request);

//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setDob(request.getDob());

        userRepository.save(user);
        return user;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);

        userMapper.updateUser(user, request);
//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
