
import java.util.*;

/*
El algoritmo debe permitir cargar la marca y el modelo de una computadora y para cada
computadora indicar los N componentes de CPU que posee indicando la cantidad y el precio por
ejemplo componente “Memoria RAM 2 Gb”, marca “Kingston”, cantidad “2”, precio “8000”
Al finalizar la carga de los componentes mostrar la información cargada, y determinar el costo de la
computadora el cual será el equivalente de sumar el precio por la cantidad usada de cada
componente y el precio de venta sugerido para la computadora el cual será equivalente a el precio
de costo más el 40% del precio de costo si el precio de costo es menor a 50000, o equivalente a el
precio de costo más el 30% del precio de costo si el precio de costo es mayor a 50000.
Al terminar de mostrar los datos y precio de la computadora deberá preguntar si desea cotizar una
nueva computadora, si la respuesta es “SI” deberá iniciar nuevamente el programa, si la respuesta
es “NO”, terminar la ejecución del programa.
-----------Computadora----------------
Marca: Lenovo
Modelo: X64K
Componentes:
Componente Marca Cantidad Precio X Unidad SubTotal
Placa Madre ASUS 1 16000 16000
Procesador INTEL I7 1 20000 20000
Memoria RAM 2Gb Kingston 2 8000 16000
Disco Rigido WD SSD 1 7500 7500
Costo Total 59500
El precio sugerido de venta es 59500 + 17850 = 77350
 */
public class CostoComputadora {
    
    public static void main(String[] args) {
    while (true){
    imprimirComputadora(cargarpc());
    System.out.println("Ingrese 'SI' paraa cotizar una nueva computadora");
    String opcion = new Scanner(System.in).nextLine();
    if (!opcion.toUpperCase().equals("SI")){
    break;}
    }
    }
public static Computadora cargarpc(){
Computadora nueva = new Computadora();
nueva.setMarca(ingresarMarca());
nueva.setModelo(ingresarModelo());

nueva.setComponentes(ingresarComponentes());

return nueva;
}
public static String ingresarMarca(){
    System.out.println("INGRESE UNA MARCA");
    String nombre = new Scanner(System.in).nextLine();
        if (nombre.isEmpty()){
            System.out.println("INGRESE UNA MARCA CORRECTA");
            ingresarMarca();
        }
    return nombre.toUpperCase();
}
public static String ingresarModelo(){
    System.out.println("INGRESE UN MODELO");
    String nombre = new Scanner(System.in).nextLine();
        if (nombre.isEmpty()){
            System.out.println("INGRESE UN MODELO CORRECTO");
            ingresarModelo();
        }
    return nombre.toUpperCase();
}
public static HashSet<ComponenteCPU> ingresarComponentes(){
    HashSet<ComponenteCPU> componentes = new HashSet<ComponenteCPU>();
    while (true){    
        componentes.add(nuevoComponente());
        System.out.println("Ingrese N para detener el ingreso de componentes: ");
        String opcion = new Scanner(System.in).nextLine();
    if (opcion.toUpperCase().equals("N")){
        break;
              
}
}   
    
return componentes;
}
public static ComponenteCPU nuevoComponente(){
    ComponenteCPU nuevo = new ComponenteCPU();
    nuevo.setComponente(ingresarComponente());
    nuevo.setMarca(ingresarMarca());
    nuevo.setCantidad(ingresarCantidad());
    nuevo.setPrecio(ingresarPrecio());
return nuevo;   
}
public static String ingresarComponente(){
    System.out.println("INGRESE UN COMPONENTE");
    String nombre = new Scanner(System.in).nextLine();
        if (nombre.isEmpty()){
            System.out.println("INGRESE UN COMPONENTE CORRECTO");
            ingresarComponente();
        }
    return nombre.toUpperCase();
}
public static int ingresarCantidad(){
    System.out.println("INGRESE UNA CANTIDAD");
    int cantidad = new Scanner(System.in).nextInt();
        if (cantidad < 0){
            System.out.println("INGRESE UNA CANTIDAD CORRECTA");
            ingresarCantidad();
        }
    return cantidad;
}
public static double ingresarPrecio(){
    System.out.println("INGRESE UN MONTO");
    double precio = new Scanner(System.in).nextDouble();
        if (precio< 0){
            System.out.println("INGRESE UN PRECIO");
            ingresarPrecio();
        }
    return precio;
}
public static void imprimirComputadora(Computadora c){
System.out.println("Marca: " + c.getMarca());
System.out.println("Modelo: " + c.getModelo());
System.out.println("Componente  Marca   Cantidad    Precio por Unidad   SubTotal");
for(ComponenteCPU m: c.getComponentes()){
System.out.println(m.getComponente()+"  "+m.getMarca()+"    " + m.getCantidad()+"   "+m.getPrecio()+"   "+ subtotal(m));}
System.out.println("Total: " + total(c.getComponentes()));
System.out.println("El precio de venta sugerido es: " + totalsugerido(c.getComponentes()));

}
public static double subtotal(ComponenteCPU c){
double subtotal;
subtotal = c.getCantidad()*c.getPrecio();
return subtotal;
}
public static double total(HashSet<ComponenteCPU> c){
double total = 0;
for(ComponenteCPU a: c){
total += subtotal(a);
}
return total;
}
public static double totalsugerido(HashSet<ComponenteCPU> c){
double total = 0;
for(ComponenteCPU a: c){
total += subtotal(a);
}
if (total < 50000){
total += total*0.4;}
else{
total += total*0.3;}
return total;
}
}

