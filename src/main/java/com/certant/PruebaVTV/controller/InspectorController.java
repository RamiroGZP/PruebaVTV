package com.certant.PruebaVTV.controller;

import com.certant.PruebaVTV.dto.*;
import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.entity.Inspector;
import com.certant.PruebaVTV.mapper.InspectorMapper;
import com.certant.PruebaVTV.service.InspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inspector")
public class InspectorController {

    @Autowired
    InspectorService inspectorService;

    @Autowired
    InspectorMapper inspectorMapper;

    //Crea registro de inspector en el sistema.
    @PostMapping
    public ResponseEntity<?> saveInspector(@Valid @RequestBody InspectorDto inspector, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity(new MensajeDto("Campos mal puestos"), HttpStatus.BAD_GATEWAY);
        }

        inspectorService.saveInspector(inspectorMapper.toEntity(inspector));
        return new ResponseEntity((new MensajeDto("Inspector ingresado con exito!")),HttpStatus.OK);

    }

    //Devuelve listado de todos los inspectores que se encuentran en el sistema.
    @GetMapping
    public List<Inspector> getInspectors(){
        return inspectorService.getInspectors();
    }

    //Devuelve listado de inspectores que hayan tenido inspecciones durante los ultimos tres dias.
    @GetMapping(value = "/inspectorWithInspections")
    public List<ViewInspectorDto> getInspectorsWithInspectionsLastThreeDays(){
        return inspectorService.getInspectorsWithInspectionsLastThreeDays();
    }

    //Permite editar los datos de un Inspector de planta que se encuentre ingresado en el sistema.
    @PutMapping
    public ResponseEntity<?> updateInspector(@Valid @RequestBody UpdateInspectorDto updateInspectorDto, BindingResult bindingResult){

        if(inspectorService.existsById(updateInspectorDto.getId())){
            inspectorService.updateInspector(updateInspectorDto);
            return new ResponseEntity<>(new MensajeDto("El Inspector ha sido modificado."), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new MensajeDto("Inspector no encontrado."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //Permite eliminar un Inspector registrado en el sistema.
    @DeleteMapping()
    public ResponseEntity<?> deleteInspector(@Valid @RequestBody DeleteInspectorDto deleteInspectorDto, BindingResult bindingResult){

        if(inspectorService.existsById(deleteInspectorDto.getId())){
            inspectorService.deleteInspectorById(deleteInspectorDto.getId());
            return new ResponseEntity<>(new MensajeDto("El Inspector ha sido eliminado."), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new MensajeDto("Inspector no encontrado."), HttpStatus.BAD_REQUEST);
        }

    }
}
