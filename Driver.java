
import java.util.*;

class Driver{
    public static void main(String[] args){
        int contador = 0;
        Creador factory = new Creador();
        Scanner scan = new Scanner(System.in);
        int opcionMap;
        Map<String,String> productos;
        LinkedList<String> prod = new LinkedList<String>();
        prod.add("lacteos");
        prod.add("hola que ase");
        prod.add("lacteos");
        HashMap<String, LinkedList<String>> hola = new HashMap<String, LinkedList<String>>();
        TreeMap<String, String> hola1 = new TreeMap<String, String>();

        hola.put("primero", prod);
        System.out.println(hola1);
        hola.put("segundo", new LinkedList<String>());
        hola.put("a", new LinkedList<String>());
        System.out.println(hola);
        for(int i = 0; i<hola.get("primero").size(); i++){
            System.out.println(hola);
            if(hola.get("primero").get(i).equals("lacteos")){
                contador++;
            }
        }
        System.out.println(hola.hashCode());
        hola.get("segundo");
        System.out.println(hola);

        
        System.out.println(contador);

        System.out.println("Bienvenido al inventario digital!\n");
        System.out.println("Para empezar, quisiera preguntar ¿Que tipo de estructura desea utilizar?");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        System.out.println("Por favor escriba el número de la opción que desea utlizar");
        opcionMap = scan.nextInt();
        productos = factory.Crear(opcionMap); 

        System.out.println("\nQué desea realizar con su inventario?");
    }
}