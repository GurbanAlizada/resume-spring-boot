package com.company.service.inter;


import com.company.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserServiceInter {

    List<User> getAllUser();

    List<User> getUsersWithParams(String name , String surname );

    User getByEmailAndPassword(String email , String password) ;

    User getById(int userId);

   boolean updateUser(User u);

    boolean removeUser(int id);

    boolean addUser(User u);

    List<User> findByName(String name);

    List<User> getAllInfo();

    public List<User> foo(String name);

    List<User> getUserByNationality(String name);

}
