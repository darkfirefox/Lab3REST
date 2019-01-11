package com.lab.springboost.DAO;

import com.lab.springboost.entity.DoctorEntity;

import java.util.List;

public interface DoctorsDAO {
    void addDoctor(DoctorEntity doctor);
    void removeDoctor(DoctorEntity doctor);
    void editDoctor(DoctorEntity doctor);
    int prescriptionOfDoctor(DoctorEntity doctor);
    List<DoctorEntity> allDoctors();
}
