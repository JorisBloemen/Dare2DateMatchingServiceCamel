
package nl.han.dare2date.service.web.applyregistration.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Creditcard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Creditcard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="cvc" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="validThrough" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Creditcard", namespace = "http://www.han.nl/schemas/messages", propOrder = {
    "number",
    "cvc",
    "validThrough"
})
public class Creditcard {

    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    protected BigInteger number;
    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    protected BigInteger cvc;
    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validThrough;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumber(BigInteger value) {
        this.number = value;
    }

    /**
     * Gets the value of the cvc property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCvc() {
        return cvc;
    }

    /**
     * Sets the value of the cvc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCvc(BigInteger value) {
        this.cvc = value;
    }

    /**
     * Gets the value of the validThrough property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidThrough() {
        return validThrough;
    }

    /**
     * Sets the value of the validThrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidThrough(XMLGregorianCalendar value) {
        this.validThrough = value;
    }

}
