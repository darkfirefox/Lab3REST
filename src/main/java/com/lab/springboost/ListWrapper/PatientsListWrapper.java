package com.lab.springboost.ListWrapper;

import com.lab.springboost.entity.PatientEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "patients")
public class PatientsListWrapper {
    private List<PatientEntity> patinets;

    public PatientsListWrapper() {
    }

    public PatientsListWrapper(List<PatientEntity> patinets) {
        this.patinets = patinets;
    }


    public List<PatientEntity> getPatinets() {
        return patinets;
    }

    public void setPatinets(List<PatientEntity> patinets) {
        this.patinets = patinets;
    }
}
