package com.company.dto.converters;


import com.company.dto.CvSkillDto;
import com.company.dto.CvUserSkillDto;
import com.company.entity.UserSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CvUserSkillDtoConvertor {

    private final CvSkillDtoConvertor convertor;

    public CvUserSkillDto convert(UserSkill userSkill){

        CvUserSkillDto dto = CvUserSkillDto.builder()
                .power(userSkill.getPower())
                .cvSkillDto(convertor.convert(userSkill.getSkill()))
                .build();

        return dto;
    }




}
