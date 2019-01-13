package com.lab.springboost.Controller;

import com.lab.springboost.DAO.DoctorsDAO;
import com.lab.springboost.Service.NotificationService;
import com.lab.springboost.entity.DoctorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoctorsController {
    @Autowired
    private DoctorsDAO doctorsDAO;
    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public ModelAndView patients() {
        ModelAndView model = new ModelAndView();
        model.setViewName("doctors");
        model.addObject("doctors",doctorsDAO.allDoctors());
        model.addObject("crudDoctor", new DoctorEntity());
        model.addObject("countPrescriptions", 0);
        return  model;
    }

    @RequestMapping(value = "/doctors/remove", method = RequestMethod.POST)
    public String removePatient(@ModelAttribute DoctorEntity doctor) {
        doctorsDAO.removeDoctor(doctor);
        return  "redirect:/doctors";
    }

    @RequestMapping(value = "/doctors/edit", method = RequestMethod.POST)
    public String editPatient(@ModelAttribute DoctorEntity doctor) {
        doctorsDAO.editDoctor(doctor);
        return  "redirect:/doctors";
    }

    @RequestMapping(value = "/doctors/add", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute DoctorEntity doctor) {
        doctorsDAO.addDoctor(doctor);
        return  "redirect:/doctors";
    }

    @RequestMapping(value = "/doctors/count/{id}", method = RequestMethod.GET)
    public String prescriptionsCount(@PathVariable(value = "id") Integer id) {
        notificationService.countPrescription(doctorsDAO.prescriptionOfDoctor(id));
        return  "redirect:/doctors";
    }
}
