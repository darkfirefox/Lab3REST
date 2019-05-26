package com.lab.springboost.RestController;

import com.lab.springboost.DAO.PatientsDAO;
import com.lab.springboost.ListWrapper.PatientsListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/rest/api")
public class PatientsRestController {
    @Autowired
    private PatientsDAO patientsDAO;

    @RequestMapping(value="/patients",
            method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE,
                         APPLICATION_XML_VALUE } )
    public PatientsListWrapper patients() {
        return new PatientsListWrapper(patientsDAO.allPatients());
    }
}
