package com.certant.PruebaVTV.mapper;

import com.certant.PruebaVTV.dto.DriverDto;
import com.certant.PruebaVTV.entity.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    Driver toEntity(DriverDto driverDto);
    DriverDto toDto(Driver driver);
}
