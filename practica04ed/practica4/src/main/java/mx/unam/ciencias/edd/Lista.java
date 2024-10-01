package mx.unam.ciencias.edd;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>Clase genérica para listas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas no aceptan a <code>null</code> como elemento.</p>
 *
 * @param <T> El tipo de los elementos de la lista.
 */
public class Lista<T> implements Coleccion<T> {

    /* Clase interna privada para nodos. */
    private class Nodo {
        /* El elemento del nodo. */
        private T elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(T elemento) {
            this.elemento = elemento;
        }
    }

    /* Clase interna privada para iteradores. */
    private class Iterador implements IteradorLista<T> {
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nuevo iterador. */
        private Iterador() {
            siguiente = cabeza;
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override public boolean hasNext() {
            return siguiente != null;
        }

        /* Nos da el elemento siguiente. */
        @Override public T next() {
            if(!hasNext()) throw new NoSuchElementException("No existe el elemento");
            else {
                T elem = siguiente.elemento;
                anterior = siguiente;
                siguiente = siguiente.siguiente;
                return elem;
            }
        }

        /* Nos dice si hay un elemento anterior. */
        @Override public boolean hasPrevious() {
            return anterior != null;
        }

        /* Nos da el elemento anterior. */
        @Override public T previous() {
            if(!hasPrevious()) throw new NoSuchElementException("No existe el elemento");
            else {
                T elem = anterior.elemento;
                siguiente = anterior;
                anterior = anterior.anterior;
                return elem;
            }
        }

        /* Mueve el iterador al inicio de la lista. */
        @Override public void start() {
            siguiente = cabeza;
            anterior = null;
        }

        /* Mueve el iterador al final de la lista. */
        @Override public void end() {
            siguiente = null;
            anterior = rabo;
        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista. El método es idéntico a {@link
     * #getElementos}.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Regresa el número elementos en la lista. El método es idéntico a {@link
     * #getLongitud}.
     * @return el número elementos en la lista.
     */
    @Override public int getElementos() {
        return getLongitud();
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    @Override public boolean esVacia() {
        return getElementos() == 0;
    }

    /**
     * Agrega un elemento a la lista. Si la lista no tiene elementos, el
     * elemento a agregar será el primero y último. El método es idéntico a
     * {@link #agregaFinal}.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    @Override public void agrega(T elemento) {
        agregaFinal(elemento);
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) {
        if (elemento == null) throw new IllegalArgumentException("El elemento es null");
        longitud++;
        Nodo n = new Nodo(elemento);
        if (esVacia()){
            cabeza = rabo = n;
        } else {
            n.anterior = rabo;
            
            rabo = n;
        }
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(T elemento) {
        if (elemento == null) throw new IllegalArgumentException("El elemento es null");
        longitud++;
        Nodo n = new Nodo(elemento);
        if (esVacia()){
            cabeza = rabo = n;
        } else {
            n.siguiente = cabeza;
            cabeza.anterior = n;
            cabeza = n;
        }
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * @param i el índice dónde insertar el elemento. Si es menor que 0 el
     *          elemento se agrega al inicio de la lista, y si es mayor o igual
     *          que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void inserta(int i, T elemento) {
        if (elemento == null) throw new IllegalArgumentException("El elemento es null");
        if (i <= 0) {
            agregaInicio(elemento);
        } else if(longitud <= i){
            agregaFinal(elemento);
        } else {
            Nodo n = cabeza;
            for (int j = 0; j < i; j++) {
                n = n.siguiente;
            }
            Nodo elem = new Nodo(elemento);
            elem.anterior = n.anterior;
            elem.siguiente = n;
            n.anterior.siguiente = elem;
            n.anterior = elem;
            longitud++;
        }
    }

    /**
     * Método auxiliar que busca un Nodo.
     */
    private Nodo buscaNodo(T elemento){
        Nodo n = cabeza;
        if (elemento == null){
            return null;
        }
        while (n != null) {
            if(n.elemento.equals(elemento))
                return n;
                n = n.siguiente;
            }
        return null;
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    @Override public void elimina(T elemento) {
        eliminaNodo(buscaNodo(elemento));
    }

    private void eliminaNodo(Nodo n) {
        if (n == null) return;
        if (n == cabeza) eliminaPrimero();
        else if (n == rabo) eliminaUltimo();
        else {
            n.anterior.siguiente = n.siguiente;
            n.siguiente.anterior = n.anterior;
            longitud--;
        }
    }

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() {
        if (esVacia())
            throw new NoSuchElementException();
        Nodo n = cabeza;
        if (getElementos() == 1){
            limpia();
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
            longitud--;
        }
        return n.elemento;
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaUltimo() {
        if(esVacia()) throw new NoSuchElementException();
        Nodo n = rabo;
        if (getElementos() == 1){
            limpia();
        } else {
            rabo = rabo.anterior;
            rabo.siguiente = null;
            longitud--;
        }
        return n.elemento;
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean contiene(T elemento) {
        return buscaNodo(elemento) != null;
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public Lista<T> reversa() {
        Lista<T> reversa = new Lista<>();
        Nodo n = cabeza;
        while (n != null) {
            reversa.agregaInicio(n.elemento);
            n = n.siguiente;
        }
        return reversa;
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public Lista<T> copia() {
        Lista<T> copia = new Lista<>();
        Nodo n = cabeza;
        while (n != null) {
            copia.agregaFinal(n.elemento);
            n = n.siguiente;
        }
        return copia;
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    @Override public void limpia() {
        longitud = 0;
        cabeza = rabo = null;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getPrimero() {
        if (esVacia()) throw new NoSuchElementException();
        return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getUltimo() {
        if (esVacia()) throw new NoSuchElementException();
        return rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public T get(int i) {
        if (i < 0 || i >= longitud)
        throw new ExcepcionIndiceInvalido("Índice inválido: " + i);
        
        Nodo n = cabeza;
        for (int j = 0; j < i; j++) {
            n = n.siguiente;
        }
        return n.elemento;
    }
    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(T elemento) {
        Nodo n = cabeza;
        int index = 0;
        while (n != null) {
            if (n.elemento.equals(elemento)) {
                return index;
            }
            n = n.siguiente;
            index++;
        }
        return -1;  // Elemento no encontrado
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */

    @Override
    public String toString() {
        if (esVacia()) {
            return "[]";
        }
    
        StringBuilder sb = new StringBuilder("[");
        Nodo n = cabeza;
        while (n != null) {
            sb.append(n.elemento);
            if (n.siguiente != null) {
                sb.append(", ");
            }
            n = n.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la lista es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto)
        return true;
        if (objeto == null || getClass() != objeto.getClass())
        return false;

    Lista<T> lista = (Lista<T>) objeto;
    if (longitud != lista.longitud)
        return false;
    Nodo n1 = this.cabeza;
    Nodo n2 = lista.cabeza;
    while (n1 != null && n2 != null) {
        if (!n1.elemento.equals(n2.elemento))
            return false;
        n1 = n1.siguiente;
        n2 = n2.siguiente;
    }
    return true;
}


    /**
     * Regresa un iterador para recorrer la lista en una dirección.
     * @return un iterador para recorrer la lista en una dirección.
     */
    @Override public Iterator<T> iterator() {
        return new Iterador();
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas direcciones.
     * @return un iterador para recorrer la lista en ambas direcciones.
     */
    public IteradorLista<T> iteradorLista() {
        return new Iterador();
    }
}