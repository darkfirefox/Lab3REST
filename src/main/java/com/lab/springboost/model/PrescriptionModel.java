package com.lab.springboost.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrescriptionModel {
    public Integer id;
    public LocalDateTime datetime;
    public String description;
    public String priority;
    public Integer doctorByIddoctor;
    public Integer patientByIdpatient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = LocalDateTime.parse(datetime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getDoctorByIddoctor() {
        return doctorByIddoctor;
    }

    public void setDoctorByIddoctor(Integer doctorByIddoctor) {
        this.doctorByIddoctor = doctorByIddoctor;
    }

    public Integer getPatientByIdpatient() {
        return patientByIdpatient;
    }

    public void setPatientByIdpatient(Integer patientByIdpatient) {
        this.patientByIdpatient = patientByIdpatient;
    }
}
