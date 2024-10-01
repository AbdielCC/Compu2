package mx.unam.ciencias.edd;

import mx.unam.ciencias.edd.Lista;

/**
 * Clase que representa la libreta de ajedrez para registrar movimientos.
 */
public class LibretaAjedrez {

        // Lista doblemente ligada para almacenar los movimientos
        private Lista<String> movimientos;
    
        /**
         * Constructor que inicializa la libreta de ajedrez.
         */
        public LibretaAjedrez() {
            movimientos = new Lista<>();  // Iniciaalizacion 
        }

    /**
     * Agrega un nuevo movimiento a la libreta.
     * @param movimiento El movimiento a agregar.
     */
    public void agregarMovimiento(String movimiento) {
        if (movimiento == null) {
            throw new IllegalArgumentException("El movimiento no puede ser nulo");
        }
        movimientos.agregaFinal(movimiento);
    }

    /**
     * Elimina un movimiento específico de la libreta.
     * @param movimiento El movimiento a eliminar.
     */
    public void eliminarMovimiento(String movimiento) {
        movimientos.elimina(movimiento);
    }

    /**
     * Regresa el último movimiento registrado.
     * @return El último movimiento registrado.
     */
    public String obtenerUltimoMovimiento() {
        return movimientos.esVacia() ? null : movimientos.getUltimo();
    }

    /**
     * Busca un movimiento en la libreta.
     * @param movimiento El movimiento a buscar.
     * @return True si el movimiento está en la libreta, false en caso contrario.
     */
    public boolean contieneMovimiento(String movimiento) {
        return movimientos.contiene(movimiento);
    }

    /**
     * Regresa la cantidad total de movimientos registrados.
     * @return El número total de movimientos.
     */
    public int totalMovimientos() {
        return movimientos.getLongitud();
    }

    /**
     * Limpia la libreta de ajedrez.
     */
    public void limpiarLibreta() {
        movimientos.limpia();
    }

    /**
     * Imprime los movimientos en el formato requerido.
     */
    public void imprimirMovimientos() {
        for (String movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }
}
