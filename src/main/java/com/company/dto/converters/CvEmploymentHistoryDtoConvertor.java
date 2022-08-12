package com.company.dto.converters;


import com.company.dto.CvEmploymentHistoryDto;
import com.company.entity.EmploymentHistory;
import org.springframework.stereotype.Component;

@Component
public class CvEmploymentHistoryDtoConvertor {



    public CvEmploymentHistoryDto convert(EmploymentHistory employmentHistory){
        CvEmploymentHistoryDto dto = CvEmploymentHistoryDto.builder()
                .beginDate(employmentHistory.getBeginDate())
                .endDate(employmentHistory.getEndDate())
                .header(employmentHistory.getHeader())
                .jobDescription(employmentHistory.getJobDescription())
                .build();
        return dto;
    }














}
