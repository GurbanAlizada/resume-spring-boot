package com.company.service.impl;

import com.company.dao.inter.SkillRepository;
import com.company.dao.inter.UserSkillRepository;
import com.company.dto.request.SkillRequest;
import com.company.entity.Skill;
import com.company.exception.SkillNotFoundException;
import com.company.service.inter.SkillServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillServiceInter {

    private final SkillRepository skillRepository;
    private final UserSkillRepository userSkillRepository;

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill add(SkillRequest skillRequest) {
        Skill skill = Skill.builder()
                .name(skillRequest.getName())
                .build();
        return skillRepository.save(skill);
    }


    @Override
    public Skill update(int id, SkillRequest skillRequest) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(
                        ()-> new SkillNotFoundException("Boyle bir skill bulunmuyor")
                );
        skill.setName(skillRequest.getName());
        return skillRepository.save(skill);
    }



    @Override
    public Skill remove(int id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(
                        ()-> new SkillNotFoundException("Boyle bir skill bulunmuyor")
                );

         skillRepository.delete(skill);
        return skill;
    }







}
