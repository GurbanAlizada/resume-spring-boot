package com.company.controller;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    UserServiceInter userServiceInter;

    @Autowired
    public UserController(UserServiceInter userServiceInter) {
        this.userServiceInter = userServiceInter;
    }


    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userServiceInter.getAllInfo();
        return  ResponseEntity.ok(users);
    }


    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userServiceInter.addUser(user);
      return  ResponseEntity.ok(user);
    }



    @GetMapping( "/findById")
    public User findByUser(@RequestParam int id){
       User u  =  userServiceInter.getById(id);
        return u;
    }



    @GetMapping( "/findByNameAndSurname")
    public List<User> findByNameAndSurname(@RequestParam("name") String name ,
                                           @RequestParam("surname")   String surname){
        List<User> u  =  userServiceInter.getUsersWithParams(name , surname);
        return u;
    }


    @GetMapping( "/findByName")
    public List<User> findByName(@RequestParam("name") String name ){
        List<User> u  =  userServiceInter.findByName(name);
        return u;
    }



    @GetMapping("/getNat")
    public List<User> getNat(@RequestParam("name") String name){
        return userServiceInter.getUserByNationality(name);
    }



    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

}
