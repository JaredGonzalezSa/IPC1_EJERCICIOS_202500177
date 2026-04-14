package gestionestudiantes;
/**
 *
 * @author jared
 */
public class ListaEstudiante {
    //Nodo inicial
    private NodoEstudiante primero;
    
    //Constructor 
    public ListaEstudiante(){
        //Al crear una lista no tiene ningún nodo 
        this.primero = null;
    }
    
    //Agregar Inicio
    public void agregarInicio(String carnet, String nombre, double nota){
        NodoEstudiante nuevoNodo = new NodoEstudiante(carnet,nombre,nota);
        
        if (this.primero == null){
            this.primero = nuevoNodo;
        } else { //Ya hay elemento
            nuevoNodo.siguiente = this.primero; //referencia
            this.primero = nuevoNodo; //cambio
        }   
    }
    
    //Agregar Final
    public void agregarFinal(String carnet, String nombre, double nota) {
        NodoEstudiante nuevoNodo = new NodoEstudiante(carnet, nombre, nota);
        //Caso base, que pasa si la lista esta vacía
        if (this.primero == null) {
            this.primero = nuevoNodo;
            return;
        }
        //Un nodo que comienza en el primero
        NodoEstudiante actual = this.primero;
        //termina con el ultimo elemento
        while (actual.siguiente != null) {
            actual = actual.siguiente; //Avanzamos de nodo
        }
        //Enlaze del ultimo, ahora si con el nuevoultimo
        actual.siguiente = nuevoNodo;
    }
    
    //Buscar
    //Retorna un nodo
    public NodoEstudiante buscarPorCarnet(String carnet) {
        NodoEstudiante actual = this.primero; //el head de la lista

        while (actual != null) {
            // Comparamos el carnet del nodo actual con el que buscamos
            if (actual.carnet.equals(carnet)) {
                return actual; //se retorna
            }
            actual = actual.siguiente; //siguiente nodo
        }

        return null; //0 Coincidencias
    }
   
    //Método para eliminar
    public void eliminarPorCarnet(String carnet) {
        //No hay nada que eliminar 
        if (this.primero == null) {
            return; 
        }

        //primero de la lsita
        if (this.primero.carnet.equals(carnet)) {
            //Mover cabeza
            this.primero = this.primero.siguiente; 
            return;
        }

        //Parametros para recorrer
        NodoEstudiante actual = this.primero;
        NodoEstudiante anterior = null;

        // Recorremos la lista buscando el carnet
        //termina en uno de los siguientes casos, se llega al fnal, o se encontro que el actual tiene el carnet ingresaso
        while (actual != null && !actual.carnet.equals(carnet)) {
            anterior = actual;           //anterior se vuelve actual 
            actual = actual.siguiente;   //actual se vuelve el siguiente
        }

        //Si termino debido que se llego al final 
        if (actual == null) {
            return;
        }

        //Se enlaza al anterior con el siguiente, nadie lo necesita
        anterior.siguiente = actual.siguiente; 
    }
    
    //Imprimir lista
    public void imprimirLista() {
        NodoEstudiante actual = this.primero;
        System.out.println("----------------------------");
        System.out.println("Estudiantes:");
        while (actual != null) {
            System.out.println("Carnet: " + actual.carnet + ", Nombre: " + actual.nombre + ", Nota: " + actual.nota);
            actual = actual.siguiente;
        }
        System.out.println("----------------------------");
    }
    
    //Promedio de notas
    public double obtenerPromedio() {
        if (this.primero == null) return 0.0; //No hay datos

        NodoEstudiante actual = this.primero;
        
        double sumaNotas = 0;
        //dividir
        int contador = 0;
        while (actual != null) {
            sumaNotas += actual.nota; // Acumulamos las notas
            contador++;               // Contamos cuántos estudiantes hay
            actual = actual.siguiente;
        }
        return sumaNotas / contador;
    }
    
    //Mejor nota
    public NodoEstudiante obtenerMejorNota() {
        if (this.primero == null) return null;

        NodoEstudiante actual = this.primero;
        NodoEstudiante mejorEstudiante = this.primero; //El primero tiene la mejor

        while (actual != null) {
            // Si la nota de algien es mayor a nuestro supuesto lo cambiamos
            if (actual.nota > mejorEstudiante.nota) {
                mejorEstudiante = actual;
            }
            actual = actual.siguiente;
        }

        return mejorEstudiante;
    }
}
