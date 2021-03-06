
package pl.edu.agh.soa.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStudentByAlbumNo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStudentByAlbumNo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="albumNo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentByAlbumNo", propOrder = {
    "albumNo"
})
public class GetStudentByAlbumNo {

    protected int albumNo;

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

}
