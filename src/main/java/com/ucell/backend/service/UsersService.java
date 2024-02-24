package com.ucell.backend.service;

import com.ucell.backend.config.JwtUtil;
import com.ucell.backend.entity.Users;
import com.ucell.backend.repository.UserRepository;
import com.ucell.backend.response.ApiResponseToken;
import com.ucell.backend.response.UserSearchingResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class UsersService {

    private final AuthenticationManager authenticationManager;


    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    public UsersService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }


    public ApiResponseToken getToken(String userName,String password){
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
            String name = authentication.getName();
            Users user = new Users(name,password);
            String token = jwtUtil.createToken(user);

            if (name.isBlank()){
                return new ApiResponseToken("Invalid username or password",HttpStatus.BAD_REQUEST);
            }

            return new ApiResponseToken(name,token,"",HttpStatus.OK);


        }catch (BadCredentialsException e){
            return new ApiResponseToken("Invalid username or password",HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ApiResponseToken("credential error",HttpStatus.BAD_REQUEST);

        }
    }

    public UserSearchingResponse isRightUserWithPass(String user, String password) throws Exception {

        log.info("searching user"+user);

        Optional<Users> user2 = userRepository.findByName(user);

        if (user2.isPresent()){

            log.error("user " +user+ " found");
            if(!Objects.equals(user2.get().getPassword(), password)){
                log.error("user " +user+ " password is not correct");
                return new UserSearchingResponse("user " +user+ " password is not correct",HttpStatus.BAD_REQUEST,1,false);
            }else if (!Objects.equals(user2.get().getisActive(), "true"))  {
                log.error("user " +user+ " is blocked");
                return new UserSearchingResponse("user " +user+ " is blocked",HttpStatus.LOCKED,1,false);
            }else{
                return new UserSearchingResponse("user"+user+" found and accepted", HttpStatus.ACCEPTED,1,true);
            }
        } else {
            log.info("user "+user+" not found");
            return new UserSearchingResponse("user "+user+" not found", HttpStatus.NOT_FOUND,1,false);
        }

    }


}
