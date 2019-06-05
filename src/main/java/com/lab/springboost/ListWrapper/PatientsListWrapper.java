package com.lab.springboost.ListWrapper;

import com.lab.springboost.entity.PatientEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "patients")
public class PatientsListWrapper {
    private List<PatientEntity> patients;

    public PatientsListWrapper() {
    }

    public PatientsListWrapper(List<PatientEntity> patients) {
        this.patients = patients;
    }

    @XmlElement(name = "patient")
    public List<PatientEntity> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientEntity> patinets) {
        this.patients = patinets;
    }
}
