package gestionhotel;

/**
 *
 * @author USER
 */
public class ArbolHabitaciones {

    private NodoArbol raiz;

    public ArbolHabitaciones() {
        this.raiz = null;
    }

    public void insertar(Habitacion habitacion) {
        raiz = insertRec(raiz, habitacion);
    }

    private NodoArbol insertRec(NodoArbol raiz, Habitacion habitacion) {
        if (raiz == null) {
            raiz = new NodoArbol(habitacion);
            return raiz;
        }
        if (habitacion.isEsEspecial() != raiz.nHabitacion.isEsEspecial()) {
            if (habitacion.isEsEspecial()) {
                raiz.left = insertRec(raiz.left, habitacion);
            } else {
                raiz.right = insertRec(raiz.right, habitacion);
            }
        } else {
            // You can decide the logic if the nodes with the same special status are to be handled
            // For example, in this case, you might decide to insert them to the left
            raiz.left = insertRec(raiz.left, habitacion);
        }
        return raiz;
    }

    public void printInOrder() {
        System.out.println("Recorrido en orden del árbol:");
        printInOrder(raiz);
    }

    private void printInOrder(NodoArbol node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("Habitación: " + node.nHabitacion.isEsEspecial());
            printInOrder(node.right);
        }
    }
      public void habitacionesNormales() {
        System.out.println("Nodos izquierdos del árbol:");
        habitacionesNormales(raiz);
    }
    //nodos izquierdos
    private void habitacionesNormales(NodoArbol node) {
        if (node != null) {
            System.out.println("Habitación especial: " + node.nHabitacion.isEsEspecial()+" idHabitacion: "+ node.nHabitacion.getNumHabitacion());
            habitacionesNormales(node.left);
        }
    }
     public void habitacionesEspeciales() {
        System.out.println("Nodos derechos del árbol:");
        habitacionesEspeciales(raiz);
    }

    private void habitacionesEspeciales(NodoArbol node) {
        if (node != null) {
            System.out.println("Habitación especial: " + node.nHabitacion.isEsEspecial()+" idHabitacion: "+ node.nHabitacion.getNumHabitacion());
            habitacionesEspeciales(node.right);
        }
    }

}
