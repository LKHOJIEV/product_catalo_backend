package com.ucell.backend.service;

import com.ucell.backend.entity.Users;
import com.ucell.backend.repository.UserRepository;
import com.ucell.backend.response.UserSearchingResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class UsersService {

    @Autowired
    private UserRepository userRepository;

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
