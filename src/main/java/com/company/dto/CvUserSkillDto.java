package com.company.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvUserSkillDto {

    private int power;
    private CvSkillDto cvSkillDto;

}
