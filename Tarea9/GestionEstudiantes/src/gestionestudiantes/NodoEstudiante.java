package gestionestudiantes;
/**
 *
 * @author Jared González 202500177
 */
public class NodoEstudiante {
    //Atributos del nodo 
    String carnet;
    String nombre;
    double nota;
    
    //el siguiente nodo se guarda en una variable "Siguientes"
    NodoEstudiante siguiente;
    
    //Constructor
    public NodoEstudiante(String carnet, String nombre, double nota){
        this.carnet = carnet;
        this.nombre = nombre;
        this.nota = nota;
        
        //Un nodo nuevo no tiene un nodo que le siga
        this.siguiente = null;
    }
}
