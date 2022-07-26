package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.WebRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   private int id;
   private String name;
   private String email;

}
