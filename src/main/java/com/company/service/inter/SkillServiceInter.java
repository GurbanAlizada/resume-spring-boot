package com.company.service.inter;

import com.company.dto.request.SkillRequest;
import com.company.entity.Skill;

import java.util.List;

public interface SkillServiceInter {

    List<Skill> getAllSkills();


    Skill add(SkillRequest skillRequest);

    Skill update(int id , SkillRequest skillRequest);

    Skill remove(int id);


}
