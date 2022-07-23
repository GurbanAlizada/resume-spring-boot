package com.company.service.impl;

import com.company.dao.impl.UserRepository;
import com.company.dto.UserDto;
import com.company.dto.converters.UserDtoConvertor;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    private  UserRepository daoInter;
    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private UserDtoConvertor userDtoConvertor;

    public List<User> findByName(String name){
       return  daoInter.findByName(name);
    }




    @Override
    public List<User> getAllInfo() {
        return daoInter.getAllInfo();
    }
    @Override
    public List<UserDto> getAllInfoDto() {
        List<User> users = daoInter.findAll();
        List<UserDto> dto = users.stream().map(user -> modelMapper.map(user , UserDto.class)).collect(Collectors.toList());
        return dto;
    }



    @Override
    public User getById(int userId) {
        User user = daoInter.findById(userId);
        return  user;
    }
    @Override
    public UserDto getByIdDto(int userId) {
        User user = daoInter.findById(userId);
        UserDto dto = userDtoConvertor.convertToUserDto(user);
      //  UserDto dto = userMapper.toUserDto(user);
       // UserDto dto2 = modelMapper.map(user , UserDto.class);
        return  dto;
    }





    @Override
    public boolean addUser(User u) {
        daoInter.addUser(u);
        return false;
    }
    @Override
    public UserDto addUserDto(User u) {
        daoInter.addUser(u);
       UserDto dto =  modelMapper.map(u , UserDto.class);
        return dto;
    }









    @Override
    public boolean updateUser(Integer id , User u) {
        User user = daoInter.getById(id);
        if(user != null){
            user.setName(u.getName());
            user.setSurname(u.getSurname());
            user.setEmail(u.getEmail());
            user.setPassword(u.getPassword());
          //  user.setBirthOfDate(u.getBirthOfDate());
            user.setPhone(u.getPhone());
        //    user.setBirthPlaceId(u.getBirthPlaceId());
         //   user.setNationalityId(u.getNationalityId());
            daoInter.updateUser(user);
        }
        return false;
    }
    @Override
    public UserDto updateUserDto(Integer id, User u) {
        User user = daoInter.getById(id);
        if(user != null){
            user.setName(u.getName());
            user.setSurname(u.getSurname());
            user.setEmail(u.getEmail());
            user.setPassword(u.getPassword());
            //  user.setBirthOfDate(u.getBirthOfDate());
            user.setPhone(u.getPhone());
            //    user.setBirthPlaceId(u.getBirthPlaceId());
            //   user.setNationalityId(u.getNationalityId());
            daoInter.updateUser(user);
            UserDto dto = modelMapper.map(user , UserDto.class );
            return dto;
        }
        return null;
    }






    @Override
    public User save(User user) {
        return daoInter.save(user);
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
    public boolean removeUser(int id) {
           daoInter.removeUser(id);
        return true;
    }


}
