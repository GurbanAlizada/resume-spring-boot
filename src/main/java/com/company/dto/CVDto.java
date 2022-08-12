package com.company.dto;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.entity.UserSkill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CVDto {

    private UserDto user;
    private List<CvEmploymentHistoryDto> employmentHistoryList;
    private List<CvUserSkillDto> userSkillListl;

}
