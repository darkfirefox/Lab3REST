package com.lab.springboost.Service;

import com.google.common.collect.Lists;
import com.lab.springboost.DAO.PatientsDAO;
import com.lab.springboost.Repository.PatientsRepository;
import com.lab.springboost.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientsService implements PatientsDAO {
    @Autowired
    private PatientsRepository patientsRepository;

    @Override
    public void addPatient(PatientEntity patient) {
        patientsRepository.save(patient);
    }

    @Override
    public void removePatient(PatientEntity patient) {
        patientsRepository.delete(patient);
    }

    @Override
    public void editPatient(PatientEntity patient) {
        patientsRepository.save(patient);
    }

    @Override
    public PatientEntity findById(Integer id) {
        return  patientsRepository.findById(id);
    }

    @Override
    public List<PatientEntity> allPatients() {
        return Lists.newArrayList(patientsRepository.findAll());
    }
}
