
package nl.han.dare2date.service.web.applyregistration.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ResultList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComparedMember" type="{http://www.han.nl/schemas/messages}ComparedMember" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultList", namespace = "http://www.han.nl/schemas/messages", propOrder = {
    "comparedMember"
})
public class ResultList {

    @XmlElement(name = "ComparedMember", namespace = "http://www.han.nl/schemas/messages")
    protected List<ComparedMember> comparedMember;

    /**
     * Gets the value of the comparedMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comparedMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComparedMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComparedMember }
     * 
     * 
     */
    public List<ComparedMember> getComparedMember() {
        if (comparedMember == null) {
            comparedMember = new ArrayList<ComparedMember>();
        }
        return this.comparedMember;
    }

}
