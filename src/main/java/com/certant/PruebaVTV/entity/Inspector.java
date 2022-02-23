package com.certant.PruebaVTV.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "inspector")
public class Inspector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    private String name;
    private String lastName;

    @OneToMany(mappedBy = "inspector")
    private Set<Inspection> inspections;

    public Inspector() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public Set<Inspection> getInspections() {
        return inspections;
    }

    public void setInspections(Set<Inspection> inspections) {
        this.inspections = inspections;
    }
}
