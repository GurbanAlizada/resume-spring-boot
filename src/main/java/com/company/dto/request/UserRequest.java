package com.company.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRequest {


    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String surname;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String password ;

    @NotNull
    @NotBlank
    @Positive
    private String phone;

    @NotNull
    @Past
    private LocalDate birthOfDate;

    @NotNull
    @Positive
    private int nationalityId;

    @NotNull
    @Positive
    private int birthPlaceId;



}
