package com.lab.springboost.Service;

import com.google.common.collect.Lists;
import com.lab.springboost.DAO.DoctorsDAO;
import com.lab.springboost.Repository.DoctorsRepository;
import com.lab.springboost.entity.DoctorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorsService implements DoctorsDAO {
    @Autowired
    private DoctorsRepository doctorsRepository;

    @Override
    public void addDoctor(DoctorEntity doctor) {
        doctorsRepository.save(doctor);
    }

    @Override
    public void removeDoctor(DoctorEntity doctor) {
        doctorsRepository.delete(doctor);
    }

    @Override
    public void editDoctor(DoctorEntity doctor) {
        doctorsRepository.save(doctor);
    }

    @Override
    public int prescriptionOfDoctor(DoctorEntity doctor) {
        //To-do
        return 0;
    }

    @Override
    public List<DoctorEntity> allDoctors() {
        return Lists.newArrayList(doctorsRepository.findAll());
    }
}
