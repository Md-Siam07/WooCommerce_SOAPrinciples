//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 05:43:04 AM BDT 
//


package com.wstutorial.ws.notificationservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotificationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NotificationStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SEEN"/&gt;
 *     &lt;enumeration value="UNSEEN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NotificationStatus")
@XmlEnum
public enum NotificationStatus {

    SEEN,
    UNSEEN;

    public String value() {
        return name();
    }

    public static NotificationStatus fromValue(String v) {
        return valueOf(v);
    }

}
