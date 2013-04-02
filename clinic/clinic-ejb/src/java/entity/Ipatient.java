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
@Table(name = "Ipatient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ipatient.findAll", query = "SELECT i FROM Ipatient i"),
    @NamedQuery(name = "Ipatient.findByPatientID", query = "SELECT i FROM Ipatient i WHERE i.patientID = :patientID"),
    @NamedQuery(name = "Ipatient.findByFName", query = "SELECT i FROM Ipatient i WHERE i.fName = :fName"),
    @NamedQuery(name = "Ipatient.findByLName", query = "SELECT i FROM Ipatient i WHERE i.lName = :lName"),
    @NamedQuery(name = "Ipatient.findByNote", query = "SELECT i FROM Ipatient i WHERE i.note = :note"),
    @NamedQuery(name = "Ipatient.findByEmailID", query = "SELECT i FROM Ipatient i WHERE i.emailID = :emailID"),
    @NamedQuery(name = "Ipatient.findByPassword", query = "SELECT i FROM Ipatient i WHERE i.password = :password"),
    @NamedQuery(name = "Ipatient.findByLogin", query = "SELECT i FROM Ipatient i WHERE i.password = :password AND i.fName = :fName"),
    @NamedQuery(name = "Ipatient.findBySearch", query = "SELECT i FROM Ipatient i WHERE i.lName LIKE :lName")})
public class Ipatient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patientID")
    private Integer patientID;
    @Size(max = 10)
    @Column(name = "fName")
    private String fName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "lName")
    private String lName;
    @Size(max = 500)
    @Column(name = "Note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EmailID")
    private String emailID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientID")
    private Collection<Iappointment> iappointmentCollection;

    public Ipatient() {
    }

    public Ipatient(Integer patientID) {
        this.patientID = patientID;
    }

    public Ipatient(Integer patientID, String lName, String emailID, String password) {
        this.patientID = patientID;
        this.lName = lName;
        this.emailID = emailID;
        this.password = password;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @XmlTransient
    public Collection<Iappointment> getIappointmentCollection() {
        return iappointmentCollection;
    }

    public void setIappointmentCollection(Collection<Iappointment> iappointmentCollection) {
        this.iappointmentCollection = iappointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientID != null ? patientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ipatient)) {
            return false;
        }
        Ipatient other = (Ipatient) object;
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ipatient[ patientID=" + patientID + " ]";
    }
    
}
