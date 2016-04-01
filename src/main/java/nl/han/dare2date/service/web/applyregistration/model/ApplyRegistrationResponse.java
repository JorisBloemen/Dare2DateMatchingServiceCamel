
package nl.han.dare2date.service.web.applyregistration.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registration" type="{http://www.han.nl/schemas/messages}Registration"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "registration"
})
@XmlRootElement(name = "ApplyRegistrationResponse", namespace = "http://www.han.nl/schemas/messages")
public class ApplyRegistrationResponse {

    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    protected Registration registration;

    /**
     * Gets the value of the registration property.
     * 
     * @return
     *     possible object is
     *     {@link Registration }
     *     
     */
    public Registration getRegistration() {
        return registration;
    }

    /**
     * Sets the value of the registration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Registration }
     *     
     */
    public void setRegistration(Registration value) {
        this.registration = value;
    }

}
