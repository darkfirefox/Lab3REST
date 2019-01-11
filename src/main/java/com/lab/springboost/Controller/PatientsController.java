package com.lab.springboost.Controller;

import com.lab.springboost.DAO.PatientsDAO;
import com.lab.springboost.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return  model;
    }

    @RequestMapping(value = "/patients/remove", method = RequestMethod.DELETE)
    public ModelAndView removePatient(@ModelAttribute PatientEntity patient) {
        ModelAndView model = new ModelAndView();
        model.setViewName("patients");
        patientsDAO.removePatient(patient);
        model.addObject("patients",patientsDAO.allPatients());
        return  model;
    }

    @RequestMapping(value = "/patients/edit", method = RequestMethod.POST)
    public ModelAndView editPatient(@ModelAttribute PatientEntity patient) {
        ModelAndView model = new ModelAndView();
        model.setViewName("patients");
        patientsDAO.editPatient(patient);
        model.addObject("patients",patientsDAO.allPatients());
        return  model;
    }

    @RequestMapping(value = "/patients/add", method = RequestMethod.PUT)
    public ModelAndView addPatient(@ModelAttribute PatientEntity patient) {
        ModelAndView model = new ModelAndView();
        model.setViewName("patients");
        patientsDAO.addPatient(patient);
        model.addObject("patients",patientsDAO.allPatients());
        return  model;
    }

    @RequestMapping(value = "/patients/openAdd", method = RequestMethod.GET)
    public ModelAndView openAddDialog() {
        ModelAndView model = new ModelAndView();
        PatientEntity newPatient = new PatientEntity();
        model.addObject("newPatient",newPatient);
        model.addObject("renderAdd", true);
        return  model;
    }

    @RequestMapping(value = "/patients/openEdit", method = RequestMethod.POST)
    public ModelAndView openEditDialog(@ModelAttribute PatientEntity patient) {
        ModelAndView model = new ModelAndView();
        model.setViewName("patients");
        model.addObject("editablePatients",patient);
        model.addObject("renderEdit", true);
        return  model;
    }
}
