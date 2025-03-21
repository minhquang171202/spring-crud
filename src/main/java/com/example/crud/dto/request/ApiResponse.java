//Chuan hoa api
package com.example.crud.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL) //annotation xoa bo nhung thu null khong kem vao file json
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    int code = 1000;
    String message;
    T result;

}
