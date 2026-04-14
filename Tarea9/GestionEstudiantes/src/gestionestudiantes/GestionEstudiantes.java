package gestionestudiantes;
/**
 *
 * @author Jared González 202500177
 */
public class GestionEstudiantes {
    public static void main(String[] args) {
        System.out.println("      PRUEBAS PARTE 1: LISTA SIMPLE      ");
        //instanciar objeto
        ListaEstudiante listaSimple = new ListaEstudiante();

        //Inserciones
        listaSimple.agregarInicio("202601", "Carlos", 85.0);
        listaSimple.agregarInicio("202602", "Michael", 90.5); 
        listaSimple.agregarFinal("202603", "Lud", 78.0);   
        listaSimple.agregarFinal("202604", "Elder", 95.0);  

        listaSimple.imprimirLista();

        //promedio
        System.out.println("\n Promedio de la clase: " + listaSimple.obtenerPromedio());
        
        NodoEstudiante mejor = listaSimple.obtenerMejorNota();
        //Mejor
        if(mejor != null) {
            System.out.println("Mejor Estudiante: " + mejor.nombre + " con " + mejor.nota);
        }

        // Probamos buscar y eliminar
        System.out.println("\nEliminando");
        listaSimple.eliminarPorCarnet("202603");
        listaSimple.imprimirLista();



        System.out.println("      PRUEBAS PARTE 2: LISTA DOBLE       ");

        //Intanciasr
        ListaDobleEstudiantes listaDoble = new ListaDobleEstudiantes();

        //Probamos inserciones y la inserción ordenada
        System.out.println(" Insertando estudiantes de forma ordenada...");
        listaDoble.insertarOrdenado("202601", "Carlos", 80.0);
        listaDoble.insertarOrdenado("202602", "Michael", 92.0);
        listaDoble.insertarOrdenado("202603", "Lud", 65.0);   
        listaDoble.insertarOrdenado("202604", "Elder", 85.0); 

        //Recorridos
        listaDoble.imprimirAdelante(); 
        listaDoble.imprimirAtras();    
        
        //Eliminacion
        System.out.println("\n Eliminando a");
        listaDoble.eliminarPorCarnet("202601");
        
        listaDoble.imprimirAdelante();
    }
}
