/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Iappointment;
import entity.Idate;
import entity.Ipatient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ben
 */
@Stateless
public class SessionBean implements SessionBeanRemote {

    @javax.persistence.PersistenceContext(unitName = "clinic-ejbPU")
    EntityManager em;

    @Override
    public void Insert(Ipatient p) {
        em.persist(p);
    }

    @Override
    public void Delete(Ipatient p) {
        em.remove(em.merge(p));
    }

    @Override
    public void Edit(Ipatient p) {
        em.merge(p);

    }
    
    @Override
    public Boolean Login(String username, String password) {
        Query q = em.createNamedQuery("Ipatient.findByLogin").setParameter("password", password).setParameter("fName", username);
        List<Ipatient> p = q.getResultList();
        if (p.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
    
        
    // Search for the patient ID,from the returned obj we can get the ID the we use it in the previous method //Sinan
    @Override
    public List<Ipatient> getPatientByLName(String lNname) {
        Query q = (Query)em.createNamedQuery("Ipatient.findByLName");
         q.setParameter("lName", lNname);
        return q.getResultList();
       }
    
    
       @Override
     public List<Iappointment> getAppointmentsByPatientID(int id) {
        Query q = (Query)em.createNamedQuery("Iappointment.findByPatientID");
         q.setParameter("patientID",id);
        return q.getResultList();
       }
    
     //find all dates book by the patient //Sinan
    @Override
     public List<Idate> getDatesByDateID(int dateid) {
        Query q = (Query)em.createNamedQuery("Idate.findByDateID");
         q.setParameter("dateID", dateid);
      List<Idate> obj = q.getResultList();
        return obj;
    }
    

}
