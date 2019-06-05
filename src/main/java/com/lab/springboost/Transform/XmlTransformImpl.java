package com.lab.springboost.Transform;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;
@Component
public class XmlTransformImpl implements XmlTransform {

    private TransformerFactory tf = TransformerFactory.newInstance();

    @Override
    public String transform(Class sourceClass, Object sourceObject, String xsltPath) throws TransformerException, JAXBException {
        StreamSource xslt = new StreamSource(xsltPath);
        Transformer transformer = tf.newTransformer(xslt);
        JAXBContext jc = JAXBContext.newInstance(sourceClass);
        JAXBSource source = new JAXBSource(jc, sourceObject);
        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        transformer.transform(source, result);
        return sw.toString();
    }
}
