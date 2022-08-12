package com.company.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSkillRequest {

    @NotNull
    private int userId;

    @NotNull
    private int skillId;

    @NotNull
    private int power;


}
