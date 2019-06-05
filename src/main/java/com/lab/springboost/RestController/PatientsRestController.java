package com.lab.springboost.RestController;

import com.lab.springboost.DAO.PatientsDAO;
import com.lab.springboost.ListWrapper.PatientsListWrapper;
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
public class PatientsRestController {
    @Autowired
    private PatientsDAO patientsDAO;
    @Autowired
    private XmlTransform transform;
    private static String XSL_Path = "classpath:templates/xsl/patients.xslt";

    @RequestMapping(value = "/patients",
            method = RequestMethod.GET,
            produces = { TEXT_HTML_VALUE })
    public ResponseEntity getXsl() throws JAXBException, TransformerException {
        PatientsListWrapper allPatients = new PatientsListWrapper(patientsDAO.allPatients());
        return ResponseEntity.ok().body(transform.transform(PatientsListWrapper.class,allPatients,XSL_Path));
    }

    @RequestMapping(value="/patients",
            method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE,
                         APPLICATION_XML_VALUE } )
    public PatientsListWrapper patients() {
        return new PatientsListWrapper(patientsDAO.allPatients());
    }


}
