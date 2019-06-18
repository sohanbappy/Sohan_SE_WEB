package com.assessment.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assessment.models.Country;



@Repository
public interface  CountryDao extends JpaRepository<Country, Integer>{

	
	
}
