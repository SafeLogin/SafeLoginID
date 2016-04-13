/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package safe.beans;

import aproc.crud.AprocLogMethods;
import aproc.map.Uztuser;
import java.util.ArrayList;
import javax.ejb.Stateless;


/**
 *
 * @author elvis
 */
@Stateless
public class SessionBeanBaseDeDatos implements InterfaceBaseDeDatos{

    @Override
    public String LlamadoBaseAprocLog() {
       AprocLogMethods met= new AprocLogMethods();
        ArrayList<Uztuser> usuarios = met.ListUsuarios();
        String prueba= usuarios.get(0).getUztuserNombres();
        return prueba; 
    }

    
}
