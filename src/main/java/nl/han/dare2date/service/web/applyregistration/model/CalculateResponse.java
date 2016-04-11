
package nl.han.dare2date.service.web.applyregistration.model;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="resultList" type="{http://www.han.nl/schemas/messages}ResultList"/>
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
    "resultList"
})
@XmlRootElement(name = "CalculateResponse", namespace = "http://www.han.nl/schemas/messages")
public class CalculateResponse {

    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    protected ResultList resultList;

    /**
     * Gets the value of the resultList property.
     * 
     * @return
     *     possible object is
     *     {@link ResultList }
     *     
     */
    public ResultList getResultList() {
        return resultList;
    }

    /**
     * Sets the value of the resultList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultList }
     *     
     */
    public void setResultList(ResultList value) {
        this.resultList = value;
    }

}
