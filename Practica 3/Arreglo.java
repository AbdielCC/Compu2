import java.util.NoSuchElementException;

/**
 * Clase que implementa la interfaz {@code Coleccion} utilizando un arreglo.
 * Esta clase proporciona métodos para manejar arreglos unidimensionales y multidimensionales,
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
        } else {
            this.dimensiones = dimensiones;
            iliffeVector = crearIliffeVector(dimensiones, 0);
        }
    }

    /**
     * Método recursivo para crear los Vectores de Iliffe para arreglos multidimensionales.
     *
     * @param dims Las dimensiones del arreglo.
     * @param nivel El nivel actual de recursión.
     * @return Un vector de objetos que representa la estructura del arreglo multidimensional.
     */
    private Object[] crearIliffeVector(int[] dims, int nivel) {
        int size = dims[nivel];
        Object[] vector = new Object[size];
        if (nivel == dims.length - 1) {
            for (int i = 0; i < size; i++) {
                vector[i] = null; // Inicialización
            }
        } else {
            for (int i = 0; i < size; i++) {
                vector[i] = crearIliffeVector(dims, nivel + 1);
            }
        }
        return vector;
    }

    /**
     * Método para establecer un valor en una posición específica del arreglo multidimensional.
     *
     * @param valor El valor a establecer.
     * @param indices Los índices para acceder a la posición en el arreglo.
     * @throws IndexOutOfBoundsException Si el número de índices es incorrecto o está fuera de los límites.
     */
    public void establecer(T valor, int... indices) {
        setArreglo(valor, indices);
    }

    /**
     * Establece un valor en la posición especificada del arreglo multidimensional.
     *
     * @param valor El valor a establecer.
     * @param indices Los índices para acceder a la posición en el arreglo.
     * @throws IndexOutOfBoundsException Si el número de índices es incorrecto o fuera de los límites.
     */
    @SuppressWarnings("unchecked")
    public void setArreglo(T valor, int... indices) {
        if (indices.length != dimensiones.length) {
            throw new IndexOutOfBoundsException("Número incorrecto de índices");
        }
        Object actual = iliffeVector;
        for (int i = 0; i < indices.length - 1; i++) {
            actual = ((Object[]) actual)[indices[i]];
        }
        ((Object[]) actual)[indices[indices.length - 1]] = valor;
    }

    /**
     * Obtiene el valor en la posición especificada del arreglo multidimensional.
     *
     * @param indices Los índices para acceder al valor en el arreglo.
     * @return El valor en la posición especificada.
     * @throws IndexOutOfBoundsException Si el número de índices es incorrecto o fuera de los límites.
     */
    @SuppressWarnings("unchecked")
    public T obtener(int... indices) {
        return getArreglo(indices);
    }

    /**
     * Obtiene el valor en la posición especificada del arreglo multidimensional.
     *
     * @param indices Los índices para acceder al valor en el arreglo.
     * @return El valor en la posición especificada.
     * @throws IndexOutOfBoundsException Si el número de índices es incorrecto o fuera de los límites.
     */
    @SuppressWarnings("unchecked")
    public T getArreglo(int... indices) {
        if (indices.length != dimensiones.length) {
            throw new IndexOutOfBoundsException("Numero incorrecto de indices");
        }
        Object actual = iliffeVector;
        for (int i = 0; i < indices.length; i++) {
            actual = ((Object[]) actual)[indices[i]];
        }
        return (T) actual;
    }

    // Metodos para manejo de arreglos unidimensionales y otros metodos de la clase

    @Override
    public void agregar(T elemento) {
        if (longitud >= elementos.length) {
            throw new IllegalStateException("El arreglo esta lleno");
        }
        elementos[longitud++] = elemento;
    }

    @Override
    public T eliminar() {
        if (longitud == 0) {
            throw new NoSuchElementException("El arreglo esta vacio");
        }
        T elemento = elementos[--longitud];
        elementos[longitud] = null;
        return elemento;
    }

    @Override
    public T obtener(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
        }
        return elementos[indice];
    }

    @Override
    public boolean contiene(T elemento) {
        for (int i = 0; i < longitud; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int longitud() {
        return longitud;
    }

    @Override
    public boolean estaVacio() {
        return longitud == 0;
    }

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

    public String mostrarArreglo2D(Arreglo<Integer> arreglo, int filas, int columnas) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sb.append(arreglo.getArreglo(i, j)).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
