package com.company.service.impl;

import com.company.dao.inter.EmploymentHistoryRepository;
import com.company.entity.EmploymentHistory;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {


    @Autowired
    private EmploymentHistoryRepository employmentHistoryRepository;


    @Override
    public List<EmploymentHistory> getAllEmploymentHistory() {
        return employmentHistoryRepository.findAll();
    }

    @Override
    public List<EmploymentHistory> getEmploymentHistoryByUser(Integer id) {
        return employmentHistoryRepository.getEmploymentHistoryByUser(id);
    }


}
