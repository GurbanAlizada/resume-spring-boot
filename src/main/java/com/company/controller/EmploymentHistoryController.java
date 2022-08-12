package com.company.controller;


import com.company.dto.request.EmploymentHistoryRequest;
import com.company.dto.result.ResponseDto;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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




    @PostMapping("/add")
    public EmploymentHistory add(@RequestBody @Valid EmploymentHistoryRequest request) {
        return employmentHistoryServiceInter.add(request);
    }


    @PutMapping("/update/{id}")
    public EmploymentHistory update(@PathVariable("id") int id,@RequestBody @Valid EmploymentHistoryRequest request) {
       return employmentHistoryServiceInter.update(id, request);
    }


    @DeleteMapping("/delete/{id}")
    public EmploymentHistory remove(@PathVariable("id") int id) {
       return employmentHistoryServiceInter.remove(id);
    }




}
