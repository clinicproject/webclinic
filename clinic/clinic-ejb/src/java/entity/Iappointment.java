/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ben
 */
@Entity
@Table(name = "Iappointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iappointment.findAll", query = "SELECT i FROM Iappointment i"),
    @NamedQuery(name = "Iappointment.findById", query = "SELECT i FROM Iappointment i WHERE i.id = :id")})
public class Iappointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "patientID", referencedColumnName = "patientID")
    @ManyToOne(optional = false)
    private Ipatient patientID;
    @JoinColumn(name = "doctorID", referencedColumnName = "doctorID")
    @ManyToOne(optional = false)
    private Idoctor doctorID;
    @JoinColumn(name = "dateID", referencedColumnName = "dateID")
    @ManyToOne(optional = false)
    private Idate dateID;

    public Iappointment() {
    }

    public Iappointment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ipatient getPatientID() {
        return patientID;
    }

    public void setPatientID(Ipatient patientID) {
        this.patientID = patientID;
    }

    public Idoctor getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Idoctor doctorID) {
        this.doctorID = doctorID;
    }

    public Idate getDateID() {
        return dateID;
    }

    public void setDateID(Idate dateID) {
        this.dateID = dateID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iappointment)) {
            return false;
        }
        Iappointment other = (Iappointment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Iappointment[ id=" + id + " ]";
    }
    
}
