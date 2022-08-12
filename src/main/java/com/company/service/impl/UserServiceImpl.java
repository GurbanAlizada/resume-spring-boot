package com.company.service.impl;

import com.company.dao.impl.UserRepository;
import com.company.dao.inter.CountryRepository;
import com.company.dto.request.UserRequest;
import com.company.entity.User;
import com.company.exception.UserNotFoundException;
import com.company.service.inter.UserServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserServiceInter {

    private final UserRepository userRepository;
    private final CountryRepository countryRepository;


    public UserServiceImpl(UserRepository userRepository,
                           CountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public User getById(Integer userId) {
        User user =  userRepository.findById(userId)
                .orElseThrow(
                        ()->new UserNotFoundException("User bulunamadi id: "+userId)
                );
        return  user;
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }



    @Override
    public List<User> findByName(String name){
       return  userRepository.findByName(name);
    }


    @Override
    public List<User> getUsersWithParams(String name, String surname) {
        return userRepository.getUsersWithParams(name , surname);
    }


    @Override
    public User getByEmailAndPassword(String email , String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }


    @Override
    public List<User> getUserByNationality(String name) {
        return userRepository.getByBirthPlaceId_Name(name);
    }


    @Override
    @Transactional
    public boolean addUser(UserRequest request) {
        User user  =  User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .birthOfDate(request.getBirthOfDate())
                .nationalityId(countryRepository.getById(request.getNationalityId()))
                .birthPlaceId(countryRepository.getById(request.getBirthPlaceId()))
                .build();
        userRepository.save(user);
        return true;
    }




    @Override
    @Transactional
    public boolean updateUser(Integer id , UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        ()->new UserNotFoundException("Kullanici Bulunamadi : "+id)
                );
           user.setName(userRequest.getName());
           user.setSurname(userRequest.getSurname());
           user.setEmail(userRequest.getEmail());
           user.setPassword(userRequest.getPassword());
           user.setPhone(userRequest.getPhone());
           user.setBirthOfDate(userRequest.getBirthOfDate());
           user.setNationalityId(countryRepository.getById(userRequest.getNationalityId()));
           user.setBirthPlaceId(countryRepository.getById(userRequest.getBirthPlaceId()));
            userRepository.save(user);
            return true;
    }




    @Override
    @Transactional
    public boolean removeUser(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        ()-> new UserNotFoundException("Kullanici Bulunamadi")
                );
        userRepository.delete(user);
        return true;
    }






}
