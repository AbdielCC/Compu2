/**
 * Representa los ahorros del cliente
 */
public class CuentaAhorros extends Cuenta {
    private double tasaInteres;
    /**
     * Constructor para crear la cuenta de ahorros
     * @param id el ID de la cuenta a crear 
     * @param balanceInicial representa el efectivo inicial de la cuenta
     * @param tasaInteres La tasa de interes aplicada a la cuenta
     */
    public CuentaAhorros(int id, double balanceInicial, double tasaInteres) {
        super(id, balanceInicial);
        this.tasaInteres = tasaInteres;
    }
    /**
     * Se Aplicara la tasa de interes a la cuenta de ahorros
     */
    public void aplicarInteres() {
        balance += balance * tasaInteres;
    }
}
