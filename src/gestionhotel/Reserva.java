package gestionhotel;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author MICHAEL NARANJO
 */
public class Reserva {

    String nombre = "";
    String nDocu = "";
    int edad = 0;
    String telefono = "";
    int tiempoEstadia = 0;
    int numeroPersonas = 0;
    boolean esEspecial = false; 
    int idHabitacion; 
    boolean[] diasReservados = new boolean[10];

    public Reserva() {
    }

    public Reserva(String nombre, String nDocu, int edad, String telefono, int tiempoEstadia, int numeroPersonas,
            int idHabitacion) {
        this.nombre = nombre;
        this.nDocu = nDocu;
        this.edad = edad;
        // this.fechaReserva = fechaReserva;
        this.telefono = telefono;
        this.tiempoEstadia = tiempoEstadia;
        this.numeroPersonas = numeroPersonas;
        this.idHabitacion = idHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnDocu() {
        return nDocu;
    }

    public void setnDocu(String nDocu) {
        this.nDocu = nDocu;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTiempoEstadia() {
        return tiempoEstadia;
    }

    public void setTiempoEstadia(int tiempoEstadia) {
        this.tiempoEstadia = tiempoEstadia;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    @Override
    public String toString() {
        return "Reserva\n"
                + "a nombre de: " + nombre + "\n"
                + "Numero de documento: " + nDocu + "\n"
                + "Edad: " + edad + "\n"
                + "Telefono: " + telefono + "\n"
                + "Tiempo de Estadia: " + tiempoEstadia + "\n"
                + "Numero de Personas=" + numeroPersonas + "\n"
                + "Numero de habitacion=" + idHabitacion;
    }

    public boolean ReservarHabitacion(int diaInicial, int diasOcupados) {
        int indice = diaInicial - 1;
        if (diasReservados[indice] == false && diasReservados[indice + (diasOcupados - 1)] == false
                && ((indice + (diasOcupados - 1)) <= 10)) {
            for (int i = 0; i < diasOcupados; i++) {
                diasReservados[indice] = true;
                indice++;
            }
            String dias = "";
            for (boolean diasReservado : diasReservados) {
                dias += diasReservado + "\n";
            }
            return true;
        } else {
            return false;
        }
    }

    public void VerReservas(ArrayList<Reserva> reservas) {
        String mensaje = "";
        for (Reserva reserva : reservas) {
            mensaje += reserva + "\n";
        }
        System.out.println("\t Reservas:\n" + mensaje);
    }

    public String encontrarReserva(ArrayList<Reserva> reservas, String nombre) {
        String n = "";
        String nNombre = nombre;
        boolean si=false;
        for (Reserva reserva : reservas) {
            if (reservas.isEmpty()) {
                break;
            } else {
                if (nNombre.equals(reserva.getnDocu())) {
                    JOptionPane.showMessageDialog(null, "Esta es tu reserva: \n"
                            + reserva);
                    n = reserva.getNombre().toLowerCase();
                    si=true;
                }
                
            }
        }
        if(!si){
                    JOptionPane.showMessageDialog(null, "\t\tUUPS\n Tu Reserva no ha sido encontrada",
                            "reserva no encontrada", JOptionPane.ERROR_MESSAGE);
                }
        return n;
    }

    public static ArrayList<Reserva> eliminarReserva(ArrayList<Reserva> reservas, String nombre) {
        Iterator<Reserva> iterator = reservas.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getnDocu().equals(nombre)) {
                iterator.remove();
                JOptionPane.showMessageDialog(null, "Tu reserva ha sido eliminada");
                found = true;
                break; // Si eliminaste la reserva, puedes salir del bucle.
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No se encontró una reserva con este documento", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (reservas.isEmpty()) {
            System.out.println("No hay reservas");
        }
        return reservas;
    }
}
