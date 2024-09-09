/**
 * Representa una colección genérica de elementos de tipo {@code T}.
 * Esta interfaz define los métodos básicos que cualquier estructura de datos que
 * implemente esta interfaz debe proporcionar.
 *
 * @param <T> El tipo de elementos que contiene la colección.
 */
public interface Coleccion<T> {

    /**
     * Agrega un nuevo elemento a la colección.
     *
     * @param elemento El elemento a agregar.
     */
    public void agregar(T elemento);

    /**
     * Elimina y retorna el elemento de la colección.
     *
     * @return El elemento eliminado.
     * @throws NoSuchElementException Si la colección está vacía.
     */
    public T eliminar();

    /**
     * Obtiene el elemento en la posición especificada de la colección.
     *
     * @param índice El índice del elemento a obtener.
     * @return El elemento en la posición especificada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites de la colección.
     */
    public T obtener(int índice);

    /**
     * Verifica si la colección contiene el elemento especificado.
     *
     * @param elemento El elemento a buscar en la colección.
     * @return {@code true} si la colección contiene el elemento, {@code false} en caso contrario.
     */
    public boolean contiene(T elemento);

    /**
     * Retorna la cantidad de elementos en la colección.
     *
     * @return El número de elementos en la colección.
     */
    public int longitud();

    /**
     * Verifica si la colección está vacía.
     *
     * @return {@code true} si la colección no contiene elementos, {@code false} en caso contrario.
     */
    public boolean estaVacio();
}
