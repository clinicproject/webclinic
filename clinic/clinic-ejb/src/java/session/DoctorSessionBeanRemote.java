/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Idoctor;
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
}