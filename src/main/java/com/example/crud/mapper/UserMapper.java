package com.example.crud.mapper;

import com.example.crud.dto.request.UserCreationRequest;
import com.example.crud.dto.request.UserUpdateRequest;
import com.example.crud.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface UserMapper {
    User toUser(UserCreationRequest request);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
