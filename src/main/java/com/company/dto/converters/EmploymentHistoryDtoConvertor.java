package com.company.dto.converters;

import com.company.dto.EmploymentHistoryDto;
import com.company.entity.EmploymentHistory;
import org.springframework.stereotype.Component;

@Component
public class EmploymentHistoryDtoConvertor {

    private final UserDtoConvertor userDtoConvertor;

    public EmploymentHistoryDtoConvertor(UserDtoConvertor userDtoConvertor) {
        this.userDtoConvertor = userDtoConvertor;
    }

    public EmploymentHistoryDto convertToEmploymentHistory(EmploymentHistory employmentHistory){
        return new EmploymentHistoryDto(
                employmentHistory.getId(),
                employmentHistory.getHeader(),
                employmentHistory.getBeginDate(),
                employmentHistory.getEndDate(),
                employmentHistory.getJobDescription(),
                userDtoConvertor.convertToUserDto(employmentHistory.getUser())
        );
    }






}
