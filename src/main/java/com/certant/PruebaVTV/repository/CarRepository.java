package com.certant.PruebaVTV.repository;

import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Boolean existsByDomain(String domain);
    Car findByDomain(String domain);

    @Query(nativeQuery = true,
            value = "SELECT C.* FROM certant_vtv.car C\n" +
                    "LEFT OUTER JOIN certant_vtv.inspection I ON C.id = I.id_car WHERE I.id_car is NOT NULL \n" +
                    "AND I.inspection_date BETWEEN DATE_SUB(now(),INTERVAL 1 WEEK) AND now();\n")
    List<Car> searchCarsInspectionedLastWeek();
}
