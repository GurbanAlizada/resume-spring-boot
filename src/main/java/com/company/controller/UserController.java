package com.company.controller;

import com.company.dao.impl.UserRepository;
import com.company.dto.UserDto;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    @GetMapping("/getAllUserDto")
    public ResponseEntity<List<UserDto>> getAllUserDto(){
        List<UserDto> users = userServiceInter.getAllInfoDto();
        return  ResponseEntity.ok(users);
    }



    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> pagination(@RequestParam("currentPage") int currentPage , @RequestParam("pageSize") int pageSize ){
        return ResponseEntity.ok(userServiceInter.pagination(currentPage , pageSize));
    }



    //http://localhost:8080/users/pagination/v2?page=0&size=2
    @GetMapping("/pagination/v2")
    public ResponseEntity<Slice<User>> pagination2(Pageable pageable){
        return ResponseEntity.ok(userServiceInter.pagination2(pageable));
    }




    @GetMapping( "/findById")
    public ResponseEntity<User> findByUser(@RequestParam int id){
       User u  =  userServiceInter.getById(id);
        return ResponseEntity.ok(u);
    }
    @GetMapping( "/findByIdDto")
    public UserDto findByUserDto(@RequestParam int id){
        return userServiceInter.getByIdDto(id);
    }
    @GetMapping( "/findByIdWithPathVariable/{id}")
    public User findByUser2(@PathVariable("id") int id){
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






    @PutMapping("/update")
    public User update(@RequestParam("id") Integer id , @RequestBody User user){
        userServiceInter.updateUser(id, user);
        return user;
    }
    @PutMapping("/updateDto")
    public ResponseEntity<UserDto> updateDto(@RequestParam("id") Integer id , @RequestBody User user){
        return userServiceInter.updateUserDto(id,user) ;
    }





    @PostMapping("/save")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userServiceInter.addUser(user);
        return  ResponseEntity.ok(user);
    }
    @PostMapping("/saveDto")
    public ResponseEntity<UserDto> addUserDto(@RequestBody User user) {
      return ResponseEntity.ok(userServiceInter.addUserDto(user));
    }








    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
