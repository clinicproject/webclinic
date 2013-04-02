/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Idate;
import entity.Idoctor;
import entity.Ipatient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author Julia
 */
@Stateless
public class DoctorSessionBean implements DoctorSessionBeanRemote{

       
    @javax.persistence.PersistenceContext(unitName="clinic-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Idoctor> getAllDoctors() {
        Query query = em.createQuery("SELECT d FROM Idoctor d");
        return (List<Idoctor>) query.getResultList();
    }

    @Override
    public Idoctor getDoctorById(int id) {
        try{
            Idoctor doctor = (Idoctor)em.find(Idoctor.class, id);
            return doctor;
        }catch(Exception ex){
            System.out.println("getDoctorById" + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateDoctor(Idoctor doctor) {
        try{
            em.merge(doctor);
        }catch(Exception ex){
            System.out.println("updateDoctor" + ex.getMessage());
            return false;
        }
        return true; 
    }

    @Override
    public boolean deleteDoctor(Idoctor doctor) {
          try{
            doctor = (Idoctor) em.merge(doctor);
            em.remove(doctor);
        }catch(Exception ex){
            System.out.println("deleteDoctor" + ex.getMessage());
            return false;
        }
        return true; 
    }

    @Override
    public boolean insertDoctor(Idoctor doctor) {
        try{
            em.persist(doctor);
        }catch(Exception ex){
            System.out.println("insertDoctor" + ex.getMessage());
            return false;
        }
        return true; 
    }

    @Override
    public List<Idoctor> getDoctorByLName(String lName) {
          try{
            Query query = em.createQuery("SELECT d FROM Idoctor d WHERE d.lName like :lName");
            query.setParameter("name", lName);
            return (List<Idoctor>) query.getResultList();
        }catch(Exception ex){
            System.out.println("getDoctorByLName" + ex.getMessage());
            return null;
        }
    }
    
     @Override
     public List<Idoctor> getDoctorsBySpeciality(String speciality)
    {
        try{

        Query query = em.createNamedQuery("Idoctor.findBySpecialty").setParameter("speciality", speciality);
        return (List<Idoctor>) query.getResultList();
        }catch(Exception ex){
            System.out.println("getDoctorBySpeciality" + ex.getMessage());
            return null;
        }
    }
    
        @Override
    public Boolean Login(String emailID, String password) {
        Query q = em.createNamedQuery("Idoctor.findByLogin").setParameter("password", password).setParameter("emailID", emailID);
        List<Idoctor> p = q.getResultList();
        if (p.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
        
        //find all dates book by the patient //Sinan
        @Override
     public List<Idate> getDatesByDateID(int dateid) {
        Query q = (Query)em.createNamedQuery("Idate.findByDateID");
         q.setParameter("dateID",dateid);
      List<Idate> obj = q.getResultList();
        return obj;
    }
        
              //doctor's operation  //Sinan
      //A doctor searching for a patient by last name using option LIKE to return list of patient objects
    @Override
      public List<Ipatient> getPatientBySearchText(String searchText) {
        Query q = (Query)em.createNamedQuery("Ipatient.findBySearch");
         q.setParameter("LName",searchText);
        return q.getResultList();
       }

}
