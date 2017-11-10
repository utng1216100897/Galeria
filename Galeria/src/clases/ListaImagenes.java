/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author gerardo
 */
public class ListaImagenes {
    
     private NodoD inicio;
    private NodoD fin;
    private NodoD actual;

    String[] re;

    public ListaImagenes() {
        inicio = null;
        fin = null;
    }

    public void insertarOrden(NodoD nuevo) {
        NodoD aux;
        // caso 1 : Lista vacia
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;

        } else {
            aux = inicio;
            // busca donde se va a insertar la cancion en la lista
            while (aux != null && nuevo.getDatos().getId() > 0) {
                aux = aux.getSig();
            }
            // caso 2: insercion al inicio
            if (aux == inicio) {
                nuevo.setSig(inicio);
                inicio.setAnt(nuevo);
                inicio = nuevo;
            }
            // caso 3: insercion al final
            if (aux == null) {
                fin.setSig(nuevo);
                nuevo.setAnt(fin);
                fin = nuevo;

            }
            // caso 4: insercion en medio
            if (aux != null && aux.getAnt() != null) {
                nuevo.setSig(aux);
                nuevo.setAnt(aux.getAnt());
                aux.getAnt().setSig(nuevo);
                aux.setAnt(nuevo);

            }

        }

    }

    public void setActual(String titulo) {

        NodoD aux;
        int elementos = 0;

        aux = inicio;
        while (aux != null) {
            if (titulo.equalsIgnoreCase(aux.getDatos().getTitulo())) {
                actual = aux;
            }
            aux = aux.getSig();
            elementos++;
        }
    }

    public int recorrerLista() {
        NodoD aux;
        int elementos = 0;

        aux = inicio;
        while (aux != null) {
          
            aux = aux.getSig();
            elementos++;
        }
        return elementos;
    }

    public String[] getLista() {
        NodoD aux;
        int elemento = 0;

        re = new String[recorrerLista()];
        String ayuda = "";

        aux = inicio;
        while (aux != null) {
            ayuda = aux.getDatos().getTitulo();
            re[elemento] = ayuda;
            aux = aux.getSig();
            elemento++;
        }
        return re;
    }

    public String sacarImagen(int i) {
        getLista();
        return re[i];
    }

    public NodoD irPrimero() {
        actual = inicio;
        return inicio;
    }

    public NodoD irUltimo() {
        actual = fin;
        return fin;
    }

    public NodoD irAnterior() {

        if (actual.getAnt() != null) {
            actual = actual.getAnt();
        }

        return actual;
    }

    public NodoD irSiguiente() {
        if (actual.getSig() != null) {
            actual = actual.getSig();
        }
        return actual;
    }

    public NodoD getActual() {
        return actual;
    }

    public boolean eliminar() {
        if (actual == null) {
            return false;
        } else if (actual == inicio) {

            if (actual.getSig() == null) {
                // inicio = actual.getSig();
                // actual.getSig().setAnt(null);
                inicio = null;
                fin = null;
                actual = null;
                System.out.println("lista vacia");
            } else {

                inicio = actual.getSig();
                inicio.setAnt(null);
                System.out.println("lista von un elemento");

            }
            // como elimiar cuando es el ultimo
        } else if (actual == fin) {
            fin = actual.getAnt();
            fin.setSig(null);
            System.out.println("ultimo elemento");
            return true;
        } else {
            actual.getAnt().setSig(actual.getSig());
            actual.getSig().setAnt(actual.getAnt());
            System.out.println("en el medio");
        }
        return true;
    }
    
}
