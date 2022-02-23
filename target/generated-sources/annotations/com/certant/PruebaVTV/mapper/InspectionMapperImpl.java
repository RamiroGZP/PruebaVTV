package com.certant.PruebaVTV.mapper;

import com.certant.PruebaVTV.dto.InspectionDto;
import com.certant.PruebaVTV.dto.InspectorDto;
import com.certant.PruebaVTV.dto.ViewInspectionDto;
import com.certant.PruebaVTV.entity.Inspection;
import com.certant.PruebaVTV.entity.Inspector;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-23T17:09:47-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class InspectionMapperImpl implements InspectionMapper {

    @Override
    public Inspection toEntity(InspectionDto inspectionDto) {
        if ( inspectionDto == null ) {
            return null;
        }

        Inspection inspection = new Inspection();

        inspection.setId( inspectionDto.getId() );
        inspection.setStatus_inspection( inspectionDto.getStatus_inspection() );
        inspection.setExempt( inspectionDto.getExempt() );

        return inspection;
    }

    @Override
    public InspectionDto toDto(Inspection inspection) {
        if ( inspection == null ) {
            return null;
        }

        InspectionDto inspectionDto = new InspectionDto();

        inspectionDto.setStatus_inspection( inspection.getStatus_inspection() );
        inspectionDto.setExempt( inspection.getExempt() );
        inspectionDto.setId( inspection.getId() );

        return inspectionDto;
    }

    @Override
    public ViewInspectionDto toViewInspectionDto(Inspection inspection) {
        if ( inspection == null ) {
            return null;
        }

        ViewInspectionDto viewInspectionDto = new ViewInspectionDto();

        viewInspectionDto.setInspection_Date( inspection.getInspection_Date() );
        viewInspectionDto.setExpiration_Date( inspection.getExpiration_Date() );
        viewInspectionDto.setStatus_inspection( inspection.getStatus_inspection() );
        viewInspectionDto.setExempt( inspection.getExempt() );
        viewInspectionDto.setInspector( inspectorToInspectorDto( inspection.getInspector() ) );
        viewInspectionDto.setCar( inspection.getCar() );

        return viewInspectionDto;
    }

    protected InspectorDto inspectorToInspectorDto(Inspector inspector) {
        if ( inspector == null ) {
            return null;
        }

        InspectorDto inspectorDto = new InspectorDto();

        inspectorDto.setName( inspector.getName() );
        inspectorDto.setLastName( inspector.getLastName() );

        return inspectorDto;
    }
}
