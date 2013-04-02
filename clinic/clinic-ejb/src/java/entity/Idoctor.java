/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julia
 */
@Entity
@Table(name = "Idoctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idoctor.findAll", query = "SELECT i FROM Idoctor i"),
    @NamedQuery(name = "Idoctor.findByDoctorID", query = "SELECT i FROM Idoctor i WHERE i.doctorID = :doctorID"),
    @NamedQuery(name = "Idoctor.findByEmailID", query = "SELECT i FROM Idoctor i WHERE i.emailID = :emailID"),
    @NamedQuery(name = "Idoctor.findByPassword", query = "SELECT i FROM Idoctor i WHERE i.password = :password"),
    @NamedQuery(name = "Idoctor.findByFName", query = "SELECT i FROM Idoctor i WHERE i.fName = :fName"),
    @NamedQuery(name = "Idoctor.findByLName", query = "SELECT i FROM Idoctor i WHERE i.lName = :lName"),
    @NamedQuery(name = "Idoctor.findBySpeciality", query = "SELECT i FROM Idoctor i WHERE i.speciality = :speciality"),
    @NamedQuery(name = "Idoctor.findByLogin", query = "SELECT i FROM Idoctor i WHERE i.password = :password AND i.emailID = :emailID"),
    @NamedQuery(name = "Idoctor.findByHeadDoctor", query = "SELECT i FROM Idoctor i WHERE i.headDoctor = :headDoctor")})
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="headDoctor", discriminatorType= DiscriminatorType.STRING, length=1)
@DiscriminatorValue(value="D")
public class Idoctor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "doctorID")
    private Integer doctorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailID")
    private String emailID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
    @Size(max = 10)
    @Column(name = "fName")
    private String fName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "lName")
    private String lName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "speciality")
    private String speciality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "headDoctor")
    private String headDoctor;

    public Idoctor() {
    }

    public Idoctor(Integer doctorID) {
        this.doctorID = doctorID;
    }
    public Idoctor(String emailid, String password, String fname, String lname, String speciality) {
        setEmailID(emailid);
        setPassword(password);
        setFName(fname);
        setLName(lname);
        setSpeciality(speciality);
        this.setHeadDoctor("D");
    }
//    public Idoctor(Integer doctorID, String emailID, String password, String lName, String speciality, String headDoctor) {
//        this.doctorID = doctorID;
//        this.emailID = emailID;
//        this.password = password;
//        this.lName = lName;
//        this.speciality = speciality;
//        this.headDoctor = headDoctor;
//    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String specialty) {
        this.speciality = specialty;
    }

    public String getHeadDoctor() {
        return headDoctor;
    }

    public void setHeadDoctor(String headDoctor) {
        this.headDoctor = headDoctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorID != null ? doctorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idoctor)) {
            return false;
        }
        Idoctor other = (Idoctor) object;
        if ((this.doctorID == null && other.doctorID != null) || (this.doctorID != null && !this.doctorID.equals(other.doctorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Idoctor[ doctorID=" + doctorID + " ]";
    }
    
    public String showTypeofDoctor(){
        return "Doctor";
    }
}
