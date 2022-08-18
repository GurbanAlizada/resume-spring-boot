package com.company.aspects;


import com.company.dto.request.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspects {





    @After("execution(* com.company.service.impl.UserServiceImpl.addUser(..)) && args(userRequest,..)")
    public void afterSave(UserRequest userRequest){
        log.info("Sisteme kayit olundu {} " , userRequest.getName());

    }







}
