package com.certant.PruebaVTV.mapper;

import com.certant.PruebaVTV.dto.CarDto;
import com.certant.PruebaVTV.dto.DriverDto;
import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.entity.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car toEntity(CarDto carDto);
    CarDto toDto(Car car);

}
