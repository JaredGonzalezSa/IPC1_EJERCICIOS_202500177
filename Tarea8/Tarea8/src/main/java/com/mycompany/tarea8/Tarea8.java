package com.mycompany.tarea8;

public class Tarea8 {

    public static void main(String[] args) {
        //Creamos una instancia (un objeto) de tu ventana gráfica
        ConvertidorTemperaturas ventana = new ConvertidorTemperaturas();
        
        // Centramos la ventana en la pantalla
        ventana.setLocationRelativeTo(null);
        
        //Hacemos que la ventana sea visible
        ventana.setVisible(true);
    }
}