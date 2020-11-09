/*
El algoritmo debe contener un menú inicial con 3 opciones
1- Cargar Datos en la Agenda
2- Buscar Teléfono por Nombre
3- Listar Agenda
El usuario deberá elegir que desea hacer:
Cargar Datos en la Agenda
Debe solicitar el nombre completo de la persona y su respectivo teléfono, el nombre será usado
como clave y el teléfono como valor del HashMap.
Se deben poder solicitar todas las personas que se deseen hasta que se indique que no se quiere
seguir cargando, cada vez que se ingrese una nueva persona se deberá validar si la clave ya existe
(puede usar la función containsKey), si existe deberá informar de la situación al usuario, si no existe
se agregara al HashMap. Al terminar la carga se debe mostrar el menú nuevamente.
Buscar Teléfono por Nombre
Se debe solicitar el nombre de la persona a buscar, si no se encuentra mostrar el mensaje “La
persona buscada no se encuentra en la agenda”, caso contrario mostrar por pantalla el teléfono de
la persona que se encontró en el HashMap. Al finalizar mostrar nuevamente el menú.
Listar Agenda
Recorrer la totalidad de elementos que posee el HashMap agenda, mostrando cada uno de los
nombres y teléfonos que se encuentran almacenados. Al finalizar volver al menú.
 */
import java.util.*;
public class Ejercicio01 {
    static HashMap<String, Long> agenda = new HashMap<String, Long>();
    public static void main(String[] args) {
    menu();
    }
    
public static void menu(){
    System.out.println("Ingrese una opción: \n"
            + "A: Cargar nuevo contacto\n"
            + "B: Buscar contacto\n"
            + "C: Ver agenda\n");
    String opcion = new Scanner(System.in).nextLine();
    if (opcion.toUpperCase().equals("A")){
        agregarContacto();
        }
    
    if (opcion.toUpperCase().equals("B")){
        buscarNro(ingresarNombre());
    }
    if (opcion.toUpperCase().equals("C")){
    mostrarAgenda();
    }
    else{
        System.out.println("Opción incorrecta, inténtelo nuevamente.");
        menu();
    }
        
    
}
public static void agregarContacto(){
    while (true){
        String nombre = ingresarNombre();
        if (agenda.containsKey(nombre)){
        System.out.println("El nombre ya existe, ingrese uno nuevo: ");
        agregarContacto();}
        else{
        agenda.put(nombre, ingresarNumero());    
        System.out.println("Si no desea seguir cargando números, presione N");
        String salir = new Scanner(System.in).nextLine();
        if (salir.toUpperCase().equals("N")){
        menu();
        }
        }
}
}
public static void buscarNro(String nombre){
    if (agenda.containsKey(nombre.toUpperCase())){
    System.out.println("El número de " + nombre + " es: " + agenda.get(nombre));
    }
    else{
    System.out.println("La persona buscada no se encuentra en la agenda");
    }
    menu();
}
public static void mostrarAgenda(){
    agenda.forEach((a,b) -> System.out.println("Nombre: " + a + " Número: " + b));
    menu();
}
public static String ingresarNombre(){
    System.out.println("INGRESE UN NOMBRE");
    String nombre = new Scanner(System.in).nextLine();
        if (nombre.isEmpty()){
            System.out.println("INGRESE UN NOMBRE CORRECTO");
            ingresarNombre();
        }
    return nombre.toUpperCase();
}
public static Long ingresarNumero(){
    System.out.println("INGRESE UN NÚMERO");
    long celular = new Scanner(System.in).nextLong();
        if (celular < 0){
            System.out.println("INGRESE UN NÚMERO POSITIVO");
            ingresarNumero();
        }
    return celular;
}
}
