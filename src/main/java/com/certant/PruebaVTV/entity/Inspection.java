package com.certant.PruebaVTV.entity;

import com.certant.PruebaVTV.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inspection")
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inspection_Date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiration_Date;
    private Status status_inspection;
    private Boolean isExempt;

    @ManyToOne
    @JoinColumn(name = "id_inspector")
    private Inspector inspector;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    public Inspection() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
