package com.lab.springboost.Controller;

import com.lab.springboost.DAO.DoctorsDAO;
import com.lab.springboost.DAO.PatientsDAO;
import com.lab.springboost.DAO.PrescriptionDAO;
import com.lab.springboost.common.Priority;
import com.lab.springboost.entity.PrescriptionEntity;
import com.lab.springboost.model.PrescriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Controller
public class PrescriptionController {
    @Autowired
    private PatientsDAO patientsDAO;
    @Autowired
    private DoctorsDAO doctorsDAO;
    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @RequestMapping(value = "/prescriptions", method = RequestMethod.GET)
    public ModelAndView patients() {
        ModelAndView model = new ModelAndView();
        model.setViewName("prescriptions");
        model.addObject("patients",patientsDAO.allPatients());
        model.addObject("doctors",doctorsDAO.allDoctors());
        model.addObject("prescriptions",prescriptionDAO.allPrescription());
        model.addObject("priorities", Priority.getPriorities());
        model.addObject("crudPrescription", new PrescriptionModel());
        model.addObject("filter", new PrescriptionModel());
        return  model;
    }

    @RequestMapping(value = "/prescriptions/remove", method = RequestMethod.POST)
    public String removePatient(@ModelAttribute PrescriptionModel patient) {
        prescriptionDAO.removePrescription(patient);
        return  "redirect:/prescriptions";
    }

    @RequestMapping(value = "/prescriptions/edit", method = RequestMethod.POST)
    public String editPatient(@ModelAttribute PrescriptionModel patient) {
        prescriptionDAO.editPrescription(patient);
        return  "redirect:/prescriptions";
    }

    @RequestMapping(value = "/prescriptions/add", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute PrescriptionModel patient) {
        patient.datetime = LocalDateTime.now();
        prescriptionDAO.addPrescription(patient);
        return  "redirect:/prescriptions";
    }
}
