package com.lab.springboost.ListWrapper;

import com.lab.springboost.entity.PrescriptionEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "prescriptions")
public class PrescriptionsListWrapper {
    public PrescriptionsListWrapper() {
    }

    private List<PrescriptionEntity> prescriptions;

    public PrescriptionsListWrapper(List<PrescriptionEntity> prescriptions) {
        this.prescriptions = prescriptions;
    }
    @XmlElement(name = "prescription")
    public List<PrescriptionEntity> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<PrescriptionEntity> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
