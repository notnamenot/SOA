
package pl.edu.agh.soa.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteStudentCourse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteStudentCourse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="albumNo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="course" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteStudentCourse", propOrder = {
    "albumNo",
    "course"
})
public class DeleteStudentCourse {

    protected int albumNo;
    protected String course;

    /**
     * Gets the value of the albumNo property.
     * 
     */
    public int getAlbumNo() {
        return albumNo;
    }

    /**
     * Sets the value of the albumNo property.
     * 
     */
    public void setAlbumNo(int value) {
        this.albumNo = value;
    }

    /**
     * Gets the value of the course property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets the value of the course property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourse(String value) {
        this.course = value;
    }

}
