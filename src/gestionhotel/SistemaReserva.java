package gestionhotel;

import javax.swing.JOptionPane;
import javax.swing.JTree;

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
        ArbolHabitaciones arbol = new ArbolHabitaciones();
        
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
      ///////////////////////////////////////////////////////////////////////////////////
        int idHabitacion=0;
      //////////////////////////////////////////////////////////////////////////////////
        JOptionPane.showMessageDialog(null, nuevaReserva);
        if(nuevaReserva.ReservarHabitacion(diaInicial, tiempoEstadia)){
            
            nuevaReserva=new Reserva(nombre, nDocu, edad, telefono, tiempoEstadia, numeroPersonas, idHabitacion);
       //     nuevaReserva=new Reserva(nombre,nDocu, edad, telefono, tiempoEstadia, numeroPersonas);
            JOptionPane.showMessageDialog(null, nuevaReserva);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la reserva");
        }
        

        // Crear 4 objetos tipo habitación con esEspecial = false
        for (int i=0;i<4;i++) {
            Habitacion habitacionNormal = new Habitacion(false);
            habitacionNormal=new Habitacion(i+2);
            arbol.insertar(habitacionNormal);
        }

        // Crear 2 objetos tipo habitación con esEspecial = true
        for (int i=0;i<2;i++) {
            Habitacion habitacionEspecial = new Habitacion(true);
            habitacionEspecial =new Habitacion(i);
            habitacionEspecial.setEsEspecial(true);
            arbol.insertar(habitacionEspecial);
        }
        if(arbol.dispHabitacionesNormales()>=1){
            
        }
        // Operaciones adicionales que desees realizar con el árbol
        arbol.printInOrder();
        arbol.habitacionesEspeciales();
        arbol.habitacionesNormales();

    }
    
    
    
        

}