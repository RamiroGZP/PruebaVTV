package com.certant.PruebaVTV.mapper;

import com.certant.PruebaVTV.dto.CarDto;
import com.certant.PruebaVTV.entity.Car;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-23T15:20:44-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car toEntity(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car car = new Car();

        car.setDomain( carDto.getDomain() );
        car.setBrand( carDto.getBrand() );
        car.setModel( carDto.getModel() );

        return car;
    }

    @Override
    public CarDto toDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setDomain( car.getDomain() );
        carDto.setBrand( car.getBrand() );
        carDto.setModel( car.getModel() );

        return carDto;
    }
}
