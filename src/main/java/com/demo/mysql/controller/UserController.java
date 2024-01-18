package com.demo.mysql.controller;

import com.demo.mysql.entity.User;
import com.demo.mysql.repo.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    UserRepository userRepository;

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(){
        User user = new User();
        user.setFirstName("John");
        user.setEmail("john@test.com");
        user.setLastName("abc");
        user = userRepository.save(user);
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @GetMapping("/fetchUser")
    public ResponseEntity<Object> fetchUser(){
       List<User> list = userRepository.findAll();
        return new ResponseEntity<Object>( list, HttpStatus.OK);
    }

}
