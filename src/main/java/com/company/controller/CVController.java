package com.company.controller;


import com.company.dto.CVDto;
import com.company.service.impl.CVDtoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/cv")
public class CVController {

    private final CVDtoServiceImpl cvDtoService;

    public CVController(CVDtoServiceImpl cvDtoService) {
        this.cvDtoService = cvDtoService;
    }


    @GetMapping("/getCv/{id}")
    public CVDto getCv(@PathVariable("id") int userId){
        return cvDtoService.getCv(userId);
    }



}
