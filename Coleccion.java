
import java.util.*;

public class Coleccion {
    HashMap<String,ArrayList<String>> inventario;
    Map<String,ArrayList<String>> coleccion;
    HashMap<String, Integer> cant;
    ArrayList<String> keys;
    Boolean contains = false;
    String key;
    int contador = 0;
    int contador2 = 0;


    public Coleccion(HashMap<String,ArrayList<String>> inventario, Map<String,ArrayList<String>> coleccion){
        this.inventario = inventario;
        this.coleccion = coleccion;

    }

    public void setKeys(ArrayList<String> keys){
        this.keys = keys;
    }

    private void Cant(){
        for(int i = 0; i<keys.size(); i++){
         
        }
    }

    public Boolean Contains(String value){
        contains = false;
        contador = 0;
        while(!contains && contador < keys.size()){
            contador2 = 0;
            while(contador2<inventario.get(keys.get(contador)).size() && !contains){
                if(inventario.get(keys.get(contador)).get(contador2).equals(value)){
                    contains = true;
                    key = keys.get(contador);
                    break;
                }
                else{
                    contains = false;
                }
                contador2++;
            }
            contador++;
        }
        return contains;

        
    }

    public void Agregar(String producto){
        if(Contains(producto)){
            if(!coleccion.containsKey(key)){
                coleccion.put(key, new ArrayList<String>());
                
                
            }
            coleccion.get(key).add(producto);
            System.out.println("Su producto se ha agregado efectivamente...\n");
        }
        else{
            System.out.println("\nNO se pudo encontrar el producto deseado en nuestro inventario...\n");
        }
    }

    
    public void Mostrar(int opcion, String producto){

    }

    public void Categoria(String producto){
        for(int i = 0; i< keys.size(); i++){
            for(int j = 0; j<inventario.get(keys.get(i)).size(); j++){
                if(producto.equals(inventario.get(keys.get(i)).get(j))){
                    System.out.println("Producto: " + producto + " Categoría: " + keys.get(i));
                }
                else{
                    System.out.println("No se pudo encontrar el producto en nuestro inventario");
                }
            }
        }
    }




}
