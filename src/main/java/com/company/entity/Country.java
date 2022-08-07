package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({
        "hibernateLazyInitializer" ,
        "handler" ,
        "users1",
        "users2"
})
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "country_name")
    private String name;

    @Column(name = "nationality")
    private String nationality;


    @OneToMany(mappedBy = "nationalityId")
    private List<User> users1;

    @OneToMany(mappedBy = "birthPlaceId")
    private List<User> users2;



}
