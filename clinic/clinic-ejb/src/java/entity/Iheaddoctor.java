/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Julia
 */
@Entity
@DiscriminatorValue(value="H")
public class Iheaddoctor extends Idoctor  {
            public Iheaddoctor() {
    }
    
    public Iheaddoctor(String _emailid, String _password, String _fname, String _lname, String _speciality) {
     super(_emailid, _password, _fname, _lname, _speciality);
     this.setHeadDoctor("H");
    }   
    
    @Override
    public String showTypeofDoctor(){
        return "Head Doctor";        
    }
    
}
