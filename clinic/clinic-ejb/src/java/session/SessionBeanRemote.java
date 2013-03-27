/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entity.Ipatient;
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
}
