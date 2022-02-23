package com.certant.PruebaVTV.mapper;

import com.certant.PruebaVTV.dto.DriverDto;
import com.certant.PruebaVTV.entity.Driver;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-23T15:20:44-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class DriverMapperImpl implements DriverMapper {

    @Override
    public Driver toEntity(DriverDto driverDto) {
        if ( driverDto == null ) {
            return null;
        }

        Driver driver = new Driver();

        driver.setName( driverDto.getName() );
        driver.setLastName( driverDto.getLastName() );
        driver.setDni( driverDto.getDni() );

        return driver;
    }

    @Override
    public DriverDto toDto(Driver driver) {
        if ( driver == null ) {
            return null;
        }

        DriverDto driverDto = new DriverDto();

        driverDto.setName( driver.getName() );
        driverDto.setLastName( driver.getLastName() );
        driverDto.setDni( driver.getDni() );

        return driverDto;
    }
}
