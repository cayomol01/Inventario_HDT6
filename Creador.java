
import java.util.*;

class Creador {
    
    public Map<String,ArrayList<String>> Crear(int opcion){
        if(opcion == 1){
            return new HashMap<String,ArrayList<String>>();
        }
        else if(opcion == 2){
            return new TreeMap<String,ArrayList<String>>();
        }
        else if(opcion == 3){
            return new LinkedHashMap<String,ArrayList<String>>();
        }
        return null;
    }
}
