/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

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
}
