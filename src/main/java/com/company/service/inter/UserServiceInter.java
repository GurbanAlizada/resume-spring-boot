package com.company.service.inter;


import com.company.dto.UserDto;
import com.company.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserServiceInter {

    List<User> getAllUser();

    List<User> getUsersWithParams(String name , String surname );

    User getByEmailAndPassword(String email , String password) ;

    User getById(int userId);

     UserDto getByIdDto(int userId);

   boolean updateUser( Integer id ,User u);
    UserDto updateUserDto( Integer id ,User u);

    boolean removeUser(int id);

    boolean addUser(User u);
    UserDto addUserDto(User u);

    List<User> findByName(String name);

    List<User> getAllInfo();


    List<UserDto> getAllInfoDto();



    public List<User> foo(String name);

    List<User> getUserByNationality(String name);


    User save(User user);

}
