package com.company.dao.impl;


import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepositoryCustom {

    List<User> getUsersWithParams(String name , String surname );

   boolean updateUser(User u);

    boolean removeUser(int id);

    boolean addUser(User u);


    public List<User> foo(String name);

}
