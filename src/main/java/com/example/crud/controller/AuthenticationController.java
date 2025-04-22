package com.example.crud.controller;

import com.example.crud.dto.request.ApiResponse;
import com.example.crud.dto.request.AuthenticationRequest;
import com.example.crud.dto.response.AuthenticationResponse;
import com.example.crud.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mydatabase/auth")

@RequiredArgsConstructor //autowire
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()

                //.message("Authentication Successful")
                .result(result)
                .build();

    }
}
