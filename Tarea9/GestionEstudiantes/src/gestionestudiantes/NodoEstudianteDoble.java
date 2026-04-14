package gestionestudiantes;
/**
 *
 * @author Jared González 202500177
 */
public class NodoEstudianteDoble {
    // Atributos de información
    String carnet;
    String nombre;
    double nota;

    // Punteros direccionales
    NodoEstudianteDoble siguiente;
    NodoEstudianteDoble anterior; 

    // Constructor
    public NodoEstudianteDoble(String carnet, String nombre, double nota) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.nota = nota;
        
        // Al nacer, el nodo no está conectado a nada
        this.siguiente = null; 
        this.anterior = null;
    }
}