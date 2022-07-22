package com.company.service.impl;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    private  UserRepository daoInter;


    public List<User> findByName(String name){
       return  daoInter.findByName(name);
    }

    @Override
    public List<User> getAllInfo() {
        return daoInter.getAllInfo();
    }

    @Override
    public List<User> foo(String name) {
        return daoInter.foo(name);
    }

    @Override
    public List<User> getUserByNationality(String name) {
        return daoInter.getUserByNationality(name);
    }


    @Override
    public List<User> getUsersWithParams(String name, String surname) {
        return daoInter.getUsersWithParams(name , surname);
    }

    public User getByEmailAndPassword(String email , String password) {
        return daoInter.findByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getAllUser() {
        return daoInter.findAll();
    }

    @Override
    public boolean updateUser(User u) {
         daoInter.updateUser(u);
         return true;
    }

    @Override
    public boolean removeUser(int id) {
           daoInter.removeUser(id);
        return true;
    }

    @Override
    public boolean addUser(User u) {
       daoInter.addUser(u);
        return false;
    }

    @Override
    public User getById(int userId) {
        User user = daoInter.findById(userId);

        return  user;
    }


}
