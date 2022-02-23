package com.certant.PruebaVTV.dto;

import com.certant.PruebaVTV.entity.Inspection;

import java.util.List;
import java.util.Set;

public class ViewInspectorDto {

    private int id;
    private String name;
    private String lastName;
    private Set<ViewInspectionDto> inspections;

    public ViewInspectorDto() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ViewInspectionDto> getInspections() {
        return inspections;
    }

    public void setInspections(Set<ViewInspectionDto> inspections) {
        this.inspections = inspections;
    }
}
