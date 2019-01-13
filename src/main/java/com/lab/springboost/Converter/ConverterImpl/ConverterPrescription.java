package com.lab.springboost.Converter.ConverterImpl;

import com.lab.springboost.Converter.ConverterModelEntity;
import com.lab.springboost.DAO.DoctorsDAO;
import com.lab.springboost.DAO.PatientsDAO;
import com.lab.springboost.entity.DoctorEntity;
import com.lab.springboost.entity.PatientEntity;
import com.lab.springboost.entity.PrescriptionEntity;
import com.lab.springboost.model.PrescriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ConverterPrescription implements ConverterModelEntity<PrescriptionModel, PrescriptionEntity> {
    @Autowired
    private PatientsDAO patientsDAO;
    @Autowired
    private DoctorsDAO doctorsDAO;

    @Override
    public PrescriptionEntity toEntity(PrescriptionModel model) {
        PrescriptionEntity entity = new PrescriptionEntity();
        DoctorEntity doctor = doctorsDAO.findById(model.doctorByIddoctor);
        PatientEntity patient = patientsDAO.findById(model.patientByIdpatient);
        entity.setId(model.id);
        entity.setDoctorByIddoctor(doctor);
        entity.setPatientByIdpatient(patient);
        entity.setDatetime(Timestamp.valueOf(model.datetime));
        entity.setDescription(model.description);
        entity.setPriority(model.priority);
        return entity;
    }

    @Override
    public PrescriptionModel toModel(PrescriptionEntity entity) {
        PrescriptionModel model = new PrescriptionModel();
        model.id = entity.getId();
        model.doctorByIddoctor = entity.getDoctorByIddoctor().getId();
        model.patientByIdpatient = entity.getPatientByIdpatient().getId();
        model.description = entity.getDescription();
        model.datetime = entity.getDatetime().toLocalDateTime();
        model.priority = entity.getPriority();
        return model;
    }
}
