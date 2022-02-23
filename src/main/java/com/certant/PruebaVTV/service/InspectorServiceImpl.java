package com.certant.PruebaVTV.service;

import com.certant.PruebaVTV.dto.UpdateInspectorDto;
import com.certant.PruebaVTV.dto.ViewInspectorDto;
import com.certant.PruebaVTV.entity.Inspector;
import com.certant.PruebaVTV.mapper.InspectorMapper;
import com.certant.PruebaVTV.repository.InspectionRepository;
import com.certant.PruebaVTV.repository.InspectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class InspectorServiceImpl implements InspectorService {

    @Autowired
    InspectorRepository inspectorRepository;

    @Autowired
    InspectionRepository inspectionRepository;

    @Autowired
    InspectorMapper inspectorMapper;


    @Override
    public void saveInspector(Inspector inspector){
        inspectorRepository.save(inspector);
    }
    @Override
    public void updateInspector(UpdateInspectorDto updateInspectorDto){
        Inspector inspector = inspectorRepository.findById(updateInspectorDto.getId()).get();
        inspector.setName(updateInspectorDto.getName());
        inspector.setLastName(updateInspectorDto.getLastName());
    }
    @Override
    public void deleteInspectorById(int id){
        inspectorRepository.deleteById(id);
    }
    @Override
    public Boolean existsById(int id){
        return inspectorRepository.existsById(id);
    }

    @Override
    public List<Inspector> getInspectors(){
        return inspectorRepository.findAll();
    }

    @Override
    public Inspector findInspectorById(int id){
        return inspectorRepository.findById(id).get();
    }
    @Override
    public List<ViewInspectorDto> getInspectorsWithInspectionsLastThreeDays(){
        List<Inspector> inspectorList = inspectorRepository.findAll();

        for(Inspector i :inspectorList) {
            i.setInspections(inspectionRepository.searchInspectionsLastThreeDaysById(i.getId()));

        }

        return inspectorMapper.toViewDtoList(inspectorList);
    }


}
