package com.choirula.restfullapi.controller;

import com.choirula.restfullapi.model.User;
import com.choirula.restfullapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/insert")
    public String userInsert(@RequestBody User user){
        return userService.userInsert(user);
    }

    @PostMapping("/find-all")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/delete")
    public String userDelete(@RequestBody User user){
        return userService.userDelete(user);
    }

    @PostMapping("/update")
    public ResponseEntity<User> userUpdate(@RequestBody User user){
        return userService.userUpdate(user);
    }
}
