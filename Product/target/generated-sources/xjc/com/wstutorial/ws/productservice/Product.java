//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 04:17:02 AM BDT 
//


package com.wstutorial.ws.productservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Product"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="stock" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="sellerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {

})
public class Product {

    protected long id;
    @XmlElement(required = true)
    protected String label;
    protected long price;
    protected long stock;
    protected long sellerId;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public long getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(long value) {
        this.price = value;
    }

    /**
     * Gets the value of the stock property.
     * 
     */
    public long getStock() {
        return stock;
    }

    /**
     * Sets the value of the stock property.
     * 
     */
    public void setStock(long value) {
        this.stock = value;
    }

    /**
     * Gets the value of the sellerId property.
     * 
     */
    public long getSellerId() {
        return sellerId;
    }

    /**
     * Sets the value of the sellerId property.
     * 
     */
    public void setSellerId(long value) {
        this.sellerId = value;
    }

}
