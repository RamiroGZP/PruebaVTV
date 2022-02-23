package com.certant.PruebaVTV.service;

import com.certant.PruebaVTV.dto.UpdateInspectorDto;
import com.certant.PruebaVTV.dto.ViewInspectorDto;
import com.certant.PruebaVTV.entity.Inspector;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface InspectorService {

    void saveInspector(Inspector inspector);
    void updateInspector(UpdateInspectorDto updateInspectorDto);
    void deleteInspectorById(int id);
    Boolean existsById(int id);
    List<Inspector> getInspectors();
    Inspector findInspectorById(int id);
    List<ViewInspectorDto> getInspectorsWithInspectionsLastThreeDays();

}
