package com.certant.PruebaVTV.service;

import com.certant.PruebaVTV.dto.CarDto;
import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    DriverService driverService;

    @Override
    public void saveCar(Car car){
        carRepository.save(car);
    }

    @Override
    public void updateCar(CarDto carUpdate){
        Car oldCar = carRepository.findByDomain(carUpdate.getDomain());

        oldCar.setModel(carUpdate.getModel());
        oldCar.setBrand(carUpdate.getBrand());
        oldCar.setOwner(driverService.findByDni(carUpdate.getDni()));
    }

    @Override
    public void deleteCar(Car car){
        carRepository.delete(car);
    }

    @Override
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    @Override
    public List<Car> searchCarsInspectionedLastWeek(){
        return carRepository.searchCarsInspectionedLastWeek();
    }

    @Override
    public Boolean existsByDomain(String domain){
        return carRepository.existsByDomain(domain);
    }

    @Override
    public Car findByDomain(String domain){
        return carRepository.findByDomain(domain);
    }
}
