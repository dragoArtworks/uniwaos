package gestionhotel;

import java.security.DrbgParameters;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.swing.JOptionPane;

/**
 *
 * @author MICHAEL NARANJO
 */
public class SistemaReserva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reserva nuevaReserva = new Reserva();
        
        String nombre = "";
        int nDocu = 0;
        int edad = 0;
//      int fechaReserva = 0;
        String telefono = "";
        int tiempoEstadia = 0;
        int numeroPersonas = 0;
        int diaInicial=0;
        
        nombre = JOptionPane.showInputDialog("Ingrese su nombre completo: ");
        nDocu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de documento: "));
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: "));
        telefono = JOptionPane.showInputDialog("Ingrese su numero de telefono: ");
        tiempoEstadia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo de estadia: "));
        numeroPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de personas: "));
        diaInicial= Integer.parseInt(JOptionPane.showInputDialog("Ingrese dia de inicio"));
        
        JOptionPane.showMessageDialog(null, nuevaReserva);
        if(nuevaReserva.ReservarHabitacion(diaInicial, tiempoEstadia)){
            nuevaReserva=new Reserva(nombre, nDocu, edad, telefono, tiempoEstadia, numeroPersonas);
            JOptionPane.showMessageDialog(null, nuevaReserva);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la reserva");
        }
    }
}