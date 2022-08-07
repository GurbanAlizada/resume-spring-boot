package com.company.service.impl;

import com.company.dao.inter.EmploymentHistoryRepository;
import com.company.dto.EmploymentHistoryDto;
import com.company.dto.converters.EmploymentHistoryDtoConvertor;
import com.company.entity.EmploymentHistory;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {


    private final EmploymentHistoryRepository employmentHistoryRepository;
    private final EmploymentHistoryDtoConvertor employmentHistoryDtoConvertor;


    public EmploymentHistoryServiceImpl(EmploymentHistoryRepository employmentHistoryRepository,
                                        EmploymentHistoryDtoConvertor employmentHistoryDtoConvertor) {
        this.employmentHistoryRepository = employmentHistoryRepository;
        this.employmentHistoryDtoConvertor = employmentHistoryDtoConvertor;
    }

    @Override
    public List<EmploymentHistoryDto> getByUserId(int userId) {
        List<EmploymentHistory> list =  employmentHistoryRepository.getByUser_Id(userId);
        List<EmploymentHistoryDto> dto = list.stream()
                .map(l->employmentHistoryDtoConvertor.convertToEmploymentHistory(l))
                .collect(Collectors.toList());
        return dto;
    }




}
