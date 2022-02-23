package com.certant.PruebaVTV.service;

import com.certant.PruebaVTV.dto.DriverDto;
import com.certant.PruebaVTV.entity.Driver;
import com.certant.PruebaVTV.mapper.DriverMapper;
import com.certant.PruebaVTV.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Override
    public void saveDriver(Driver driver){
        driverRepository.save(driver);
    }

    @Override
    public void updateDriver(Driver driver){
        Driver update = driverRepository.findByDni(driver.getDni());
        update.setName(driver.getName());
        update.setLastName(driver.getLastName());
    }
    @Override
    public Boolean existsByDni(String dni){
        return driverRepository.existsByDni(dni);
    }

    @Override
    public Driver findByDni(String dni){
        return driverRepository.findByDni(dni);
    }

    @Override
    public List<Driver> getDrivers(){

        return driverRepository.findAll();
    }

    @Override
    public void deleteDriver(int id){
        driverRepository.deleteById(id);
    }
}
