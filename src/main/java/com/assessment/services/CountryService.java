package com.assessment.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assessment.dao.CountryDao;
import com.assessment.models.Country;


@Service
public class CountryService {

	@Autowired
	private  CountryDao countryDao;
	
	public  Country createCountry(Country item) {
		return countryDao.save(item);
	}

	public  Iterable<Country> createCountries(List<Country> coList) {
		Iterable<Country> list = countryDao.saveAll(coList);
		return list;
	}
	
	public  Iterable<Country> findAllCountries() {
		Iterable<Country> list = countryDao.findAll();
		return list;
	}
	
	
	public  void deleteCountry(Country co) {
		countryDao.delete(co);
	}

	public Country getCountryInfo(int id) {
			
		Country co = countryDao.getOne(id);
		return co;
		
	}
	

	

}
