package com.lab.springboost.Service;

import com.google.common.collect.Lists;
import com.lab.springboost.Converter.ConverterModelEntity;
import com.lab.springboost.DAO.PrescriptionDAO;
import com.lab.springboost.Repository.PrescriptionsRepository;
import com.lab.springboost.entity.PrescriptionEntity;
import com.lab.springboost.model.PrescriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionService implements PrescriptionDAO {
    @Autowired
    private PrescriptionsRepository prescriptionsRepository;
    @Autowired
    private ConverterModelEntity<PrescriptionModel, PrescriptionEntity> converterModelEntity;

    @Override
    public void addPrescription(PrescriptionModel prescription) {
        prescriptionsRepository.save(converterModelEntity.toEntity(prescription));
    }

    @Override
    public void removePrescription(PrescriptionModel prescription) {
        prescriptionsRepository.deleteById(prescription.id);
    }

    @Override
    public void editPrescription(PrescriptionModel prescription) {
        prescriptionsRepository.save(converterModelEntity.toEntity(prescription));
    }

    @Override
    public List<PrescriptionEntity> allPrescription() {
        return Lists.newArrayList(prescriptionsRepository.findAll());
    }

    @Override
    public List<PrescriptionEntity> filtered(PrescriptionModel prescription) {
        return null;
    }

}
