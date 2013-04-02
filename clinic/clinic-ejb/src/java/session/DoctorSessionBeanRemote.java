/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Idate;
import entity.Idoctor;
import entity.Ipatient;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Julia
 */

@Remote
public interface DoctorSessionBeanRemote {
    
    public List<Idoctor> getAllDoctors();
    public Idoctor getDoctorById(int id);
    public boolean updateDoctor(Idoctor doctor);
    public boolean deleteDoctor(Idoctor doctor);
    public boolean insertDoctor(Idoctor doctor);
    public List<Idoctor> getDoctorByLName(String lName);
    public List<Idoctor> getDoctorsBySpeciality(String speciality);
    public Boolean Login(String emailID, String password);
    List<Idate> getDatesByDateID(int dateid);
    List<Ipatient> getPatientBySearchText(String searchText);
    
}