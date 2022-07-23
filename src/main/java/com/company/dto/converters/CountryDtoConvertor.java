package com.company.dto.converters;


import com.company.dto.CountryDto;
import com.company.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoConvertor {

    public CountryDto convertToCountryDto(Country country){
      return  new CountryDto(
                country.getName()
        );
    }



}
