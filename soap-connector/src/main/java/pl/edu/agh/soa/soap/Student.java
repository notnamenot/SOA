
package pl.edu.agh.soa.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for student complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="student"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="albumNo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="courses" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="course" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="avatar" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "student", propOrder = {
    "firstName",
    "lastName",
    "albumNo",
    "courses",
    "avatar"
})
public class Student {

    protected String firstName;
    protected String lastName;
    protected int albumNo;
    protected Student.Courses courses;
    protected byte[] avatar;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

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
     * Gets the value of the courses property.
     * 
     * @return
     *     possible object is
     *     {@link Student.Courses }
     *     
     */
    public Student.Courses getCourses() {
        return courses;
    }

    /**
     * Sets the value of the courses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student.Courses }
     *     
     */
    public void setCourses(Student.Courses value) {
        this.courses = value;
    }

    /**
     * Gets the value of the avatar property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAvatar() {
        return avatar;
    }

    /**
     * Sets the value of the avatar property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAvatar(byte[] value) {
        this.avatar = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="course" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "course"
    })
    public static class Courses {

        protected List<String> course;

        /**
         * Gets the value of the course property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the course property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCourse().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCourse() {
            if (course == null) {
                course = new ArrayList<String>();
            }
            return this.course;
        }

    }

}
