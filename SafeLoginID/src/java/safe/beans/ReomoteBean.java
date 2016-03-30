package safe.beans;

import static aproc.crud.AprocLogMethods.ListUsuarios;
import aproc.map.Uztuser;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ejb.Stateless;

@Stateless
public class ReomoteBean implements ReomoteBeanRemote {

    @Override
    public String pruebaEJB() {
        return "PRUEBA EJB";
    }

    @Override
    public ArrayList<Uztuser> Listausuarios() {
       // JSONArray mJSONArray;
       // mJSONArray = new JSONArray(Arrays.asList(ListUsuarios()));
        
        System.out.println(ListUsuarios());
        return ListUsuarios();
        
    }
    
    
    
    
}
