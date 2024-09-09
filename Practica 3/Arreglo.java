import java.util.NoSuchElementException;

/**
 * Clase que implementa la interfaz {@code Coleccion} utilizando un arreglo.
 * Esta clase proporciona metodos para manejar arreglos unidimensionales y multidimensionales,
 * incluyendo soporte para Vectores de Iliffe en arreglos multidimensionales.
 *
 * @param <T> El tipo de elementos que contiene el arreglo.
 */
public class Arreglo<T> implements Coleccion<T> {
    private T[] elementos;
    private Object[] iliffeVector;
    private int longitud;
    private int[] dimensiones;

    /**
     * Constructor para crear un arreglo unidimensional con la capacidad especificada.
     *
     * @param capacidad La capacidad inicial del arreglo.
     * @throws IllegalArgumentException Si la capacidad es negativa.
     */
    @SuppressWarnings("unchecked")
    public Arreglo(int capacidad) {
        if (capacidad < 0) {
            throw new IllegalArgumentException("Capacidad inválida");
        }
        elementos = (T[]) new Object[capacidad];
        longitud = 0;
        dimensiones = new int[]{capacidad};
    }

    /**
     * Constructor para crear un arreglo multidimensional con las dimensiones especificadas.
     *
     * @param dimensiones Las dimensiones del arreglo.
     * @throws IllegalArgumentException Si las dimensiones son inválidas.
     */
    public Arreglo(int... dimensiones) {
        if (dimensiones.length == 0 || dimensiones[0] <= 0) {
            throw new IllegalArgumentException("Dimensiones inválidas");
        }
        this.dimensiones = dimensiones;
        iliffeVector = crearIliffeVector(dimensiones, 0);
    }

    /**
     * Método recursivo para crear los Vectores de Iliffe para arreglos multidimensionales.
     *
     * @param dims Las dimensiones del arreglo.
     * @param nivel El nivel actual de recursión.
     * @return Un vector de objetos que representa la estructura del arreglo multidimensional.
     */
    private Object[] crearIliffeVector(int[] dims, int nivel) {
        int dim = dims[nivel];
        Object[] vector = new Object[dim];
        if (nivel == dims.length - 1) {
            return vector;
        }
        for (int i = 0; i < dim; i++) {
            vector[i] = crearIliffeVector(dims, nivel + 1);
        }
        return vector;
    }

    /**
     * Obtiene el valor en la posicion especificada del arreglo multidimensional.
     *
     * @param indices Los indices para acceder al valor en el arreglo.
     * @return El valor en la posicion especificada.
     * @throws IndexOutOfBoundsException Si el numero de indices es incorrecto o fuera de los limites.
     */
    @SuppressWarnings("unchecked")
    public T getArreglo(int... indices) {
        if (indices.length != dimensiones.length) {
            throw new IndexOutOfBoundsException("Numero incorrecto de indices");
        }
        Object actual = iliffeVector;
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= ((Object[]) actual).length) {
                throw new IndexOutOfBoundsException("Indice fuera de los limites");
            }
            actual = ((Object[]) actual)[indices[i]];
        }
        return (T) actual;
    }

    /**
     * Establece un valor en la posicion especificada del arreglo multidimensional.
     *
     * @param valor El valor a setArreglo.
     * @param indices Los indices para acceder a la posicion en el arreglo.
     * @throws IndexOutOfBoundsException Si el numero de indices es incorrecto o fuera de los limites.
     */
    @SuppressWarnings("unchecked")
    public void setArreglo(T valor, int... indices) {
        if (indices.length != dimensiones.length) {
            throw new IndexOutOfBoundsException("Numero incorrecto de indices");
        }
        Object actual = iliffeVector;
        for (int i = 0; i < indices.length - 1; i++) {
            if (indices[i] < 0 || indices[i] >= ((Object[]) actual).length) {
                throw new IndexOutOfBoundsException("Indice fuera de los limites");
            }
            actual = ((Object[]) actual)[indices[i]];
        }
        ((Object[]) actual)[indices[indices.length - 1]] = valor;
    }

    /**
     * Agrega un nuevo elemento al final del arreglo unidimensional.
     *
     * @param elemento El elemento a agregar.
     * @throws IllegalStateException Si el arreglo esta lleno.
     */
    @Override
    public void agregar(T elemento) {
        if (longitud >= elementos.length) {
            throw new IllegalStateException("El arreglo esta lleno");
        }
        elementos[longitud++] = elemento;
    }

    /**
     * Elimina y retorna el ultimo elemento del arreglo unidimensional.
     *
     * @return El elemento eliminado.
     * @throws NoSuchElementException Si el arreglo esta vacio.
     */
    @Override
    public T eliminar() {
        if (longitud == 0) {
            throw new NoSuchElementException("El arreglo esta vacio");
        }
        T elemento = elementos[--longitud];
        elementos[longitud] = null;  // Liberar referencia
        return elemento;
    }

    /**
     * Obtiene el elemento en la posicion especificada del arreglo unidimensional.
     *
     * @param indice El indice del elemento a getArreglo.
     * @return El elemento en la posicion especificada.
     * @throws IndexOutOfBoundsException Si el indice esta fuera de los limites del arreglo.
     */
    @Override
    public T getArreglo(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("Indice fuera de los limites");
        }
        return elementos[indice];
    }

    /**
     * Verifica si el arreglo unidimensional contiene el elemento especificado.
     *
     * @param elemento El elemento a buscar en el arreglo.
     * @return {@code true} si el arreglo contiene el elemento, {@code false} en caso contrario.
     */
    @Override
    public boolean contiene(T elemento) {
        for (int i = 0; i < longitud; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna la cantidad de elementos actualmente en el arreglo unidimensional.
     *
     * @return El numero de elementos en el arreglo.
     */
    @Override
    public int longitud() {
        return longitud;
    }

    /**
     * Verifica si el arreglo unidimensional esta vacio.
     *
     * @return {@code true} si el arreglo no contiene elementos, {@code false} en caso contrario.
     */
    @Override
    public boolean estaVacio() {
        return longitud == 0;
    }

    /**
     * Devuelve una representacion en forma de cadena del arreglo unidimensional.
     *
     * @return Una cadena que representa el contenido del arreglo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < longitud; i++) {
            sb.append(elementos[i]);
            if (i < longitud - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Metodo auxiliar para mostrar el contenido de un arreglo 2D.
     *
     * @param arreglo El arreglo a mostrar.
     * @param filas El numero de filas del arreglo.
     * @param columnas El numero de columnas del arreglo.
     * @return Una cadena que representa el contenido del arreglo 2D.
     */
    public String mostrarArreglo2D(Arreglo<Integer> arreglo, int filas, int columnas) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sb.append(arreglo.getArreglo(i, j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
