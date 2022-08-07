package com.company.controller;


import com.company.dto.request.UserRequest;
import com.company.dto.result.ResponseDto;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/api")
public class UserController {

    private final UserServiceInter userServiceInter;

    public UserController(UserServiceInter userServiceInter) {
        this.userServiceInter = userServiceInter;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findByUser(@PathVariable("id") int id) {
        User u = userServiceInter.getById(id);
        return ResponseEntity.ok(u);
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userServiceInter.getAllUser());
    }


    @GetMapping("/users/{name}")
    public ResponseEntity<List<User>> findByName(@PathVariable("name") String name) {
        List<User> u = userServiceInter.findByName(name);
        return ResponseEntity.ok(u);
    }


    @GetMapping("/findByNameAndSurname")
    public ResponseEntity<List<User>> findByNameAndSurname(
                                           @RequestParam("name") String name,
                                           @RequestParam("surname") String surname) {
        List<User> u = userServiceInter.getUsersWithParams(name, surname);
        return ResponseEntity.ok(u);
    }


    @GetMapping("/getByEmailAndPassword")
    public ResponseEntity<User> getByEmailAndPassword(
            @RequestParam("email") String email ,
            @RequestParam("password") String password) {
        return ResponseEntity.ok(userServiceInter.getByEmailAndPassword(email, password));
    }



    @GetMapping("/getUserByNationality")
    public ResponseEntity<List<User>> getUserByNationality(@RequestParam("name") String name) {
        return ResponseEntity.ok(userServiceInter.getUserByNationality(name));
    }



    @PostMapping("/users")
    public ResponseEntity<ResponseDto> addUser( @Valid @RequestBody UserRequest userRequest){
        return ResponseEntity.ok(ResponseDto.of(userServiceInter.addUser(userRequest) , "Basari ile eklendi"));
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable("id") Integer id,
            @RequestBody UserRequest userRequest) {

        return   ResponseEntity.ok(ResponseDto.of(userServiceInter.updateUser(id, userRequest) ,"Barari ile guncellendu"));
    }



    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") int id){
        return ResponseEntity.ok(ResponseDto.of(userServiceInter.removeUser(id), "Kullanici basari ile silindi"));
    }



}
