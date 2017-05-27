package com.eno.project.mysqldemo.controller;

import com.eno.project.mysqldemo.model.User;
import com.eno.project.mysqldemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eno on 2017/05/27.
 */
@RestController
@RequestMapping(value = "/rest/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "save", method = {RequestMethod.POST })
    public Iterable<User> save(@RequestBody final User user){
        userRepository.save(user);
        return userRepository.findAll();
    }

    @RequestMapping("/all")
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }



}
