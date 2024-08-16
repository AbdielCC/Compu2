/**
 * En esta interfaz representaremos la cuanta bancaria
 */
public interface ICuenta {
  /**
   * Depositaremos la cantidad de dinero enviada en la cuenta
   * @param monto El monto a depositar en la cuenta 
   */
    void depositar(double monto);
    /**
     * Se retirara la cantidad de dinero en la cuenta
     * @param monto La cantdad de dinero a retirar
     */
    void retirar(double monto);
    /**
     * Se consultara los ingresos y los egresos de la cuenta, i.e. el balance de la cuenta
     * @return El balance de la cuenta
     */
    double consultarBalance();
    int getId(); 
}
