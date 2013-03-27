/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ben
 */
@Entity
@Table(name = "Idate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idate.findAll", query = "SELECT i FROM Idate i"),
    @NamedQuery(name = "Idate.findByDateID", query = "SELECT i FROM Idate i WHERE i.dateID = :dateID"),
    @NamedQuery(name = "Idate.findByDate", query = "SELECT i FROM Idate i WHERE i.date = :date")})
public class Idate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateID")
    private Integer dateID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dateID")
    private Collection<Iappointment> iappointmentCollection;
    @JoinColumn(name = "slotID", referencedColumnName = "slotID")
    @ManyToOne(optional = false)
    private Islot slotID;
    @JoinColumn(name = "doctorID", referencedColumnName = "doctorID")
    @ManyToOne(optional = false)
    private Idoctor doctorID;

    public Idate() {
    }

    public Idate(Integer dateID) {
        this.dateID = dateID;
    }

    public Idate(Integer dateID, Date date) {
        this.dateID = dateID;
        this.date = date;
    }

    public Integer getDateID() {
        return dateID;
    }

    public void setDateID(Integer dateID) {
        this.dateID = dateID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Iappointment> getIappointmentCollection() {
        return iappointmentCollection;
    }

    public void setIappointmentCollection(Collection<Iappointment> iappointmentCollection) {
        this.iappointmentCollection = iappointmentCollection;
    }

    public Islot getSlotID() {
        return slotID;
    }

    public void setSlotID(Islot slotID) {
        this.slotID = slotID;
    }

    public Idoctor getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Idoctor doctorID) {
        this.doctorID = doctorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dateID != null ? dateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idate)) {
            return false;
        }
        Idate other = (Idate) object;
        if ((this.dateID == null && other.dateID != null) || (this.dateID != null && !this.dateID.equals(other.dateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Idate[ dateID=" + dateID + " ]";
    }
    
}
