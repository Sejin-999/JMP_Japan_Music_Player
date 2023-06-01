package com.jmp.jmp_japan_music_player.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jmp.jmp_japan_music_player.domain.ApiResponse;
import com.jmp.jmp_japan_music_player.domain.User;
import com.jmp.jmp_japan_music_player.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@Slf4j
public class UserController {
    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public ResponseEntity registerUser(@RequestBody User user) throws JsonProcessingException {
        //do
        log.info("registerUser-> userId : {} , userName : {}" , user.getId() , user.getUserName());
        //service
        String resTxt = userService.User_register_service(user);
        //checker
        String json = objectMapper.writeValueAsString(resTxt);

        if (resTxt == "Success"){
            log.info("registerUser : Success-> userId : {} , userName : {}" , user.getId() , user.getUserName());
            return (ResponseEntity) ResponseEntity.created(URI.create(json));
        }else{
            log.info("registerUser : fail-> userId : {} , userName : {}" , user.getId() , user.getUserName());
            return  ResponseEntity.ok(json);
        }

    }

}
