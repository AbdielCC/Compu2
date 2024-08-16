/**
 * En esta clase se manejan los clientes y las transacciones
 */
public class Banco{
    private Cliente[] clientes;
    private int numClientes;
    /**
     * Constructor que nos permite crear un Banco con sus respectivos clientes 
     */
    public Banco() {
        this.clientes = new Cliente[100]; // Máximo de 100 clientes
        this.numClientes = 0;
    }
    /**
     * Da de alta un cliente al banco
     * @param cliente El cliente a dar de alta
     */
    public void agregarCliente(Cliente cliente) {
        if (numClientes < clientes.length) {
            clientes[numClientes++] = cliente;
        } else {
            System.out.println("No se pueden agregar más clientes");
        }
    }
    /**
     * Da de baja a un cliente con su ID
     * @param clienteID El ID del cliente que se quiere dear de baja
     */
    public void eliminarCliente(int clienteID) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getId() == clienteID) {
                clientes[i] = clientes[--numClientes];
                clientes[numClientes] = null;
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }
    /**
     * Busca al cliente por su ID
     * @param clienteID El id del cliente
     * @return El cliente buscado por el ID
     */
    public Cliente buscarCliente(int clienteID) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getId() == clienteID) {
                return clientes[i];
            }
        }
        return null;
    }
    /**
     * Registra una transaccion del banco 
     * @param transaccion la transaccion a realizar
     */
    public void registrarTransaccion(Transaccion transaccion) {
        transaccion.registrarTransaccion(transaccion.getCuenta(), transaccion.getMonto(), transaccion.getFecha());
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        System.out.println("Bienvenido");
        Cliente cliente1 = new Cliente(1, "Juan Perez");
        banco.agregarCliente(cliente1);

        CuentaAhorros cuentaAhorros = new CuentaAhorros(1, 500, 0.05);
        cliente1.abrirCuenta(cuentaAhorros);

        cuentaAhorros.depositar(200);
        cuentaAhorros.retirar(150);
        cuentaAhorros.aplicarInteres();

        Transaccion transaccion1 = new Transaccion(1, cuentaAhorros, 200);
        banco.registrarTransaccion(transaccion1);
    }
}
