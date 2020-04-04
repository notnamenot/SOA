
package pl.edu.agh.soa.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStudentByAlbumNoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStudentByAlbumNoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="returnStudent" type="{https://soap.soa.pl/lab1/ws}student" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentByAlbumNoResponse", propOrder = {
    "returnStudent"
})
public class GetStudentByAlbumNoResponse {

    protected Student returnStudent;

    /**
     * Gets the value of the returnStudent property.
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getReturnStudent() {
        return returnStudent;
    }

    /**
     * Sets the value of the returnStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setReturnStudent(Student value) {
        this.returnStudent = value;
    }

}
