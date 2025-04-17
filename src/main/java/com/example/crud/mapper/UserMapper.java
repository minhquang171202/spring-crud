package com.example.crud.mapper;

import com.example.crud.dto.request.UserCreationRequest;
import com.example.crud.dto.request.UserUpdateRequest;
import com.example.crud.dto.response.UserResponse;
import com.example.crud.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
//kich hoat mapstruct va nhu 1 spr bean de autowire

public interface UserMapper {
    User toUser(UserCreationRequest request);

    //@Mapping(source = "lastName", target = "firstName")
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
    //map data userUpdateRequest -> user
}
