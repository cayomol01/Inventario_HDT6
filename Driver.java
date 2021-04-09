
import java.util.*;
import java.io.*;

class Driver{
    public static void main(String[] args)throws Exception{
        int contador = 0;
        Creador factory = new Creador();
        Scanner scan = new Scanner(System.in);
        String arch = new File("ListadoProducto.txt").getAbsolutePath();
        File archivo = new File(arch);
        Scanner scan_archivo = null;
        Boolean fileOpened;
        String[] text_archivo;
        HashMap<String, ArrayList<String>> inventario = new HashMap<String, ArrayList<String>>();
        Map<String,ArrayList<String>> coleccion;
        String key; 




        try {
            scan_archivo = new Scanner(archivo);
            fileOpened = true;
            System.out.println("Se ha leído su archivo de inventario");
        }
        catch (FileNotFoundException e) {
            System.out.println("--- File Not Found! ---");
            fileOpened = false;
        }
        scan_archivo.useDelimiter("\\Z");
        int opcionMap;
 
        if(fileOpened){
            while(scan_archivo.hasNextLine()){
                text_archivo = scan_archivo.nextLine().split("\t");
                key = text_archivo[0].substring(0,text_archivo[0].length()-1);
                if(!inventario.containsKey(key)){
                    inventario.put(key, new ArrayList<String>());
                }
                inventario.get(key).add(text_archivo[1]);
                System.out.println(key + " " + inventario.get(key).toString());

            }


            System.out.println("Bienvenido al inventario digital!\n");
            System.out.println("Para empezar, quisiera preguntar ¿Que tipo de estructura desea utilizar?");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");

            System.out.println("Por favor escriba el número de la opción que desea utlizar");
            opcionMap = scan.nextInt();
            coleccion = factory.Crear(opcionMap); 

            System.out.println("\nQué desea realizar con su inventario?");
            System.out.println("1. Agregar un nuevo producto a su coleccion");
        }
        else{
            System.out.println("No se pudo empezar el programa debido a que no se encontró el archivo");
        }
    }
}