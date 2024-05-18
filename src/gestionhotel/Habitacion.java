package gestionhotel;

/**
 *
 * @author MICHAEL NARANJO
 */
public class Habitacion {
    
    int numHabitacion = 0;
    boolean esEspecial = false;
    boolean disponibilidad = true;

    public Habitacion() {
    }

    public Habitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }
    public Habitacion( boolean esEspecial){
        this.esEspecial=esEspecial;
    }

   
    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public boolean isEsEspecial() {
        return esEspecial;
    }

    public void setEsEspecial(boolean esEspecial) {
        this.esEspecial = esEspecial;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    

}