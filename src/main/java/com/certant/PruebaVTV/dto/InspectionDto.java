package com.certant.PruebaVTV.dto;

import com.certant.PruebaVTV.enums.Status;

import java.util.Date;

public class InspectionDto {

    private Status status_inspection;
    private Boolean isExempt;
    private int id;
    private String domain;

    public InspectionDto() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
