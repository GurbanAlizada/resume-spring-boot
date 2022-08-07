package com.company.dto;


import com.company.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentHistoryDto {



    private  Integer id ;

    private String header;

    private Date beginDate;

    private Date endDate;

    private String jobDescription;

    private UserDto userDto;




}
