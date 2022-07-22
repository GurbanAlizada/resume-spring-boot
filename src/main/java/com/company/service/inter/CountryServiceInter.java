package com.company.service.inter;

import com.company.entity.Country;
import com.company.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryServiceInter {

    List<Country> getAllCo();

    Country getById(int id);


}
