package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> ,UserRepositoryCustom {


    // @Query("select  u from User  u left join fetch u.nationalityId left join fetch u.birthPlaceId where u.name =:name")
    List<User> findByName(String name);




    // @Query("select u from User u left join fetch u.birthPlaceId left join fetch u.nationalityId where u.email = :email and u.password  =:password")
    User findByEmailAndPassword(String email ,String password);




   // @Query("select u from User u left join fetch u.nationalityId left join fetch u.birthPlaceId  where u.birthPlaceId.name = :name")
    List<User> getByBirthPlaceId_Name(String name);





}
