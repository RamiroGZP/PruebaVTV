package com.certant.PruebaVTV.repository;


import com.certant.PruebaVTV.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM certant_vtv.inspection WHERE id_inspector = :id " +
                    "AND inspection_date BETWEEN DATE_SUB(now(),INTERVAL 3 DAY) AND now();")
    Set<Inspection> searchInspectionsLastThreeDaysById(@Param("id")int id);

    @Query(nativeQuery = true,
            value = "SELECT DISTINCT * \n" +
                    "FROM certant_vtv.car C JOIN certant_vtv.inspection I ON C.id = I.id_car\n" +
                    "WHERE I.status_inspection = :id")
    Set<Inspection> getCarsWithStatus(@Param("id")int id);

}
