package com.company.dto.result;


import lombok.Data;

@Data
public class ResponseDto {

    private int errorCode;
    private String errorMessage;
    private String successMessage;
    private Object obj;


    private ResponseDto(){

    }


    public static ResponseDto of(Object obj) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setObj(obj);
        return responseDto;
    }


    public static ResponseDto of(Object obj , String successMessage){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setObj(obj);
        responseDto.setSuccessMessage(successMessage);
        return responseDto;
    }




}
