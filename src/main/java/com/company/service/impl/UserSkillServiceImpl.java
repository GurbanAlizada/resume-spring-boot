package com.company.service.impl;

import com.company.dao.impl.UserRepository;
import com.company.dao.inter.SkillRepository;
import com.company.dao.inter.UserSkillRepository;
import com.company.dto.request.UserSkillRequest;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.exception.SkillNotFoundException;
import com.company.exception.UserNotFoundException;
import com.company.service.inter.UserSkillServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserSkillServiceImpl implements UserSkillServiceInter {

    private final UserSkillRepository userSkillRepository ;
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;


    @Override
    public List<UserSkill> findByUser_Id(int id) {
        return userSkillRepository.findByUser_Id(id);
    }

    @Override
    public UserSkill add(UserSkillRequest request) {
        Skill skill = skillRepository.findById(request.getSkillId()).orElseThrow(()->new SkillNotFoundException("Skill Bulunamadu"));
        User user = userRepository.findById(request.getUserId()).orElseThrow(()->new UserNotFoundException("Kullanici Bulunamadu"));
        UserSkill userSkill = UserSkill.builder()
                .skill(skill)
                .user(user)
                .power(request.getPower())
                .build();
        return userSkillRepository.save(userSkill);
    }



}
/*
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true




 */