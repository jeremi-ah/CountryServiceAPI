package com.country.springbootcountryservice.controllers;

import com.country.springbootcountryservice.beans.Country;
import com.country.springbootcountryservice.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class countryController{
   // @Autowired
   // CountryService countryService=new CountryService();

   @Autowired
   CountryService countryService;

   @RequestMapping("/getcountries")
   public List<Country> getCountries(){
      return countryService.getAllCountries();
   }

    @RequestMapping("/getcountries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") int id){
      try {
          Country country=countryService.getCountryById(id);
          return new ResponseEntity<Country>(country, HttpStatus.OK);
      } catch (Exception e){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

   }

    @RequestMapping("/getcountries/countryname")
    public ResponseEntity<Country> getCountryByName(@RequestParam(value = "name") String countryName){
       try {
           Country country= countryService.getCountryBYName(countryName);
           return new ResponseEntity<Country>(country, HttpStatus.OK);
       } catch (Exception e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);

       }

   }

    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country){
       return countryService.addCountry(country);
   }

    @PutMapping("/updatecountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") int id, @RequestBody Country country){
       try {
          Country existCountry=countryService.getCountryById(id);
          existCountry.setName(country.getName());
          existCountry.setCountryCapital(country.getCountryCapital());
         Country updated_country= countryService.updateCountry(existCountry);
         return new ResponseEntity<Country>(updated_country, HttpStatus.OK);

       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.CONFLICT);

       }


    }
    @DeleteMapping("deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable(value = "id") int id){
     return   countryService.deleteCountry(id);
   }

}
