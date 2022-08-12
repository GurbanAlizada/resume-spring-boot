package com.company.controller;

import com.company.dto.request.SkillRequest;
import com.company.entity.Skill;
import com.company.service.inter.SkillServiceInter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("v1/api/skill")
public class SkillController {


    private final SkillServiceInter skillServiceInter;

    public SkillController(SkillServiceInter skillServiceInter) {
        this.skillServiceInter = skillServiceInter;
    }


    @GetMapping("/getAllSkills")
    List<Skill> getAllSkills(){
        return skillServiceInter.getAllSkills();
    }



    @PostMapping("/add")
    public Skill add(@RequestBody @Valid SkillRequest skillRequest) {
        return skillServiceInter.add(skillRequest);
    }


    @PutMapping("/update/{id}")
    public Skill update(@PathVariable("id") int id, @RequestBody @Valid SkillRequest skillRequest) {
       return skillServiceInter.update(id , skillRequest);
    }



    @DeleteMapping("/delete/{id}")
    public Skill remove(@PathVariable("id") int id) {
       return skillServiceInter.remove(id);
    }

}
