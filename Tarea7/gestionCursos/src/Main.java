import java.util.Scanner;

//Clase abstracta
abstract class Persona {
    private String nombre;
    public Persona(String n) {
        nombre = n;
    }
    public String getNombre() {
        return nombre;
    }
    public abstract void mostrar(); //polimorfismo
}

//clase hija
class Tutor extends Persona {
    public Tutor(String n) {
        super(n);
    }
    //polimorfismo
    @Override
    public void mostrar() {
        System.out.println("Tutor: " + getNombre());
    }
}

//Clase Tarea
class Tarea {
    private String titulo, desc, fecha;
    public Tarea(String t, String d, String f) {
        titulo=t; desc=d; fecha=f;
    }
    public void ver() {
        System.out.println("- Tarea: " + titulo + " | " + desc + " | Vence: " + fecha);
    }
}

class Curso {
    private String nombre, codigo;
    private Tutor tutor;
    private Tarea[] tareas = new Tarea[10];
    private int totalTareas = 0;

    public Curso(String n, String c, Tutor t) {
        nombre=n; codigo=c; tutor=t;
    }
    public void agregarTarea(Tarea t) {
        tareas[totalTareas++] = t;
    }

    public void ver() {
        System.out.println("\nCurso: " + nombre + " (" + codigo + ")");
        tutor.mostrar();
        for(int i=0; i < totalTareas; i++) tareas[i].ver();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Curso[] cursos = new Curso[10];
        int totalCursos = 0, op = 0;

        while(op != 4) {
            System.out.print("\n1.Crear Curso | 2.Añadir Tarea | 3.Ver Todo | 4.Salir");
            op = Integer.parseInt(s.nextLine());

            if(op == 1) {
                System.out.println("Escribe: Nombre del curso, Código y Nombre del tutor:");
                cursos[totalCursos++] = new Curso(s.nextLine(), s.nextLine(), new Tutor(s.nextLine()));
                System.out.println("Curso creado.");
            }
            else if(op == 2) {
                System.out.print("Número de curso (0 para el primero, 1 para el segundo...): ");
                int i = Integer.parseInt(s.nextLine());
                System.out.println("Escribe: Título, Descripción y Fecha de entrega (Presiona Enter después de cada uno):");
                cursos[i].agregarTarea(new Tarea(s.nextLine(), s.nextLine(), s.nextLine()));
                System.out.println("Tarea guardada.");
            }
            else if(op == 3) {
                for(int i=0; i < totalCursos; i++) cursos[i].ver();
            }
        }
    }
}