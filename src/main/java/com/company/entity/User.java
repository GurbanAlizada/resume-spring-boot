package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@JsonIgnoreProperties({
        "hibernateLazyInitializer" ,
        "handler" ,
        //   "nationalityId",
        //   "birthPlaceId",
        "employmentHistorys",
        "userSkillList"

})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password ;

    @Column(name = "phone")
    private String phone;

    @Column(name = "date_of_date")
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;

    @ManyToOne
    @JoinColumn (name = "nationality_id")
    private Country nationalityId;

    @ManyToOne
    @JoinColumn(name = "birth_place_id")
    private Country birthPlaceId;

    @OneToMany(mappedBy = "user")
    private List<EmploymentHistory> employmentHistorys;

    @OneToMany(mappedBy = "user")
    private List<UserSkill> userSkillList;



}
