package com.company.dto.converters;


import com.company.dto.UserDto;
import com.company.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConvertor {

    public UserDto convertToUserDto(User user){
       return new UserDto(
               user.getId(),
               user.getName(),
               user.getEmail());
    }

}
