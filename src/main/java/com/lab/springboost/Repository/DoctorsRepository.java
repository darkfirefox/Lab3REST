package com.lab.springboost.Repository;

import com.lab.springboost.entity.DoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends CrudRepository<DoctorEntity, Long> {
}
