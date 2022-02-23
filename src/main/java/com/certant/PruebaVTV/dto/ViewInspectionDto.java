package com.certant.PruebaVTV.dto;

import com.certant.PruebaVTV.entity.Car;
import com.certant.PruebaVTV.entity.Inspector;
import com.certant.PruebaVTV.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ViewInspectionDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspection_Date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiration_Date;
    private Status status_inspection;
    private Boolean isExempt;
    private InspectorDto inspector;
    private Car car;

    public ViewInspectionDto() {
    }

    public Date getInspection_Date() {
        return inspection_Date;
    }

    public void setInspection_Date(Date inspection_Date) {
        this.inspection_Date = inspection_Date;
    }

    public Date getExpiration_Date() {
        return expiration_Date;
    }

    public void setExpiration_Date(Date expiration_Date) {
        this.expiration_Date = expiration_Date;
    }

    public Status getStatus_inspection() {
        return status_inspection;
    }

    public void setStatus_inspection(Status status_inspection) {
        this.status_inspection = status_inspection;
    }

    public Boolean getExempt() {
        return isExempt;
    }

    public void setExempt(Boolean exempt) {
        isExempt = exempt;
    }

    public InspectorDto getInspector() {
        return inspector;
    }

    public void setInspector(InspectorDto inspector) {
        this.inspector = inspector;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
