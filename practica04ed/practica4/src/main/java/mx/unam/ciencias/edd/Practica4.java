package mx.unam.ciencias.edd;

/**
 * Práctica 4: Uso de Lista Ajedrez.
 */
public class Practica4 {

    public static void main(String[] args) {
        LibretaAjedrez libreta = new LibretaAjedrez();

        // Agregar movimientos
        libreta.agregarMovimiento("e4");
        libreta.agregarMovimiento("e5");
        libreta.agregarMovimiento("Nf3");
        libreta.agregarMovimiento("Nc6");

        // Imprimir movimientos
        System.out.println("Movimientos registrados:");
        libreta.imprimirMovimientos();

        // Obtener y eliminar el último movimiento
        System.out.println("Último movimiento: " + libreta.obtenerUltimoMovimiento());
        libreta.eliminarMovimiento("Nc6");

        // Imprimir movimientos después de eliminar
        System.out.println("Movimientos después de eliminar Nc6:");
        libreta.imprimirMovimientos();

        // Comprobar si contiene un movimiento
        System.out.println("¿Contiene e4? " + libreta.contieneMovimiento("e4"));

        // Limpiar la libreta
        libreta.limpiarLibreta();
        System.out.println("Total de movimientos después de limpiar: " + libreta.totalMovimientos());
    }
}
