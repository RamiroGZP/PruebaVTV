package com.certant.PruebaVTV.dto;

import com.certant.PruebaVTV.enums.Status;

public class UpdateInspectionDto {

    private int id;
    private Status status_inspection;
    private Boolean isExempt;
    private int id_inspector;
    private String domain;

    public UpdateInspectionDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_inspector() {
        return id_inspector;
    }

    public void setId_inspector(int id_inspector) {
        this.id_inspector = id_inspector;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
