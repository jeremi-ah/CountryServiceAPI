package com.country.springbootcountryservice.services;

import com.country.springbootcountryservice.beans.Country;
import com.country.springbootcountryservice.controllers.AddResponse;
import com.country.springbootcountryservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Service
public class CountryService
{

    @Autowired
    CountryRepository countryrep;

    //getting all the countries
    public List<Country> getAllCountries() {
       return countryrep.findAll();
    }

    //get country by id
    public Country getCountryById(int id) {
        return countryrep.findById(id).get();
    }

    //get country by name
    public Country getCountryBYName(String countryName) {
      List<Country> countries=countryrep.findAll();
      Country country=null;
        for (Country con:countries) {
            if (con.getName().equalsIgnoreCase(countryName))
                country=con;
        }
        return country;

    }
    //adding country
    public Country addCountry(Country country) {
        country.setId(getMaxId());
        countryrep.save(country);
        return country;

    }

    //utility method to get max id
    public int getMaxId() {
       return countryrep.findAll().size()+1;

    }

    //update country
    public Country updateCountry(Country country) {
        countryrep.save(country);
        return country;

    }
    //method to delete the country
    public AddResponse deleteCountry(int id){
        countryrep.deleteById(id);
        AddResponse res=new AddResponse();
        res.setMessage("Country deleted !");
        res.setId(id);
        return res;
    }
}


