//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.27 at 06:04:04 PM BDT 
//


package com.wstutorial.ws.commonservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wstutorial.ws.commonservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Fault_QNAME = new QName("http://www.wstutorial.com/ws/CommonService", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wstutorial.ws.commonservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AcknowledgementCodeResponse }
     * 
     */
    public AcknowledgementCodeResponse createAcknowledgementCodeResponse() {
        return new AcknowledgementCodeResponse();
    }

    /**
     * Create an instance of {@link StatusCode }
     * 
     */
    public StatusCode createStatusCode() {
        return new StatusCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.wstutorial.com/ws/CommonService", name = "fault")
    public JAXBElement<String> createFault(String value) {
        return new JAXBElement<String>(_Fault_QNAME, String.class, null, value);
    }

}
