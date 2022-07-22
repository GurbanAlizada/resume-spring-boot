package com.company.service.impl;

import com.company.dao.inter.UserSkillRepository;
import com.company.entity.UserSkill;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserSkillServiceImpl implements UserSkillServiceInter {

    @Autowired
    private UserSkillRepository userSkillRepository ;

    @Override
    public UserSkill getUserSkil(int id) {
        return userSkillRepository.findById(id).get();
    }


}
/*
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true




 */