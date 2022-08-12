package com.company.service.inter;

import com.company.dto.EmploymentHistoryDto;
import com.company.dto.request.EmploymentHistoryRequest;
import com.company.entity.EmploymentHistory;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmploymentHistoryServiceInter {

  List<EmploymentHistoryDto> getByUserId(int userId);

  EmploymentHistory add(EmploymentHistoryRequest request);

  EmploymentHistory update(int id , EmploymentHistoryRequest request);

  EmploymentHistory remove(int id );



}
