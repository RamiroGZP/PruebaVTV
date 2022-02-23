package com.certant.PruebaVTV.mapper;

import com.certant.PruebaVTV.dto.InspectorDto;
import com.certant.PruebaVTV.dto.ViewInspectionDto;
import com.certant.PruebaVTV.dto.ViewInspectorDto;
import com.certant.PruebaVTV.entity.Inspection;
import com.certant.PruebaVTV.entity.Inspector;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-23T15:20:43-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class InspectorMapperImpl implements InspectorMapper {

    @Override
    public Inspector toEntity(InspectorDto inspectorDto) {
        if ( inspectorDto == null ) {
            return null;
        }

        Inspector inspector = new Inspector();

        inspector.setName( inspectorDto.getName() );
        inspector.setLastName( inspectorDto.getLastName() );

        return inspector;
    }

    @Override
    public InspectorDto toDto(Inspector inspector) {
        if ( inspector == null ) {
            return null;
        }

        InspectorDto inspectorDto = new InspectorDto();

        inspectorDto.setName( inspector.getName() );
        inspectorDto.setLastName( inspector.getLastName() );

        return inspectorDto;
    }

    @Override
    public ViewInspectorDto toViewDto(Inspector inspector) {
        if ( inspector == null ) {
            return null;
        }

        ViewInspectorDto viewInspectorDto = new ViewInspectorDto();

        viewInspectorDto.setId( inspector.getId() );
        viewInspectorDto.setName( inspector.getName() );
        viewInspectorDto.setLastName( inspector.getLastName() );
        viewInspectorDto.setInspections( inspectionSetToViewInspectionDtoSet( inspector.getInspections() ) );

        return viewInspectorDto;
    }

    protected ViewInspectionDto inspectionToViewInspectionDto(Inspection inspection) {
        if ( inspection == null ) {
            return null;
        }

        ViewInspectionDto viewInspectionDto = new ViewInspectionDto();

        viewInspectionDto.setInspection_Date( inspection.getInspection_Date() );
        viewInspectionDto.setExpiration_Date( inspection.getExpiration_Date() );
        viewInspectionDto.setStatus_inspection( inspection.getStatus_inspection() );
        viewInspectionDto.setExempt( inspection.getExempt() );
        viewInspectionDto.setInspector( toDto( inspection.getInspector() ) );
        viewInspectionDto.setCar( inspection.getCar() );

        return viewInspectionDto;
    }

    protected Set<ViewInspectionDto> inspectionSetToViewInspectionDtoSet(Set<Inspection> set) {
        if ( set == null ) {
            return null;
        }

        Set<ViewInspectionDto> set1 = new HashSet<ViewInspectionDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Inspection inspection : set ) {
            set1.add( inspectionToViewInspectionDto( inspection ) );
        }

        return set1;
    }
}
