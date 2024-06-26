package gestionhotel;

import javax.swing.JOptionPane;
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

    public boolean isEmpty() {
        return this.raiz == null;
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

    /**
     * para obtener la disponibilidad de las habitaciuones y haer reservaciones
     */
    public int dispHabitacionesNormales() {
        int indice = 0;
        indice = dispHabitacionesNormales(raiz);
        return indice;
    }
    public int dispHabitacionesNormales(NodoArbol node) {
        if (node == null) {
            
            if(isEmpty()){
            }
            return -1; // Indica que no se encontró una habitación disponible
            
        }
        // Verifica si la habitación del nodo actual está disponible
        if (node.nHabitacion != null && node.nHabitacion.isDisponibilidad()&& !node.nHabitacion.isEsEspecial()) {
            int a = node.nHabitacion.getNumHabitacion();
            return a;
        }
        // Busca recursivamente en el subárbol izquierdo
        int leftResult = dispHabitacionesNormales(node.left);
        if (leftResult != -1) {
            return leftResult; // Si encuentra una habitación disponible en el subárbol izquierdo, retorna su número
        }
        // Si no se encontró en el izquierdo, busca en el derecho
        return dispHabitacionesNormales(node.right);
    }

    public int dispHabitacionesEspeciales() {
        int indice = 0;
        indice = dispHabitacionesEspeciales(raiz);
        System.out.println("indice °°" + indice);
        return indice;
    }
     public int dispHabitacionesEspeciales(NodoArbol node) {
        if (node == null) {
            return -1; // Indica que no se encontró una habitación disponible
        }
        // Verifica si la habitación del nodo actual está disponible
        if (node.nHabitacion != null && node.nHabitacion.isDisponibilidad() && node.nHabitacion.isEsEspecial()) {
            int a = node.nHabitacion.getNumHabitacion();
            return a;
        }
        // Busca recursivamente en el subárbol izquierdo
        int leftResult = dispHabitacionesEspeciales(node.left);
        if (leftResult != -1) {
            return leftResult; // Si encuentra una habitación disponible en el subárbol izquierdo, retorna su número
        }
        // Si no se encontró en el izquierdo, busca en el derecho
        return dispHabitacionesEspeciales(node.right);
    }

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
                habitacionesNormalesEnc(node.right, indice);
            }
        }
    }

    public void habitacionesEspecialesEnc(int indice) {
        habitacionesEspecialesEnc(raiz, indice);
    }

    //nodos izquierdos
    private void habitacionesEspecialesEnc(NodoArbol node, int indice) {
        if (node != null) {
            if (node.nHabitacion.getNumHabitacion() == indice) {
                node.nHabitacion.setDisponibilidad(false);
            } else {
                habitacionesEspecialesEnc(node.left, indice);
                habitacionesEspecialesEnc(node.right, indice);
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
