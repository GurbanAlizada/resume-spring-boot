package com.company.service.inter;

import com.company.dto.request.UserSkillRequest;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillServiceInter {

    List<UserSkill> findByUser_Id(int id);

    UserSkill add(UserSkillRequest request);


}
