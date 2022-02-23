package com.certant.PruebaVTV.repository;

import com.certant.PruebaVTV.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Boolean existsByDni(String dni);
    Driver findByDni(String dni);
}
