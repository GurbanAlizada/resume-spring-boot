package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
@Transactional
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    //@Cacheable(value = "user")
    public List<User> getUsersWithParams(String name, String surname) {
            String jpql = "select u from User u left join fetch u.nationalityId " +
                    " left join fetch u.birthPlaceId " +
                    " where 1=1 ";
            if (name != null && !name.trim().isEmpty()){
                jpql += " and  u.name = :name ";
            }
            if (surname != null && !surname.trim().isEmpty()){
                jpql += " and u.surname = :surname ";
            }
          TypedQuery<User> typedQuery = entityManager.createQuery(jpql , User.class);
            if (name != null && !name.trim().isEmpty()){
                typedQuery.setParameter("name" , name);
            }
            if (surname != null  && !surname.trim().isEmpty()){
               typedQuery.setParameter("surname" , surname);
            }
         List<User> users = typedQuery.getResultList();
        return users;
    }



}
