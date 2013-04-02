/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entity.Iappointment;
import entity.Idate;
import entity.Ipatient;
import java.util.List;
import javax.ejb.Remote;
/**
 *
 * @author ben
 */
@Remote
public interface SessionBeanRemote {
    
    public void Insert (Ipatient p);
    public void Delete (Ipatient p);
    public void Edit (Ipatient p);
    public Boolean Login(String username, String password);
    List<Ipatient> getPatientByLName(String lName);
    List<Iappointment> getAppointmentsByPatientID(int id);
    List<Idate> getDatesByDateID(int dateid);
    
}
