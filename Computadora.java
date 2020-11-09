/*Clase: Computadora
Atributos: marca(string), modelo (string), HashSet de objetos ComponenteCPU
 */
import java.util.*;
public class Computadora {
String marca;
String modelo;
HashSet<ComponenteCPU> componentes;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public HashSet<ComponenteCPU> getComponentes() {
        return componentes;
    }

    public void setComponentes(HashSet<ComponenteCPU> componentes) {
        this.componentes = componentes;
    }

}
