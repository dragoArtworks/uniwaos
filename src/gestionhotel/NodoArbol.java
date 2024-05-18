package gestionhotel;

/**
 *
 * @author USER
 */
public class NodoArbol {
    Habitacion nHabitacion;
    NodoArbol left;
    NodoArbol right;

    public NodoArbol(Habitacion habitacion) {
        this.nHabitacion = habitacion;
        this.left = null;
        this.right = null;
    }
}
