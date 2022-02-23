package com.certant.PruebaVTV.mapper;

import com.certant.PruebaVTV.dto.InspectionDto;
import com.certant.PruebaVTV.dto.ViewInspectionDto;
import com.certant.PruebaVTV.entity.Inspection;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface InspectionMapper {

    Inspection toEntity(InspectionDto inspectionDto);
    InspectionDto toDto(Inspection inspection);
    ViewInspectionDto toViewInspectionDto (Inspection inspection);


    default List<ViewInspectionDto> toViewDtoList(List<Inspection> inspections){
        if(inspections == null){
            return new ArrayList<>();
        }
        return inspections.stream().map(this::toViewInspectionDto).collect(Collectors.toList());
    }
}
