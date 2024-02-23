package com.ucell.backend.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseToken {
    
    private String name;
    private String token;
    private String message;
    private HttpStatus status;

    public ApiResponseToken(String invalidUsernameOrPassword, HttpStatus httpStatus) {
    }
}
