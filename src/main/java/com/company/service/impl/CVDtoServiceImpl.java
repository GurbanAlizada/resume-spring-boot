package com.company.service.impl;


import com.company.dao.impl.UserRepository;
import com.company.dao.inter.EmploymentHistoryRepository;
import com.company.dao.inter.UserSkillRepository;
import com.company.dto.CVDto;
import com.company.dto.CvEmploymentHistoryDto;
import com.company.dto.CvUserSkillDto;
import com.company.dto.UserDto;
import com.company.dto.converters.CvEmploymentHistoryDtoConvertor;
import com.company.dto.converters.CvUserSkillDtoConvertor;
import com.company.dto.converters.UserDtoConvertor;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CVDtoServiceImpl {

    private final UserRepository userRepository;
    private final EmploymentHistoryRepository employmentHistoryRepository;
    private final UserSkillRepository userSkillRepository;
    private final CvEmploymentHistoryDtoConvertor convertor;
    private final CvUserSkillDtoConvertor cvUserSkillDtoConvertor;
    private final UserDtoConvertor userDtoConvertor;



    public CVDto getCv(int userId){

        User user = userRepository.findById(userId)
                .orElseThrow(
                        ()->new UserNotFoundException("Not found")
                );

        UserDto dto2 = userDtoConvertor.convertToUserDto(user);

        List<EmploymentHistory> list = employmentHistoryRepository.getByUser_Id(userId);

        List<CvEmploymentHistoryDto> dto = list.stream()
                .map(n->convertor.convert(n))
                .collect(Collectors.toList());

       List<UserSkill> list1 = userSkillRepository.findByUser_Id(userId);

       List<CvUserSkillDto> dto1 = list1.stream()
               .map(n->cvUserSkillDtoConvertor.convert(n))
               .collect(Collectors.toList());

        CVDto cv = CVDto.builder()
                .user(dto2)
                .employmentHistoryList(dto)
                .userSkillListl(dto1)
                .build();
        return cv;
    }




}
