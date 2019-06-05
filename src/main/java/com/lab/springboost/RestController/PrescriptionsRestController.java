package com.lab.springboost.RestController;

import com.lab.springboost.DAO.PrescriptionDAO;
import com.lab.springboost.ListWrapper.PrescriptionsListWrapper;
import com.lab.springboost.Transform.XmlTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/rest/api")
public class PrescriptionsRestController {
    @Autowired
    private PrescriptionDAO prescriptionDAO;
    @Autowired
    private XmlTransform transform;
    private static String XSL_Path = "classpath:templates/xsl/prescriptions.xslt";

    @RequestMapping(value = "/prescriptions",
            method = RequestMethod.GET,
            produces = { TEXT_HTML_VALUE })
    public ResponseEntity getXsl() throws JAXBException, TransformerException {
        PrescriptionsListWrapper allPrescriptions = new PrescriptionsListWrapper(prescriptionDAO.allPrescription());
        return ResponseEntity.ok().body(transform.transform(PrescriptionsListWrapper.class,allPrescriptions,XSL_Path));
    }

    @RequestMapping(value="/prescriptions",
            method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE,
                         APPLICATION_XML_VALUE } )
    public PrescriptionsListWrapper prescriptions() {
        return new PrescriptionsListWrapper(prescriptionDAO.allPrescription());
    }

}
