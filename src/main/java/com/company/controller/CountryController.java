package com.company.controller;


import com.company.dto.request.CountryRequest;
import com.company.dto.result.ResponseDto;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CountryController {

    private final CountryServiceInter countryServiceInter;

    public CountryController(CountryServiceInter countryServiceInter) {
        this.countryServiceInter = countryServiceInter;
    }



    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAll(){
        return ResponseEntity.ok(countryServiceInter.getAllCountry());
    }



    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getById( @PathVariable int id){
        return ResponseEntity.ok(countryServiceInter.getById(id));
    }



    @PostMapping("/countries")
    public ResponseEntity<ResponseDto> add(@Valid @RequestBody CountryRequest countryRequest){
        return ResponseEntity.ok(ResponseDto.of(countryServiceInter.add(countryRequest),"Successfully added"));
    }


    @PutMapping("/countries/{id}")
    public ResponseEntity<ResponseDto> update( @PathVariable("id") int id ,@Valid @RequestBody CountryRequest countryRequest){
        return ResponseEntity.ok(ResponseDto.of(countryServiceInter.update(id, countryRequest) , "Successfully updated"));
    }


    @DeleteMapping("/countries/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") int id){
        return ResponseEntity.ok(ResponseDto.of(countryServiceInter.remove(id),"Successfully deleted"));
    }


}
