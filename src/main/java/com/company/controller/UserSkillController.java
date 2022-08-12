package com.company.controller;

import com.company.dto.request.UserSkillRequest;
import com.company.entity.UserSkill;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/userSkill")
public class UserSkillController {


    private final UserSkillServiceInter userSkillServiceInter;

    public UserSkillController(UserSkillServiceInter userSkillServiceInter) {
        this.userSkillServiceInter = userSkillServiceInter;
    }


    @GetMapping("/findByUserId/{id}")
    List<UserSkill> findByUser_Id(@PathVariable("id") int id){
        return userSkillServiceInter.findByUser_Id(id);
    }

    @PostMapping("/add")
    UserSkill add(@RequestBody @Valid UserSkillRequest request){
        return userSkillServiceInter.add(request);
    }


}
