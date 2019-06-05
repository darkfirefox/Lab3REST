package com.lab.springboost.RestController;

import com.lab.springboost.DAO.DoctorsDAO;
import com.lab.springboost.ListWrapper.DoctorsListWrapper;
import com.lab.springboost.Transform.XmlTransform;
import com.lab.springboost.entity.DoctorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(value = "/rest/api")
public class DoctorsRestController {
    @Autowired
    private DoctorsDAO doctorsDAO;
    @Autowired
    private XmlTransform transform;
    private static String XSL_Path = "classpath:templates/xsl/doctors.xslt";

    @RequestMapping(value = "/doctors",
            method = RequestMethod.GET,
            produces = { TEXT_HTML_VALUE })
    public ResponseEntity getXsl() throws JAXBException, TransformerException {
        DoctorsListWrapper allDoctors = new DoctorsListWrapper(doctorsDAO.allDoctors());
        return ResponseEntity.ok().body(transform.transform(DoctorsListWrapper.class,allDoctors,XSL_Path));
    }

    @RequestMapping(value="/doctors",
                    method = RequestMethod.GET,
                    produces = { APPLICATION_JSON_VALUE,
                                 APPLICATION_XML_VALUE } )
    public DoctorsListWrapper doctors() {
        return new DoctorsListWrapper(doctorsDAO.allDoctors());
    }
}
