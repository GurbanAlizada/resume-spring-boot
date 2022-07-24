package com.company.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

     private LocalDate timestamp;
     private String status;
     private String code;



}

