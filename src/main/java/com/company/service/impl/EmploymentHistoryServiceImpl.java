package com.company.service.impl;

import com.company.dao.impl.UserRepository;
import com.company.dao.inter.EmploymentHistoryRepository;
import com.company.dto.EmploymentHistoryDto;
import com.company.dto.converters.EmploymentHistoryDtoConvertor;
import com.company.dto.request.EmploymentHistoryRequest;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.service.inter.EmploymentHistoryServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {


    private final EmploymentHistoryRepository employmentHistoryRepository;
    private final EmploymentHistoryDtoConvertor employmentHistoryDtoConvertor;
    private final UserRepository userRepository;


    @Override
    public List<EmploymentHistoryDto> getByUserId(int userId) {
        List<EmploymentHistory> list =  employmentHistoryRepository.getByUser_Id(userId);
        List<EmploymentHistoryDto> dto = list.stream()
                .map(l->employmentHistoryDtoConvertor.convertToEmploymentHistory(l))
                .collect(Collectors.toList());
        return dto;
    }

    @Override
    public EmploymentHistory add(EmploymentHistoryRequest request) {
        User user = userRepository.getById(request.getUserId());
        EmploymentHistory employmentHistory = EmploymentHistory.builder()
                .beginDate(request.getBeginDate())
                .endDate(request.getEndDate())
                .header(request.getHeader())
                .jobDescription(request.getJobDescription())
                .user(user)
                .build();
        return  employmentHistoryRepository.save(employmentHistory);
    }

    @Override
    public EmploymentHistory update(int id, EmploymentHistoryRequest request) {
        User user = userRepository.getById(request.getUserId());

        EmploymentHistory employmentHistory = employmentHistoryRepository.getById(id);
        employmentHistory.setBeginDate(request.getBeginDate());
        employmentHistory.setEndDate(request.getEndDate());
        employmentHistory.setJobDescription(request.getJobDescription());
        employmentHistory.setHeader(request.getHeader());
        employmentHistory.setUser(user);
        return employmentHistoryRepository.save(employmentHistory);
    }


    @Override
    public EmploymentHistory remove(int id) {
        EmploymentHistory employmentHistory = employmentHistoryRepository.getById(id);
         employmentHistoryRepository.delete(employmentHistory);
        return employmentHistory;
    }


}
