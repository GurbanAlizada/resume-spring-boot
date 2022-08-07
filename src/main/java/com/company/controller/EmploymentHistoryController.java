package com.company.controller;


import com.company.dto.result.ResponseDto;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class EmploymentHistoryController {


    private final EmploymentHistoryServiceInter employmentHistoryServiceInter;

    public EmploymentHistoryController(EmploymentHistoryServiceInter employmentHistoryServiceInter) {
        this.employmentHistoryServiceInter = employmentHistoryServiceInter;
    }


    @GetMapping("/employmentHistory/{id}")
    public ResponseEntity<ResponseDto> getByUserId(@PathVariable("id") int userId){
        return ResponseEntity.ok(ResponseDto.of(employmentHistoryServiceInter.getByUserId(userId),"Data listed"));
    }





}
