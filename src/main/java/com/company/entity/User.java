package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

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

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn (name = "nationality_id")
  //  @JsonIgnore
    private Country nationalityId;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "birth_place_id")
   // @JsonIgnore
    private Country birthPlaceId;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<EmploymentHistory> employmentHistorys;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserSkill> userSkillList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
              //  ", phone='" + phone + '\'' +
              //  ", birthOfDate=" + birthOfDate +
        //        ", nationalityId=" + nationalityId +
           //    ", birthPlaceId=" + birthPlaceId +
               // ", employmentHistorys=" + employmentHistorys +
               // ", userSkillList=" + userSkillList +
                '}';
    }
}
