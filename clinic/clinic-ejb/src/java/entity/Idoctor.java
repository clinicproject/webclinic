/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ben
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
    @NamedQuery(name = "Idoctor.findBySpecialty", query = "SELECT i FROM Idoctor i WHERE i.specialty = :specialty")})
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
    @Column(name = "specialty")
    private String specialty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorID")
    private Collection<Iappointment> iappointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorID")
    private Collection<Idate> idateCollection;

    public Idoctor() {
    }

    public Idoctor(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Idoctor(Integer doctorID, String emailID, String password, String lName, String specialty) {
        this.doctorID = doctorID;
        this.emailID = emailID;
        this.password = password;
        this.lName = lName;
        this.specialty = specialty;
    }

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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @XmlTransient
    public Collection<Iappointment> getIappointmentCollection() {
        return iappointmentCollection;
    }

    public void setIappointmentCollection(Collection<Iappointment> iappointmentCollection) {
        this.iappointmentCollection = iappointmentCollection;
    }

    @XmlTransient
    public Collection<Idate> getIdateCollection() {
        return idateCollection;
    }

    public void setIdateCollection(Collection<Idate> idateCollection) {
        this.idateCollection = idateCollection;
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
    
}
