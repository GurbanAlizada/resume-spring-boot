package com.company.dto.converters;

import com.company.dto.CvSkillDto;
import com.company.entity.Skill;
import org.springframework.stereotype.Component;

@Component
public class CvSkillDtoConvertor {

    public CvSkillDto convert(Skill skill){
        CvSkillDto cvSkillDto = CvSkillDto.builder()
                .name(skill.getName())
                .build();
        return cvSkillDto;
    }


}
