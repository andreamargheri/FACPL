/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.29 at 03:20:34 PM CET 
//


package it.unifi.xacmlToFacpl.xacml2.policy.jaxb;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObligationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObligationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:2.0:policy:schema:os}AttributeAssignment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ObligationId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="FulfillOn" use="required" type="{urn:oasis:names:tc:xacml:2.0:policy:schema:os}EffectType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObligationType", propOrder = {
    "attributeAssignment"
})
public class ObligationType {

    @XmlElement(name = "AttributeAssignment")
    protected List<AttributeAssignmentType> attributeAssignment;
    @XmlAttribute(name = "ObligationId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String obligationId;
    @XmlAttribute(name = "FulfillOn", required = true)
    protected EffectType fulfillOn;

    /**
     * Gets the value of the attributeAssignment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeAssignment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeAssignment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeAssignmentType }
     * 
     * 
     */
    public List<AttributeAssignmentType> getAttributeAssignment() {
        if (attributeAssignment == null) {
            attributeAssignment = new ArrayList<AttributeAssignmentType>();
        }
        return this.attributeAssignment;
    }

    /**
     * Gets the value of the obligationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligationId() {
        return obligationId;
    }

    /**
     * Sets the value of the obligationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligationId(String value) {
        this.obligationId = value;
    }

    /**
     * Gets the value of the fulfillOn property.
     * 
     * @return
     *     possible object is
     *     {@link EffectType }
     *     
     */
    public EffectType getFulfillOn() {
        return fulfillOn;
    }

    /**
     * Sets the value of the fulfillOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectType }
     *     
     */
    public void setFulfillOn(EffectType value) {
        this.fulfillOn = value;
    }

}
