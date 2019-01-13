package com.lab.springboost.DAO;

import com.lab.springboost.entity.PrescriptionEntity;
import com.lab.springboost.model.PrescriptionModel;

import java.util.List;

public interface PrescriptionDAO {
    void addPrescription(PrescriptionModel prescription);
    void removePrescription(PrescriptionModel prescription);
    void editPrescription(PrescriptionModel prescription);
    List<PrescriptionEntity> allPrescription();
    List<PrescriptionEntity> filtered(PrescriptionModel prescription);
}
