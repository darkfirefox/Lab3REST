package com.lab.springboost.Repository;

import com.lab.springboost.entity.DoctorEntity;
import com.lab.springboost.entity.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PrescriptionsRepository  extends CrudRepository<PrescriptionEntity, Long> {
    void deleteById(Integer id);
    Integer countByDoctorByIddoctor_Id(Integer id);
}
