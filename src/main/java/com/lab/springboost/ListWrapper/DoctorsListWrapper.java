package com.lab.springboost.ListWrapper;

import com.lab.springboost.entity.DoctorEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "doctors")
public class DoctorsListWrapper {
    private List<DoctorEntity> doctors;

    public DoctorsListWrapper() {
    }

    public DoctorsListWrapper(List<DoctorEntity> doctors) {
        this.doctors = doctors;
    }
    @XmlElement(name = "doctor")
    public List<DoctorEntity> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorEntity> doctors) {
        this.doctors = doctors;
    }
}
