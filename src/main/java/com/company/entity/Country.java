package com.company.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "country_name")
    private String name;

    @Column(name = "nationality")
    private String nationality;


    @OneToMany(mappedBy = "nationalityId")
    @JsonIgnore
    private List<User> users1;

    @OneToMany(mappedBy = "birthPlaceId")
    @JsonIgnore
    private List<User> users2;


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationalityId='" + nationality + '\'' +
                '}';
    }


}
