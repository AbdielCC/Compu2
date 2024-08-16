/**
 * Son los clientes del banco
 */
public class Cliente implements ICliente {
    private int id;
    private String nombre;
    private ICuenta[] cuentas;
    private int numCuentas;
    /**
     * Constructor de cliente, nos permite crear nuevos clientes
     * @param id El ID del cliente 
     * @param nombre nombre completo del cliente 
     */
    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.cuentas = new ICuenta[10]; // Máximo de 10 cuentas por cliente
        this.numCuentas = 0;
    }
    /**
     * Permite obtener la id del cliente
     * @return la id del cliente 
     */
    public int getId() {
        return id;
    }
    /**
     * Permite obtener el nombre del cliente
     * @return nombre del cliente 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Abre la nueva cuenta del cliente 
     * @param cuenta la cuenta del cliente 
     */
    public void abrirCuenta(ICuenta cuenta) {
        if (numCuentas < cuentas.length) {
            cuentas[numCuentas++] = cuenta;
        } else {
            System.out.println("No se pueden abrir más cuentas");
        }
    }
    /**
     * Permite cerrar la cuenta del cliente
     * @param cuentaID El id de la cuenta a cerrar 
     */
    public void cerrarCuenta(int cuentaID) {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getId() == cuentaID) {
                cuentas[i] = cuentas[--numCuentas];
                cuentas[numCuentas] = null;
                return;
            }
        }
        System.out.println("Cuenta no encontrada");
    }
    /**
     * Obtiene la cuenta del cliente por su ID
     * @param cuentaID El id de la cuenta
     * @return cuenta de la que se ingreso el ID
     */
    public ICuenta obtenerCuenta(int cuentaID) {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getId() == cuentaID) {
                return cuentas[i];
            }
        }
        return null;
    }
}
