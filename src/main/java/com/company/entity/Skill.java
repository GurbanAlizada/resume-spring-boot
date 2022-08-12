package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({
        "hibernateLazyInitializer" ,
        "handler" ,
        "userSkillList"

})
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name;

    @OneToMany(mappedBy = "skill")
    @JsonIgnore
    private List<UserSkill> userSkillList;


}
