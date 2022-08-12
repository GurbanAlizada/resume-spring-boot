package com.company.dao.inter;

import com.company.entity.User;
import com.company.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSkillRepository extends JpaRepository<UserSkill , Integer> {

    List<UserSkill> findByUser_Id(int id);

}
