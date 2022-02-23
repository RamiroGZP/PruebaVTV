package com.certant.PruebaVTV.controller;

import com.certant.PruebaVTV.dto.DeleteDriverDto;
import com.certant.PruebaVTV.dto.DriverDto;
import com.certant.PruebaVTV.dto.DriverUpdateDto;
import com.certant.PruebaVTV.dto.MensajeDto;
import com.certant.PruebaVTV.entity.Driver;
import com.certant.PruebaVTV.mapper.DriverMapper;
import com.certant.PruebaVTV.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    DriverMapper driverMapper;


    //Registra un conductor en el sistema con los datos ingresados.
    @PostMapping
    public ResponseEntity<?> saveDriver(@Valid @RequestBody DriverDto newDriver, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity(new MensajeDto("Campos mal puestos"), HttpStatus.BAD_GATEWAY);
        }
        if(driverService.existsByDni(newDriver.getDni())){
            return new ResponseEntity(new MensajeDto("El Conductor ya se encuentra ingresado."), HttpStatus.BAD_GATEWAY);
        }
        driverService.saveDriver(driverMapper.toEntity(newDriver));
        return new ResponseEntity((new MensajeDto("Conductor ingresado con exito!")),HttpStatus.OK);

    }

    //Devuelve un listado total de los conductores registrados en el sistema.
    @GetMapping
    public List<Driver> getDrivers(){
        return driverService.getDrivers();
    }

    //Permite editar los datos de un conductor que se encuentre registrado en el sistema.
    @PutMapping
    public ResponseEntity<?> updateDriver(@Valid @RequestBody DriverDto driverUpdate, BindingResult bindingResult){

        if(driverService.existsByDni(driverUpdate.getDni())){
            driverService.updateDriver(driverMapper.toEntity(driverUpdate));
            return new ResponseEntity<>(new MensajeDto("El Conductor ha sido modificado."), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new MensajeDto("Conductor no encontrado."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //Elimina del sistema el conductor mencionado.
    @DeleteMapping()
    public ResponseEntity<?> deleteDriver(@Valid @RequestBody DeleteDriverDto deleteDriverDto, BindingResult bindingResult){

        if(driverService.existsByDni(deleteDriverDto.getDni())){
            Driver deleteDriver = driverService.findByDni(deleteDriverDto.getDni());
            driverService.deleteDriver(deleteDriver.getId());

            return new ResponseEntity<>(new MensajeDto("El Conductor ha sido eliminado."), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new MensajeDto("Conductor no encontrado."), HttpStatus.BAD_REQUEST);
        }

    }
}
