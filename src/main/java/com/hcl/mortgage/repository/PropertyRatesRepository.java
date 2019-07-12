package com.hcl.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.PropertyRates;

/**
 * PropertyRatesRepository interface represent the property_rates table repository
 * @author amol.jadhav
 */
@Repository
public interface PropertyRatesRepository extends JpaRepository<PropertyRates, Integer>{

}
