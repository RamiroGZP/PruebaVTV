package com.certant.PruebaVTV.service;

import com.certant.PruebaVTV.entity.Driver;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public interface DriverService {

    void saveDriver(Driver driver);
    void updateDriver(Driver driver);
    Boolean existsByDni(String dni);
    Driver findByDni(String dni);
    List<Driver> getDrivers();
    void deleteDriver(int id);

}
