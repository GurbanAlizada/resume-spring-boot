package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory , Integer> {

    @Query("select e from EmploymentHistory e  where e.user.id = :id")
    List<EmploymentHistory> getEmploymentHistoryByUser(Integer id);


}
