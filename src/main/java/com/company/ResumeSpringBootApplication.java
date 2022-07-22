package com.company;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.dao.impl.UserRepository;
import com.company.dao.inter.EmploymentHistoryRepository;
import com.company.entity.User;
import com.company.service.inter.CountryServiceInter;
import com.company.service.inter.EmploymentHistoryServiceInter;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableCaching
public class ResumeSpringBootApplication implements CommandLineRunner {

    /*@Qualifier("userRepository")
    @Autowired
    private UserRepositoryCustom userCustomRepository; */
    @Autowired
    private UserServiceInter serviceInter;

    @Autowired
    private CountryServiceInter countryServiceInter;

    @Autowired
    private EmploymentHistoryServiceInter employmentHistoryServiceInter;


    public static void main(String[] args) {
        SpringApplication.run(ResumeSpringBootApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        // UserService Test
        /*System.out.println(serviceInter.getAllUser());
        System.out.println(serviceInter.getUsersWithParams("Qurban", "Alizada"));
        System.out.println(serviceInter.getByEmailAndPassword("xyz", "456"));
        System.out.println(serviceInter.getById(1));
        System.out.println(serviceInter.findByName("Qurban"));
        User user = new User(0 , "Test" , "test" , "test" , "1234" , "1234" , null , null , null , null ,null);
        serviceInter.addUser(user);
        User u = serviceInter.getById(1);
        u.setSurname("ALIZADAA");
        serviceInter.updateUser(u);
        serviceInter.removeUser(5);
        System.out.println(serviceInter.getAllInfo());
        System.out.println(serviceInter.getUserByNationality("Azerbaijan"));*/


        // CountryService Test
        /*System.out.println(countryServiceInter.getAll());
        System.out.println(countryServiceInter.getById(1));*/


        // EmplpoymentHistoryService
        /*System.out.println(employmentHistoryServiceInter.getAllEmploymentHistory());
        System.out.println(employmentHistoryServiceInter.getEmploymentHistoryByUser(1));*/




    }
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.company")).build();
    }



}
