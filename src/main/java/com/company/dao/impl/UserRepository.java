package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> ,UserRepositoryCustom {

    @Query("select  u from User  u left join fetch u.nationalityId left join fetch u.birthPlaceId where u.id =:id")
    User findById(@Param("id") int id);

    @Query("select  u from User  u left join fetch u.nationalityId left join fetch u.birthPlaceId where u.name =:name")
    List<User> findByName(String name);

    @Query("select u from User u left join fetch u.birthPlaceId left join fetch u.nationalityId where u.email = :email and u.password  =:password")
    User findByEmailAndPassword(@Param("email") String email , @Param("password") String password);

    @Query("select u from User u left join fetch u.birthPlaceId left join fetch u.nationalityId")
    List<User> getAllInfo();

    @Query("select u from User u left join fetch u.nationalityId left join fetch u.birthPlaceId  where u.birthPlaceId.name = :name")
    List<User> getUserByNationality(@Param("name") String name);



    // @Query(value = "select u.*  , n.nationality  ,  c.country_name   from   resumejpa.user u  left join resumejpa.country n on u.nationality_id = n.id  left join resumejpa.country c on u.birth_place_id = c.id  where u.email = ?1 and u.password = ?2" , nativeQuery = true)
   // User findByEmailAndPassword( String email ,  String password);






}
