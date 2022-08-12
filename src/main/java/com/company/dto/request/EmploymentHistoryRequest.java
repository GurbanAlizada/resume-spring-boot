package com.company.dto.request;


import com.company.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentHistoryRequest {

    @NotNull
    @NotBlank
    private String header;

    @PastOrPresent
    private LocalDate beginDate;

    @PastOrPresent
    private LocalDate endDate;

    @NotNull
    @NotBlank
    private String jobDescription;

    @NotNull
    private int  userId;
}
