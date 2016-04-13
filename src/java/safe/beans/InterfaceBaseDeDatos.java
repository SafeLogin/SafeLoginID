/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package safe.beans;

import javax.ejb.Remote;

/**
 *
 * @author elvis
 */
@Remote
public interface InterfaceBaseDeDatos {
    public String LlamadoBaseAprocLog();
    
}
