package com.certant.PruebaVTV.service;

import com.certant.PruebaVTV.dto.InspectionDto;
import com.certant.PruebaVTV.dto.UpdateInspectionDto;
import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.entity.Inspection;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface InspectionService {

    void saveInspection(InspectionDto inspectionDto);
    Boolean existsById(int id);
    List<Inspection> getInspections();
    void updateInspection(UpdateInspectionDto updateInspectionDto);
    void deleteInspectionById(int id);
    List<Car> getCarsWithStatus(int id);


}
