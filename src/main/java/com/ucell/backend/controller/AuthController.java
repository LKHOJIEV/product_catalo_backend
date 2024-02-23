package com.ucell.backend.controller;


import com.ucell.backend.config.JwtUtil;
import com.ucell.backend.entity.Users;
import com.ucell.backend.response.ApiResponseToken;
import com.ucell.backend.response.ApiResponseV1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final AuthenticationManager authenticationManager;


    private final JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @ResponseBody
    @RequestMapping(value = "/get-token",method = RequestMethod.POST)
    public ApiResponseToken login(@RequestParam("login") String userName,
                                @RequestParam("secret") String password)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
            String name = authentication.getName();
            Users user = new Users(name,password);
            String token = jwtUtil.createToken(user);

            return new ApiResponseToken(name,token,"",HttpStatus.OK);


        }catch (BadCredentialsException e){
            return new ApiResponseToken("Invalid username or password",HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ApiResponseToken("credential error",HttpStatus.BAD_REQUEST);

        }
    }
}

