package com.company.service.inter;

import com.company.dto.CountryDto;
import com.company.dto.request.CountryRequest;
import com.company.entity.Country;
import com.company.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryServiceInter {

    List<Country> getAllCountry();

    Country getById(int id);

    boolean add(CountryRequest countryRequest);

    boolean update(int id ,CountryRequest countryRequest);

    boolean remove(int id);





}
