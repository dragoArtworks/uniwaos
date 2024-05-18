package gestionhotel;

import javax.swing.JOptionPane;
import jdk.nashorn.api.tree.BreakTree;

/**
 *
 * @author USER
 */
public class ArbolHabitaciones {

    private NodoArbol raiz;

    public ArbolHabitaciones() {
        this.raiz = null;
    }

    public ArbolHabitaciones getVariable() {
        return this.getVariable();
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
            raiz.left = insertRec(raiz.left, habitacion);
        }
        return raiz;
    }
    public boolean isEmpty(){
        if (this.raiz==null) {
            return true;
        }
        return false;
    }

    public void printInOrder() {
        System.out.println("Recorrido en orden del árbol:");
        printInOrder(raiz);
    }

    private void printInOrder(NodoArbol node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("Habitación: " + node.nHabitacion.isEsEspecial()
                    + " | esta disponible: " + node.nHabitacion.isDisponibilidad()
                    + " | num habitacion: " + node.nHabitacion.numHabitacion);
            printInOrder(node.right);
        }
    }

    ///////////////////////////////////////////////////////
    /**
     * para obtener la disponibilidad de las habitaciuones y haer reservaciones
     */
    public int dispHabitacionesNormales() {
        int indice = 0;
        indice = dispHabitacionesNormales(raiz);
        JOptionPane.showMessageDialog(null, "indice ++++=" + indice);
        return indice;
    }

//    public int dispHabitacionesNormales(NodoArbol node) {
//        if (node == null) {
//            return 0;
//        }
//        if (node.left != null && node.left.nHabitacion.isDisponibilidad()) {
//            return node.nHabitacion.getNumHabitacion() + 1;
//        }
//        return dispHabitacionesNormales(node.left) + dispHabitacionesNormales(node.right);
//    }
    public int dispHabitacionesNormales(NodoArbol node) {
        if (node == null) {
            return -1; // Indica que no se encontró una habitación disponible
        }
        // Verifica si la habitación del nodo actual está disponible
        if (node.nHabitacion != null && node.nHabitacion.isDisponibilidad()) {
            return node.nHabitacion.getNumHabitacion();
        }
        // Busca recursivamente en el subárbol izquierdo
        int leftResult = dispHabitacionesNormales(node.left);
        if (leftResult != -1) {
            return leftResult; // Si encuentra una habitación disponible en el subárbol izquierdo, retorna su número
        }
        // Si no se encontró en el izquierdo, busca en el derecho
        return dispHabitacionesNormales(node.right);
    }

//    //nodos izquierdos
//    public int dispHabitacionesNormales(NodoArbol node) {
//        int indice = 0;
//        if (node != null) {
//            if (node.left.nHabitacion.isDisponibilidad() && !node.nHabitacion.isEsEspecial()) {
//                indice = node.nHabitacion.getNumHabitacion() + 1;//condicion de verificacion
//            }
//            dispHabitacionesNormales(node.left);
//        }
//        return indice;
//    }
    public int dispHabitacionesEspeciales() {
        int indice = 0;
        indice = dispHabitacionesEspeciales(raiz);
        System.out.println("indice=" + indice);
        return indice;
    }

    private int dispHabitacionesEspeciales(NodoArbol node) {
        int indice = 0;
        if (node != null) {
            if (node.right != null && node.right.nHabitacion.isDisponibilidad()) {
                JOptionPane.showMessageDialog(null, " se puede cambiar");
                int index = node.nHabitacion.getNumHabitacion();
                indice = index ;//condicion de verificacion
            }
            dispHabitacionesEspeciales(node.left);
        }
        return indice;
    }

    //////////////////////////////////////////////////
    //encontrar una habitacion especifica
    public void habitacionesNormalesEnc(int indice) {
        habitacionesNormalesEnc(raiz, indice);
    }

    //nodos izquierdos
    private void habitacionesNormalesEnc(NodoArbol node, int indice) {
        if (node != null) {
            if (node.nHabitacion.getNumHabitacion() == indice) {

                node.nHabitacion.setDisponibilidad(false);
            } else {
                habitacionesNormalesEnc(node.left, indice);
            }

        }
    }

    ////////////////////////////////////////////////////////////
    public void habitacionesNormales() {
        System.out.println("Nodos izquierdos del árbol:");
        habitacionesNormales(raiz);
    }

    //nodos izquierdos
    private void habitacionesNormales(NodoArbol node) {
        if (node != null) {
            System.out.println("Habitación especial: " + node.nHabitacion.isEsEspecial() + " idHabitacion: " + node.nHabitacion.getNumHabitacion());
            habitacionesNormales(node.left);
        }
    }

    public void habitacionesEspeciales() {
        System.out.println("Nodos derechos del árbol:");
        habitacionesEspeciales(raiz);
    }

    private void habitacionesEspeciales(NodoArbol node) {
        if (node != null) {
            System.out.println("Habitación especial: " + node.nHabitacion.isEsEspecial() + " idHabitacion: " + node.nHabitacion.getNumHabitacion());
            habitacionesEspeciales(node.right);
        }
    }

}
