package com.certant.PruebaVTV.service;

import com.certant.PruebaVTV.dto.InspectionDto;
import com.certant.PruebaVTV.dto.UpdateInspectionDto;
import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.entity.Inspection;
import com.certant.PruebaVTV.mapper.InspectionMapper;
import com.certant.PruebaVTV.repository.InspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class InspectionServiceImpl implements InspectionService {

    @Autowired
    InspectionRepository inspectionRepository;

    @Autowired
    InspectionMapper inspectionMapper;

    @Autowired
    InspectorService inspectorService;

    @Autowired
    CarService carService;

    @Override
    public void saveInspection(InspectionDto inspectionDto){
        Inspection newInspection = inspectionMapper.toEntity(inspectionDto);
        Date inspection_date = Calendar.getInstance().getTime();
        //En esta instancia, se demuestra que la fecha de registracion de la inspeccion es automatica, y por ende,
        //la fecha de vencimiento de VTV se genera para el proximo año automaticamente.
        newInspection.setInspection_Date(inspection_date);
        Calendar c = Calendar.getInstance();
        c.setTime(inspection_date);
        c.add(Calendar.DATE, 365);
        inspection_date = c.getTime();
        newInspection.setExpiration_Date(inspection_date);
        //////////////////////////////////////////////////
        newInspection.setInspector(inspectorService.findInspectorById(inspectionDto.getId()));
        newInspection.setCar(carService.findByDomain(inspectionDto.getDomain()));
        inspectionRepository.save(newInspection);
    }

    @Override
    public List<Inspection> getInspections(){
        return inspectionRepository.findAll();
    }

    @Override
    public Boolean existsById(int id){
        return inspectionRepository.existsById(id);
    }

    @Override
    public void updateInspection(UpdateInspectionDto updateInspectionDto){

        Inspection oldInspection = inspectionRepository.findById(updateInspectionDto.getId()).get();

        oldInspection.setCar(carService.findByDomain(updateInspectionDto.getDomain()));
        oldInspection.setInspector(inspectorService.findInspectorById(updateInspectionDto.getId_inspector()));
        oldInspection.setExempt(updateInspectionDto.getExempt());
        oldInspection.setStatus_inspection(updateInspectionDto.getStatus_inspection());
    }

    @Override
    public void deleteInspectionById(int id){
        inspectionRepository.deleteById(id);
    }

    @Override
    public List<Car> getCarsWithStatus(int id){
        Set<Inspection> inspections = inspectionRepository.getCarsWithStatus(id);
        List<Car> listCars = new ArrayList<>();

        for (Inspection i: inspections){
            listCars.add(i.getCar());
        }

        return listCars;
    }


}
