package com.lab.springboost.Transform;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public interface XmlTransform {
    String transform(Class sourceClass, Object sourceObject, String xsltPath) throws TransformerException, JAXBException;
}
