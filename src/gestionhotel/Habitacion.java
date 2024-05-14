/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionhotel;

/**
 *
 * @author MICHAEL NARANJO
 */
public class Habitacion {

    int numHabitacion = 0;
    String tipoHabitacion = "";
    boolean esEspecial = false;
    String descripcion = "";
    int numCamas = 0;
    String carac = "";
    boolean disponibilidad = true;
    int precio = 0;

    public Habitacion() {
    }

    public Habitacion(int numHabitacion, String tipoHabitacion, String descripcion, int numCamas, int precio, boolean esEspecial) {
        this.numHabitacion = numHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.descripcion = descripcion;
        this.numCamas = numCamas;
        this.precio = precio;

        if (esEspecial) {
            this.carac = "Incluye jacuzzi, aire acondicionado y balcón";
        } else {
            this.carac = "no incluye jacuzzi, aire acondicionado, ni balcón";
        }
        
    }
    
//    @Override
//    public String toString() {
//        return "Reserva{\n"
//                + "a nombre de: " + nombre + "\n"
//                + "Numero de documento: " + nDocu + "\n"
//                + "Edad: " + edad + "\n"
//                + "Telefono: " + telefono + "\n"
//                + "Tiempo de Estadia: " + tiempoEstadia + "\n"
//                + "Numero de Personas=" + numeroPersonas + '}';
//    }

}