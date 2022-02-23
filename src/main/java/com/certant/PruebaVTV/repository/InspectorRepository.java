package com.certant.PruebaVTV.repository;

import com.certant.PruebaVTV.entity.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InspectorRepository extends JpaRepository<Inspector, Integer> {

    Boolean existsById(int id);

}
