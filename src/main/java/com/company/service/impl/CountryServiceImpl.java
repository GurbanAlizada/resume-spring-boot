package com.company.service.impl;

import com.company.dao.inter.CountryRepository;
import com.company.dto.request.CountryRequest;
import com.company.entity.Country;
import com.company.exception.CountryNotFoundException;
import com.company.service.inter.CountryServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CountryServiceImpl implements CountryServiceInter {


    private  final CountryRepository countryRepository;


    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }



    @Override
    public List<Country> getAllCountry() {
        return  countryRepository.findAll();
    }



    @Override
    public Country getById(int id) {
        return countryRepository.findById(id)
                .orElseThrow(
                ()->new CountryNotFoundException("Boyle bir ulke bulunmuyor")
        );
    }




    @Override
    @Transactional
    public boolean add(CountryRequest countryRequest) {
        Country country = Country.builder()
                .name(countryRequest.getName())
                .nationality(countryRequest.getNationality())
                .build();
        countryRepository.save(country);
        return true;
    }




    @Override
    @Transactional
    public boolean update(int id,CountryRequest countryRequest) {
        Country country = countryRepository.findById(id)
                .orElseThrow(
                        ()->
                                new CountryNotFoundException("Boyle bir ulke bulunmuyor")
                );
        country.setName(countryRequest.getName());
        country.setNationality(countryRequest.getNationality());
        countryRepository.save(country);
        return true;
    }





    @Override
    @Transactional
    public boolean remove(int id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(
                        ()->
                                new CountryNotFoundException("Boyle bir ulke bulunmuyor")
                );
        countryRepository.delete(country);
        return true;
    }







}
