package com.lab.springboost.Service;

import com.google.common.collect.Lists;
import com.lab.springboost.DAO.PrescriptionDAO;
import com.lab.springboost.Repository.PrescriptionsRepository;
import com.lab.springboost.entity.PrescriptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionService implements PrescriptionDAO {
    @Autowired
    private PrescriptionsRepository prescriptionsRepository;

    @Override
    public void addPrescription(PrescriptionEntity prescription) {
        prescriptionsRepository.save(prescription);
    }

    @Override
    public void removePrescription(PrescriptionEntity prescription) {
        prescriptionsRepository.delete(prescription);
    }

    @Override
    public void editPrescription(PrescriptionEntity prescription) {
        prescriptionsRepository.save(prescription);
    }

    @Override
    public List<PrescriptionEntity> allPrescription(PrescriptionEntity prescription) {
        return Lists.newArrayList(prescriptionsRepository.findAll());
    }
}
