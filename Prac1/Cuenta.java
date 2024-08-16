/**
 * Es la cuenta bancaria que tendra como hijas la cuenta de ahorros y la cuenta de cheques
 */
public class Cuenta implements ICuenta {
    protected int id;
    protected double balance;
  /**
   * Se aplica el constructor para crear una cuenta con ID y el balance inicial de esta cuenta
   */
    public Cuenta(int id, double balanceInicial) {
        this.id = id;
        this.balance = balanceInicial;
    }
    /**
     * Obtiene el ID de la cuenta
     * @return ID de la cuenta 
     */
    public int getId() {
        return id;
    }
    /**
     * Obtiene el balance de la cuenta o saldo 
     * @return saldo de la cuenta
     */
    public double consultarBalance() {
        return balance;
    }
    /**
     * Depositar una cantidad dada en la cuenta 
     * @param monto El monto a depositar en la cuenta 
     */
    public void depositar(double monto) {
        if (monto > 0) {
            balance += monto;
        }
    }
    /**
     * Retira una cantidad de dinero en la cuenta, si hay presupuesto
     * @param monto la cantidad a retirar
     */
    public void retirar(double monto) {
        if (monto > 0 && monto <= balance) {
            balance -= monto;
        } else {
            System.out.println("No hay suficiente dinero en la cuenta");
        }
    }
}
