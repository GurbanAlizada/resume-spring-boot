package com.company.service.inter;

import com.company.entity.EmploymentHistory;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmploymentHistoryServiceInter {

    List<EmploymentHistory> getAllEmploymentHistory();

    List<EmploymentHistory> getEmploymentHistoryByUser(Integer id);

}
