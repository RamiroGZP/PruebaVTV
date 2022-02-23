package com.certant.PruebaVTV.mapper;

import com.certant.PruebaVTV.dto.InspectorDto;
import com.certant.PruebaVTV.dto.ViewInspectionDto;
import com.certant.PruebaVTV.dto.ViewInspectorDto;
import com.certant.PruebaVTV.entity.Inspection;
import com.certant.PruebaVTV.entity.Inspector;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface InspectorMapper {

    Inspector toEntity(InspectorDto inspectorDto);
    InspectorDto toDto(Inspector inspector);
    ViewInspectorDto toViewDto (Inspector inspector);


    default List<ViewInspectorDto> toViewDtoList(List<Inspector> inspectors){
        if(inspectors == null){
            return new ArrayList<>();
        }
        return inspectors.stream().map(this::toViewDto).collect(Collectors.toList());
    }
}
