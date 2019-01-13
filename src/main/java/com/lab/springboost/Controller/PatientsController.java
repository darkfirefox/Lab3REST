package com.lab.springboost.Controller;

import com.lab.springboost.DAO.PatientsDAO;
import com.lab.springboost.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PatientsController {
    @Autowired
    private PatientsDAO patientsDAO;

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public ModelAndView patients() {
        ModelAndView model = new ModelAndView();
        model.setViewName("patients");
        model.addObject("patients",patientsDAO.allPatients());
        model.addObject("crudPatient", new PatientEntity());
        return  model;
    }

    @RequestMapping(value = "/patients/remove", method = RequestMethod.POST)
    public String removePatient(@ModelAttribute PatientEntity patient) {
        patientsDAO.removePatient(patient);
        return  "redirect:/patients";
    }

    @RequestMapping(value = "/patients/edit", method = RequestMethod.POST)
    public String editPatient(@ModelAttribute PatientEntity patient) {
        patientsDAO.editPatient(patient);
        return  "redirect:/patients";
    }

    @RequestMapping(value = "/patients/add", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute PatientEntity patient) {
        patientsDAO.addPatient(patient);
        return  "redirect:/patients";
    }
}
