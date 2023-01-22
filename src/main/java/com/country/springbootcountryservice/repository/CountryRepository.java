package com.country.springbootcountryservice.repository;

import com.country.springbootcountryservice.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
