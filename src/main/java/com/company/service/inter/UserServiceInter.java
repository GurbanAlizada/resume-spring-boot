package com.company.service.inter;
import com.company.dto.request.UserRequest;
import com.company.entity.User;
import org.springframework.data.domain.Page;
import java.util.List;


public interface UserServiceInter {

    List<User> getAllUser();

    User getById(Integer userId);

    List<User> findByName(String name);

    List<User> getUsersWithParams(String name , String surname );

    User getByEmailAndPassword(String email , String password) ;

    List<User> getUserByNationality(String name);


    boolean addUser(UserRequest request);


    boolean updateUser( Integer id ,UserRequest userRequest);


    boolean removeUser(int id);


}
