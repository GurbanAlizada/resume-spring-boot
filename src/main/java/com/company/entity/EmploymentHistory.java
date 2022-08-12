package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@JsonIgnoreProperties({
        "hibernateLazyInitializer" ,
        "handler"
})
public class EmploymentHistory implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Integer id ;

    @Column(name  = "header")
    private String header;

    @Column(name  = "begin_date")
    private LocalDate beginDate;

    @Column(name  = "end_date")
    private LocalDate endDate;

    @Column(name  = "job_description")
    private String jobDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



}
