
import java.util.*;

public class Coleccion {
    HashMap<String,ArrayList<String>> inventario;
    Map<String,ArrayList<String>> coleccion;
    HashMap<String, Integer> cant = new HashMap<String, Integer>();
    ArrayList<String> keys;
    ArrayList<String> keys2 = new ArrayList<String>();
    ArrayList<String> keyscoleccion = new ArrayList<String>();
    Boolean contains = false;
    Boolean terminado = false;
    String temp;
    int cantidad;
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


    //Verifica si el inventario contiene el producto que ingreso el usuario.
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

    //Agrega un nuevo producto al arrayList de productos encontrados en coleccion.
    public void Agregar(String producto){
        if(Contains(producto)){
            if(!coleccion.containsKey(key)){
                coleccion.put(key, new ArrayList<String>());
                
                
            }
            if(!keyscoleccion.contains(key)){
                keyscoleccion.add(key);
            }
            coleccion.get(key).add(producto);
            System.out.println("Su producto se ha agregado efectivamente...\n");
        }
        else{
            System.out.println("\nNO se pudo encontrar el producto deseado en nuestro inventario...\n");
        }
    }

    //Muestra la categoría del producto 
    public void MostrarCategoria(String producto){
        terminado = false;
        for(int i = 0; i< keys.size(); i++){
            for(int j = 0; j<inventario.get(keys.get(i)).size(); j++){
                if(producto.equals(inventario.get(keys.get(i)).get(j))){
                    System.out.println("Producto: " + producto + ", Categoría: " + keys.get(i));
                    terminado = true;
                    break;
                }
            }
            if(terminado){
                break;
            }
        }
        if(terminado == false){
            System.out.println("No se pudo encontrar el producto en nuestro inventario");
        }
    }

    //Retorna la cantidad de un mismo articulo en la coleccion
    public int Cantidad(String producto){
        terminado = false;
        cantidad = 0;
        contador = 0;
        
        while(!terminado && contador<keys.size()){
            contador2 = 0;
            //Compara los keys y si un es igual al del inventario entonces revisa si ese producto ya está en coleccion y si si pues le suma uno a la cantidad
            while(!terminado && contador2<inventario.get(keys.get(contador)).size()){
                if(inventario.get(keys.get(contador)).get(contador2).equals(producto)){
                    key = keys.get(contador);
                    for(int k = 0; k<coleccion.get(key).size(); k++){
                        if(coleccion.get(key).get(k).equals(producto)){
                            cantidad++;
                            terminado = true;
                        }
                    }

                }
                contador2++;
                
            }

            contador++;
        }
        return cantidad;
    } 
    
    public void MostrarCantProducto(String producto){
        //Recorre el array que contiene los keys y los usa para comparar los keys del inventario y de esa manera extraer los valores de la cantidad del mismo articulo
        for(int i = 0; i<keys.size();i++){
            for(int j = 0; j<inventario.get(keys.get(i)).size(); j++){
                if(inventario.get(keys.get(i)).get(j).equals(producto)){
                    key = keys.get(i);
                }
                break;
            }
            if(key.equals(keys.get(i))){
                break;
            }
        }
       System.out.println("Del producto: " + producto + " de la categoría: " +  key + " tiene " + Cantidad(producto) + " Unidades");
    }

    public void MostrarColeccionCant(){
        temp = "";
        System.out.printf("%-10s %-20s %-20s", "CATEGORIA", "PRODUCTO", "CANTIDAD\n"); 
        System.out.println(); //Format
        Collections.sort(keyscoleccion); //Orden alfabético de los keys
        //Recorre los keys sin repetirse
        for(int i = 0; i<keyscoleccion.size(); i++){
            for(int j = 0; j<coleccion.get(keyscoleccion.get(i)).size(); j++){
                //Si el valor anterior de key se parece a uno que ya hubó, se sale del for loop anidado
                if(temp.equals(coleccion.get(keyscoleccion.get(i)).get(j))){
                    break;
                }
                else{//Mostrar valores
                    System.out.printf("%-10s %-20s %-20s", keyscoleccion.get(i),coleccion.get(keyscoleccion.get(i)).get(j),Cantidad(coleccion.get(keyscoleccion.get(i)).get(j)));
                    System.out.println();
                    temp = coleccion.get(keyscoleccion.get(i)).get(j);

                }
            }
        }
    }

    //Muestra el inventario completo
    public void MostrarInventario(){
        temp = "";
        terminado = false;
        contador = 0;
        //Format
        System.out.printf("%-20s %-10s", "CATEGORIA", "PRODUCTO\n"); 
        System.out.println();
    
        //Creo una lista con todos los keys sin repetirse
        for(int i = 0; i<keys.size(); i++){
            if(keys2.size()>0){
                if(!keys2.contains(keys.get(i))){
                    keys2.add(keys.get(i));
                }
            }
            else{
                keys2.add(keys.get(i));
            }
        }
        //Hago sorto al array de keys para que estén en orden alfabético
        Collections.sort(keys2);

        //Comenzar un foor loop que se termina una vez 
        while(contador<keys2.size()){
            contador2 = 0;
            //Recorrer todos los keys ya sin repetirse y mostrar sus valores con printf
            while(contador2 < inventario.get(keys2.get(contador)).size()){
                if(temp.equals(inventario.get(keys2.get(contador)).get(contador2))){
                    break;
                }
                else{
                    System.out.printf("%-20s %-10s", keys2.get(contador),inventario.get(keys2.get(contador)).get(contador2));
                    System.out.println();
                    temp = inventario.get(keys2.get(contador)).get(contador2);

                }
                contador2++;
            }
            contador++;
        }
    }

    //Muestra la coleccion completa sin la cantidad de cada objeto
    public void MostrarColeccion(){

        //Es el mismo método que mostrarColeccionCant solo que sin imprimir la cantidad
        temp = "";
        System.out.printf("%-10s %-20s", "CATEGORIA", "PRODUCTO\n"); 
        System.out.println();
        Collections.sort(keyscoleccion);
        for(int i = 0; i<keyscoleccion.size(); i++){
            for(int j = 0; j<coleccion.get(keyscoleccion.get(i)).size(); j++){
                if(temp.equals(coleccion.get(keyscoleccion.get(i)).get(j))){
                    break;
                }
                else{
                    System.out.printf("%-10s %-20s", keyscoleccion.get(i),coleccion.get(keyscoleccion.get(i)).get(j));
                    System.out.println();
                    temp = coleccion.get(keyscoleccion.get(i)).get(j);

                }
            }
        }
    }




}
