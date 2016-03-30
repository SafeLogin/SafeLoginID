/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package safe.beans;

import static aproc.crud.AprocLogMethods.ListUsuarios;
import aproc.map.Uztuser;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Ely Paguay
 */
@Stateless
@LocalBean
public class NewSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public static ArrayList<Uztuser> ListUsuarios1() {
        System.out.println(ListUsuarios());
        return ListUsuarios();
    }
    public  String pruebaEJB()
    {
        return "Prueba EJB";        
    }
}
