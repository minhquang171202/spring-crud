package com.example.crud.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data // annotation tu dong tao getter,setter
@Builder //tao obj ma k can constructor dai ngoang
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserCreationRequest {

    @Size(min = 5, message = "USERNAME_INVALID")//truyen theo String
    String username;

    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;

}
