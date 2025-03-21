package com.example.crud.controller;

import com.example.crud.dto.request.ApiResponse;
import com.example.crud.dto.request.UserCreationRequest;
import com.example.crud.dto.request.UserUpdateRequest;
import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mydatabase/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request)); //chuan hoa api
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@RequestBody UserUpdateRequest request, @PathVariable String userId) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping({"/{userId}"})
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "Delete completed";
    }
}
