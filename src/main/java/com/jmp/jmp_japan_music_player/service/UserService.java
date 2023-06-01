package com.jmp.jmp_japan_music_player.service;

import com.jmp.jmp_japan_music_player.domain.User;
import com.jmp.jmp_japan_music_player.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    @Autowired
    private final EntityManager entityManager;
    @Autowired
    private final UserRepository userRepository;

    public String User_register_service(@RequestBody User userdata){
        userRepository.save(
                User.builder()
                        .id(userdata.getId())
                        .password(userdata.getPassword())
                        .userName(userdata.getUserName())
                        .Email(userdata.getEmail())
                        .build()
        );
        return "Success";
    }
}