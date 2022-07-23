package com.company.service.impl;

import com.company.dao.inter.CountryRepository;
import com.company.dto.CountryDto;
import com.company.dto.converters.CountryDtoConvertor;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryServiceImpl implements CountryServiceInter {


   private  final CountryRepository countryRepository;

    private final  CountryDtoConvertor countryDtoConvertor;


    public CountryServiceImpl(CountryRepository countryRepository, CountryDtoConvertor countryDtoConvertor) {
        this.countryRepository = countryRepository;
        this.countryDtoConvertor = countryDtoConvertor;
    }

    @Override
    public List<Country> getAllCo() {
        return  countryRepository.findAll();
    }

    @Override
    public Country getById(int id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public CountryDto getByIdDto(int id) {
        Country country = countryRepository.findById(id).get();
        CountryDto dto = countryDtoConvertor.convertToCountryDto(country);
        return  dto;
    }



}
