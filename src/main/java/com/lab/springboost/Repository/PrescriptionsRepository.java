package com.lab.springboost.Repository;

import com.lab.springboost.entity.PrescriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionsRepository  extends CrudRepository<PrescriptionEntity, Long> {
}
