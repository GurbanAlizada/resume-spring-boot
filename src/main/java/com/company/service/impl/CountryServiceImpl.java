package com.company.service.impl;

import com.company.dao.inter.CountryRepository;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryServiceImpl implements CountryServiceInter {


    @Autowired
   private CountryRepository countryRepository;


    @Override
    public List<Country> getAllCo() {
        return  countryRepository.findAll();
    }

    @Override
    public Country getById(int id) {
        return countryRepository.findById(id).get();
    }



}
