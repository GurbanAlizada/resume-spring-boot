package com.company.service.impl;

import com.company.dao.impl.UserRepository;
import com.company.dao.inter.CountryRepository;
import com.company.dto.request.UserRequest;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.exception.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserServiceImpl service;
    private UserRepository userRepository ;
    private CountryRepository countryRepository ;



    @BeforeEach
    public void setUp(){
        userRepository = Mockito.mock(UserRepository.class);
        countryRepository  = Mockito.mock(CountryRepository.class);
        service = new UserServiceImpl(userRepository , countryRepository);
    }




    @Test
    public void testGetUsersWithParams_whenNameAndSurnameExists_itShouldReturnUserList(){
        User user = User.builder()
                .name("test")
                .surname("test")
                .build();

        List<User> users = new ArrayList<>();

        users.add(user);

        Mockito.when(userRepository.getUsersWithParams("test" , "test")).thenReturn(users);

        List<User> result = service.getUsersWithParams("test" , "test");

        assertEquals(users , result);
    }




    @Test
    public void testFindByName_whenNameExists_itShouldReturnUser(){
        User user = User.builder()
                .id(957)
                .name("test-name")
                .surname("test-surname")
                .build();

        List<User> users = new ArrayList<>();
        users.add(user);

        Mockito.when(userRepository.findByName("test-name")).thenReturn(users);

       List<User> result = service.findByName("test-name");

       Mockito.verify(userRepository).findByName("test-name");

      assertEquals(result , users);
    }




    @Test
    public void testFindById_whenUserIdExists_itShouldReturnUser(){

        User user = User.builder()
                .id(957)
                .name("test-name")
                .build();

        Mockito.when(userRepository.findById(957)).thenReturn(Optional.of(user));

       User result =  service.getById(957);

        assertEquals(result , user);


    }





    @Test
    public void testFindById_whenUserIdDoesNotExists_itShouldThrowUserNotFoundException(){

        Mockito.when(userRepository.findById(967)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class , ()-> service.getById(957));


    }




    @Test
    public void testGetAllUser(){

        List<User> users = new ArrayList<>();
        User user1 = User.builder()
                .id(1)
                .name("test-name1")
                .build();
        User user2 = User.builder()
                .id(2)
                .name("test-name2")
                .build();
        users.add(user1);
        users.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> result = service.getAllUser();

        Assertions.assertEquals(result , users);
        Mockito.verify(userRepository).findAll();

    }



    @Test
    public void testGetByEmailAndPassword_whenEmailAndPasswordExists_itShouldReturnUser(){

        User user = User.builder()
                .id(1)
                .name("test-name1")
                .email("test-email")
                .password("test-password")
                .build();

        Mockito.when(userRepository.findByEmailAndPassword("test-email" , "test-password")).thenReturn(user);

        User result = service.getByEmailAndPassword("test-email" , "test-password");
        Assertions.assertEquals(result , user);
        Mockito.verify(userRepository).findByEmailAndPassword("test-email" , "test-password");

    }




    @Test
    public void testGetByEmailAndPassword_whenEmailAndPasswordDoesNotExists_itShouldReturnUser(){

        User user  = null;

        Mockito.when(userRepository.findByEmailAndPassword(null , null)).thenReturn(user);

        User result = service.getByEmailAndPassword(null , null);
        Assertions.assertNull(result);
        Mockito.verify(userRepository).findByEmailAndPassword(null, null);

    }





    @Test
    public void testAddUser_whenValidRequest_itShouldReturnTrue(){

        UserRequest userRequest = UserRequest.builder()
                .name("test-name")
                .surname("test-surname")
                .email("test-email")
                .password("test-password")
                .phone("test-phone")
                .birthOfDate(null)
                .birthPlaceId(123)
                .nationalityId(123)
                .build();

        Country country = Country.builder()
                .id(123)
                .name("test-name")
                .nationality("test-nat")
                .build();

        User user = User.builder()
                .name("test-name")
                .surname("test-surname")
                .email("test-email")
                .password("test-password")
                .phone("test-phone")
                .birthOfDate(null)
                .birthPlaceId(country)
                .nationalityId(country)
                .build();

        Mockito.when(userRepository.save(user)).thenReturn(user);

        assertTrue(service.addUser(userRequest));
        // Mockito.verify(userRepository).save(user);

    }




    @Test
    public void testUpdateUser_whenUserIdExists_itShouldReturnTrue(){

        UserRequest userRequest = UserRequest.builder()
                .name("test-name")
                .surname("test-surname")
                .email("test-email")
                .password("test-password")
                .phone("test-phone")
                .birthOfDate(null)
                .birthPlaceId(123)
                .nationalityId(123)
                .build();

        Country country = Country.builder()
                .id(123)
                .name("test-name")
                .nationality("test-nat")
                .build();

        User user = User.builder()
                .name("test-name")
                .surname("test-surname")
                .email("test-email")
                .password("test-password")
                .phone("test-phone")
                .birthOfDate(null)
                .birthPlaceId(country)
                .nationalityId(country)
                .build();

        Mockito.when(userRepository.findById(123)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.save(user)).thenReturn(user);


        assertTrue( service.updateUser(123 , userRequest ));
    }



    @Test
    public void testUpdateUser_whenUserIdDoesNotExists_itShouldThrowUserNotFoundException() {
        UserRequest userRequest = UserRequest.builder()
                .name("test-name")
                .surname("test-surname")
                .email("test-email")
                .password("test-password")
                .phone("test-phone")
                .birthOfDate(null)
                .birthPlaceId(123)
                .nationalityId(123)
                .build();


        Mockito.when(userRepository.findById(123)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class , ()-> service.updateUser(123 , userRequest));

    }





    }