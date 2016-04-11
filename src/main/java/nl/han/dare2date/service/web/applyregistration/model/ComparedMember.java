
package nl.han.dare2date.service.web.applyregistration.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for ComparedMember complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComparedMember">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="spotifyMatchCount" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="youtubeMatchCount" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComparedMember", namespace = "http://www.han.nl/schemas/messages", propOrder = {

})
public class ComparedMember {

    @XmlElement(namespace = "http://www.han.nl/schemas/messages")
    protected long id;
    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    protected BigInteger spotifyMatchCount;
    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    protected BigInteger youtubeMatchCount;

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
     * Gets the value of the spotifyMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpotifyMatchCount() {
        return spotifyMatchCount;
    }

    /**
     * Sets the value of the spotifyMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpotifyMatchCount(BigInteger value) {
        this.spotifyMatchCount = value;
    }

    /**
     * Gets the value of the youtubeMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYoutubeMatchCount() {
        return youtubeMatchCount;
    }

    /**
     * Sets the value of the youtubeMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYoutubeMatchCount(BigInteger value) {
        this.youtubeMatchCount = value;
    }

}
