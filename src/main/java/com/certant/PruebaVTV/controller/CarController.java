package com.certant.PruebaVTV.controller;

import com.certant.PruebaVTV.dto.*;
import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.entity.Driver;
import com.certant.PruebaVTV.mapper.CarMapper;
import com.certant.PruebaVTV.service.CarService;
import com.certant.PruebaVTV.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    DriverService driverService;

    @Autowired
    CarMapper carMapper;


    //Registra un vehiculo al sistema con los datos ingresados.
    @PostMapping
    public ResponseEntity<?> saveCar(@Valid @RequestBody CarDto carDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity(new MensajeDto("Campos mal puestos"), HttpStatus.BAD_GATEWAY);
        }
        if(carService.existsByDomain(carDto.getDomain())){
            return new ResponseEntity(new MensajeDto("El vehiculo ya se encuentra ingresado."), HttpStatus.BAD_GATEWAY);
        }
        if(driverService.existsByDni(carDto.getDni())){
            Car newCar = new Car();
            newCar.setBrand(carDto.getBrand());
            newCar.setDomain(carDto.getDomain());
            newCar.setModel(carDto.getModel());
            newCar.setOwner(driverService.findByDni(carDto.getDni()));
            carService.saveCar(newCar);
            return new ResponseEntity((new MensajeDto("Vehiculo ingresado con exito!")),HttpStatus.OK);
        }else{
            return new ResponseEntity(new MensajeDto("El Dni del conductor ingresado no se encuentra registrado."), HttpStatus.BAD_GATEWAY);
        }
    }

    //Devuelve un listado total de los autos registrados en el sistema.
    @GetMapping()
    public List<Car> getCars(){
        return carService.getCars();
    }

    //Devuelve un listado de autos cuya inspeccion haya sido realizada durante la ultima semana.
    @GetMapping(value = "/searchLastWeek")
    public List<Car> searchLastWeek(){
        return carService.searchCarsInspectionedLastWeek();
    }

    //Permite editar los datos de un auto que se encuentre registrado en el sistema.
    @PutMapping
    public ResponseEntity<?> updateCar(@Valid @RequestBody CarDto carUpdate, BindingResult bindingResult){

        if(carService.existsByDomain(carUpdate.getDomain())){
            carService.updateCar(carUpdate);
            return new ResponseEntity<>(new MensajeDto("El vehiculo ha sido modificado."), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new MensajeDto("Vehiculo no encontrado."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //Permite eliminar un auto que se encuentre registrado en el sistema.
    @DeleteMapping()
    public ResponseEntity<?> deleteCar(@Valid @RequestBody DeleteCarDto deleteCarDto, BindingResult bindingResult){

        if(carService.existsByDomain(deleteCarDto.getDomain())){
            Car deleteCar = carService.findByDomain(deleteCarDto.getDomain());
            carService.deleteCar(deleteCar);

            return new ResponseEntity<>(new MensajeDto("El vehiculo ha sido eliminado."), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new MensajeDto("Vehiculo no encontrado."), HttpStatus.BAD_REQUEST);
        }

    }
}
