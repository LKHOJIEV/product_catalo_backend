package com.ucell.backend.controller;


import com.ucell.backend.config.JwtUtil;
import com.ucell.backend.entity.Users;
import com.ucell.backend.response.ApiResponseToken;
import com.ucell.backend.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UsersService usersService;

    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(value = "/get-token")
    public ApiResponseToken login(@RequestParam("login") String userName,
                                @RequestParam("password") String password)  {

        return usersService.getToken(userName,password);

    }
}

