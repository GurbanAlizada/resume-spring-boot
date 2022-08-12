package com.company.dto;

import com.company.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CvEmploymentHistoryDto {


    private String header;

    private LocalDate beginDate;

    private LocalDate endDate;

    private String jobDescription;




}
