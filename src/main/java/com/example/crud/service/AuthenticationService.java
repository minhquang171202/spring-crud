package com.example.crud.service;

import com.example.crud.dto.request.AuthenticationRequest;
import com.example.crud.exception.AppException;
import com.example.crud.exception.ErrorCode;
import com.example.crud.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AuthenticationService {

    UserRepository userRepository;

    public boolean authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));//neu k co thi bao loi

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(),
                user.getPassword());

    }

//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        var user = userRepository.findByUsername(request.getUsername())
//                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));//neu k co thi bao loi
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//        boolean authenticated = passwordEncoder.matches(request.getPassword(),
//                user.getPassword());
//        if (!authenticated)
//            throw new AppException(ErrorCode.USER_NOT_EXISTED);
//
//    }

//    private String generateToken(String username) {
//
//        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.PS512);
//
//        JWTClaimsSet jwtClaimsSet = new
//
//        JWSObject()
//    }
}
