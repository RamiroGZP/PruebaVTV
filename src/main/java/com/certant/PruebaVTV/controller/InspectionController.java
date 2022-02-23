package com.certant.PruebaVTV.controller;

import com.certant.PruebaVTV.dto.*;
import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.entity.Inspection;
import com.certant.PruebaVTV.mapper.InspectionMapper;
import com.certant.PruebaVTV.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/inspection")
public class InspectionController {

    @Autowired
    InspectionService inspectionService;

    @Autowired
    InspectionMapper inspectionMapper;


    // Registra una inspeccion en el sistema con los datos ingresados.
    @PostMapping
    public ResponseEntity<?> saveInspection(@Valid @RequestBody InspectionDto inspectionDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity(new MensajeDto("Campos mal puestos"), HttpStatus.BAD_GATEWAY);
        }
        inspectionService.saveInspection(inspectionDto);
        return new ResponseEntity((new MensajeDto("Inspector ingresado con exito!")),HttpStatus.OK);

    }

    //Devuelve un listado de todas las inspecciones en el sistema.
    @GetMapping()
    public List<ViewInspectionDto> getInspections(){
        return inspectionMapper.toViewDtoList(inspectionService.getInspections());
    }

    //Permite editar inspecciones que se encuentren registradas en el sistema.
    @PutMapping()
    public ResponseEntity<?> updateInspection(@Valid @RequestBody UpdateInspectionDto updateInspectionDto, BindingResult bindingResult){

        if(inspectionService.existsById(updateInspectionDto.getId())){
            inspectionService.updateInspection(updateInspectionDto);
            return new ResponseEntity<>(new MensajeDto("La Inspeccion ha sido modificada"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new MensajeDto("Inspeccion no encontrada"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //Elimina inspecciones que se encuentren registradas en el sistema.
    @DeleteMapping()
    public ResponseEntity<?> deleteInspection(@Valid @RequestBody DeleteInspectionDto deleteInspectionDto, BindingResult bindingResult){

        if(inspectionService.existsById(deleteInspectionDto.getId())){
            inspectionService.deleteInspectionById(deleteInspectionDto.getId());
            return new ResponseEntity<>(new MensajeDto("La Inspeccion ha sido eliminada."), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new MensajeDto("Inspeccion no encontrada."), HttpStatus.BAD_REQUEST);
        }

    }

    //Devuelve un listado de autos asignados como APTOS.
    @GetMapping(value = "/getCarsWithStatusAPTO")
    public List<Car> getCarsWithStatusAPTO(){
        return inspectionService.getCarsWithStatus(0);
    }

    //Devuelve un listado de autos asignados como CONDICIONALES.
    @GetMapping(value = "/getCarsWithStatusCONDITIONAL")
    public List<Car> getCarsWithStatusCONDITIONAL(){
        return inspectionService.getCarsWithStatus(1);
    }

    //Devuelve un listado de autos asignados como RECHAZADOS.
    @GetMapping(value = "/getCarsWithStatusRECHAZADO")
    public List<Car> getCarsWithStatusRECHAZADO(){
        return inspectionService.getCarsWithStatus(2);
    }

}
