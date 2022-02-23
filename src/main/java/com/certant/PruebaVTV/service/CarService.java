package com.certant.PruebaVTV.service;

import com.certant.PruebaVTV.dto.CarDto;
import com.certant.PruebaVTV.entity.Car;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CarService {

    void saveCar(Car car);
    void updateCar(CarDto carUpdate);
    void deleteCar(Car car);
    List<Car> getCars();
    List<Car> searchCarsInspectionedLastWeek();
    Boolean existsByDomain(String domain);
    Car findByDomain(String domain);
}
