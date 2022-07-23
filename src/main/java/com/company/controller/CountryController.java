package com.company.controller;


import com.company.dto.CountryDto;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController {

    @Autowired
    private CountryServiceInter countryController;


    @GetMapping("/getAll")
    public List<Country>  getAll(){
        return countryController.getAllCo();
    }

    @GetMapping("/getById")
    public Country getById( @RequestParam  int id){
        return countryController.getById(id);
    }


    @GetMapping("/getByIdDto")
    public CountryDto getByIdDto(@RequestParam  int id){
        return countryController.getByIdDto(id);
    }



}
