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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ben
 */
@Entity
@Table(name = "Islot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Islot.findAll", query = "SELECT i FROM Islot i"),
    @NamedQuery(name = "Islot.findBySlotID", query = "SELECT i FROM Islot i WHERE i.slotID = :slotID"),
    @NamedQuery(name = "Islot.findBySlot", query = "SELECT i FROM Islot i WHERE i.slot = :slot")})
public class Islot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "slotID")
    private Integer slotID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slot")
    private int slot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "slotID")
    private Collection<Idate> idateCollection;

    public Islot() {
    }

    public Islot(Integer slotID) {
        this.slotID = slotID;
    }

    public Islot(Integer slotID, int slot) {
        this.slotID = slotID;
        this.slot = slot;
    }

    public Integer getSlotID() {
        return slotID;
    }

    public void setSlotID(Integer slotID) {
        this.slotID = slotID;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
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
        hash += (slotID != null ? slotID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Islot)) {
            return false;
        }
        Islot other = (Islot) object;
        if ((this.slotID == null && other.slotID != null) || (this.slotID != null && !this.slotID.equals(other.slotID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Islot[ slotID=" + slotID + " ]";
    }
    
}
