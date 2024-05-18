package gestionhotel;
import javax.swing.JOptionPane;

/**
 *
 * @author MICHAEL NARANJO
 */
public class Reserva {

    String nombre = "";
    int nDocu = 0;
    int edad = 0;
//   int fechaReserva = 0;
    String telefono = "";
    int tiempoEstadia = 0;
    int numeroPersonas = 0;
    boolean esEspecial=false; //revisar
    int idHabitacion;     //revisar
    boolean[] diasReservados = new boolean[10];

    public Reserva() {
    }

    public Reserva(String nombre, int nDocu, int edad, String telefono, int tiempoEstadia, int numeroPersonas,int idHabitacion) {
        this.nombre = nombre;
        this.nDocu = nDocu;
        this.edad = edad;
//        this.fechaReserva = fechaReserva;
        this.telefono = telefono;
        this.tiempoEstadia = tiempoEstadia;
        this.numeroPersonas = numeroPersonas;
        this.idHabitacion=idHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getnDocu() {
        return nDocu;
    }

    public void setnDocu(int nDocu) {
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
                + "Numero de Personas=" + numeroPersonas +"\n"
                +"Numero de habitacion=" + idHabitacion;
    }

    public boolean ReservarHabitacion(int diaInicial, int diasOcupados) {
        int indice = diaInicial-1;
        if (diasReservados[indice] == false && diasReservados[indice + (diasOcupados-1)] == false && ((indice + (diasOcupados-1)) <= 10)) {
            for (int i = 0; i < diasOcupados; i++) {
                JOptionPane.showMessageDialog(null, "indice="+indice);
                diasReservados[indice] = true;
                indice++;
            }
            String dias="";
            for (boolean diasReservado : diasReservados) {
                dias+=diasReservado+"\n";
            }JOptionPane.showMessageDialog(null, dias);
            return true;
        } else {
            return false;
        }
    }
}