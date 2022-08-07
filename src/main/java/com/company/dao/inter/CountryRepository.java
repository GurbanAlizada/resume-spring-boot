package com.company.dao.inter;

import com.company.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country , Integer>  {


}
