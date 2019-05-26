package com.lab.springboost.RestController;

import com.lab.springboost.DAO.PrescriptionDAO;
import com.lab.springboost.ListWrapper.PrescriptionsListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/rest/api")
public class PrescriptionsRestController {
    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @RequestMapping(value="/prescriptions",
            method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE,
                         APPLICATION_XML_VALUE } )
    public PrescriptionsListWrapper prescriptions() {
        return new PrescriptionsListWrapper(prescriptionDAO.allPrescription());
    }

}
