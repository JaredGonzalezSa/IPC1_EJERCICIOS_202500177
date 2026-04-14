package gestionestudiantes;
/**
 *
 * @author Jared González 202500177
 */
public class ListaDobleEstudiantes {
    //Doble nodo referenciador
    private NodoEstudianteDoble primero; 
    private NodoEstudianteDoble ultimo; 

    //Constructor
    public ListaDobleEstudiantes() {
        //Vacía
        this.primero = null; 
        this.ultimo = null; 
    }

    //Agregar al inicio
    public void agregarInicio(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevoNodo = new NodoEstudianteDoble(carnet, nombre, nota);
        if (this.primero == null) {
            // Si la lista está vacía, el nuevo es el primero y también el último
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            // Conexiones de doble vía:
            nuevoNodo.siguiente = this.primero; //El primero ahora es el siguiente del nuevo nodo
            this.primero.anterior = nuevoNodo;  //El anterior al primero es nuestro nuevo nodo
            this.primero = nuevoNodo;           //El nodo de referencia cambia
        }
    }
    //Agregar al final
    public void agregarFinal(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevoNodo = new NodoEstudianteDoble(carnet, nombre, nota);

        if (this.ultimo == null) {
            this.primero = nuevoNodo; 
            this.ultimo = nuevoNodo; 
            
        } else {
            //Ya no usamos while
            this.ultimo.siguiente = nuevoNodo; //El siguiente a nuestro ultimo nodo es el nuevo nodo
            nuevoNodo.anterior = this.ultimo;  //El anterior de nuestro nuevo nodo es el ultimo nood
            this.ultimo = nuevoNodo;           //Nodo de referencia
        }
    }
    // Recorre de HEAD a TAIL
    public void imprimirAdelante() {
        NodoEstudianteDoble actual = this.primero;
        
        System.out.println("Listado de inicio a fin:");
        while (actual != null) {
            System.out.println("Carnet: " + actual.carnet + ", Nombre: " + actual.nombre + ", Nota: " + actual.nota);
            actual = actual.siguiente; // avanzar
        }
        System.out.println("-------------------------------------");
    }
    // Recorre de TAIL a HEAD
    public void imprimirAtras() {
        NodoEstudianteDoble actual = this.ultimo; //ultimo
        
        System.out.println("Listado de fin a inicio");
        while (actual != null) {
            System.out.println("Carnet: " + actual.carnet + " | Nombre: " + actual.nombre + " | Nota: " + actual.nota);
            actual = actual.anterior; //retroceso
        }
        System.out.println("-------------------------------------");
    }
 
    //Eliminar por carné
    public void eliminarPorCarnet(String carnet) {
        //Lista vacia
        if (this.primero == null) {
            return;
        }
        NodoEstudianteDoble actual = this.primero;
        // Recorremos la lista para encontrar el nodo con el carnet
        while (actual != null && !actual.carnet.equals(carnet)) {
            actual = actual.siguiente;
        }
        //No se encontro el carnet, porque llegamos a null
        if (actual == null) {
            System.out.println("Estudiante no encontrado");
            return;
        }
        // Es el unico elemento
        if (actual == this.primero && actual == this.ultimo) {
            this.primero = null;
            this.ultimo = null;
            return;
        }
        //Primer elemento de la lista
        if (actual == this.primero) {
            this.primero = actual.siguiente; //Cabeza al siguiente
            this.primero.anterior = null;    //Nada atras
            return;
        }
        //Ultimo de la lista
        if (actual == this.ultimo) {
            this.ultimo = actual.anterior; // Movemos la cola al penúltimo nodo
            this.ultimo.siguiente = null;  //no hay nadie adelante
            return;
        }
        //En medio
        //Desconexión
        //El anterior al actual apunta al siguiente del actual
        actual.anterior.siguiente = actual.siguiente;
        //El siguiente del actual apunta al anterior del actual
        actual.siguiente.anterior = actual.anterior;
    }
    
    //insertarOrdenado
    public void insertarOrdenado(String carnet, String nombre, double nota) {
        
        NodoEstudianteDoble nuevoNodo = new NodoEstudianteDoble(carnet, nombre, nota);

        // Lista totalmente vacia
        if (this.primero == null) {
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
            return; 
        }

        // Sí la nota es menor a la del primero
        if (nota < this.primero.nota) {
            nuevoNodo.siguiente = this.primero; // El nuevo apunta al primero
            this.primero.anterior = nuevoNodo;  // El primero apunta al nuevo 
            this.primero = nuevoNodo;           // Actualizamos la cabeza
            return;
        }

        //Insertar al final
        if (nota >= this.ultimo.nota) {
            this.ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = this.ultimo;
            this.ultimo = nuevoNodo;
            return;
        }

        //Parametros de recorrido
        NodoEstudianteDoble actual = this.primero;

        //Para cuando se termina o cuando se encuentre a alguien con una nota mayor a la ingresada
        while (actual != null && actual.nota <= nota) {
            actual = actual.siguiente;
        }

        //Actual es el que tiene que ir despues del nuevo
        
        //coneccion del nuevo
        nuevoNodo.siguiente = actual;
        nuevoNodo.anterior = actual.anterior;
        
        //Conexion de vecinos
        actual.anterior.siguiente = nuevoNodo; // El de atrás ahora apunta hacia adelante al nuevo
        actual.anterior = nuevoNodo;           // El de adelante ahora apunta hacia atrás al nuevo
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
