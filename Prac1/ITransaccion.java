import java.util.Date; // Importa la clase Date
/**
 * En esta interfaz se realizan las diferentes transacciones bancarias
 */
public interface ITransaccion {
  /**
   * Se registra a una cuenta en especifico
   * @param cuenta representa la cuenta de destino de la transaccion
   * @param monto representa el monto de la transaccion a realizar 
   * @param fecha indica la fecha que se realizo la transaccion
   */
    void registrarTransaccion(ICuenta cuenta, double monto, Date fecha);
}
