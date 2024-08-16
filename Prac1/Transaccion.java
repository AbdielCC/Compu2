import java.util.Date;
/**
 * Clase que nos permite hacer las transacciones bancarias
 */
public class Transaccion implements ITransaccion {
    private int id;
    private ICuenta cuenta;
    private double monto;
    private Date fecha;
    /**
     * Constructor que nos permite crear nuevas transacciones
     * @param id El ID de la transaccion
     * @param cuenta La cuenta de destino que es involucrada la transaccion
     * @param monto El monto a realizar para la transaccion 
     */
    public Transaccion(int id, ICuenta cuenta, double monto) {
        this.id = id;
        this.cuenta = cuenta;
        this.monto = monto;
        this.fecha = new Date();
    }
    /**
     * @param cuenta La cuenta de destino de la transaccion
     * @param monto la cantidad de dinero de la transaccion a enviar 
     * @param fecha la fecha cuando se realizo la transaccion 
     */
    public void registrarTransaccion(ICuenta cuenta, double monto, Date fecha) {
        this.cuenta = cuenta;
        this.monto = monto;
        this.fecha = fecha;
    }
    /**
     * Permite obtener el ID de la transaccion
     * @return id de la transaccion
     */
    public int getId() {
        return id;
    }
    /**
     * Permite obtener la cuenta de envio del efectivo involucrada en la transaccion
     * @return cuenta de envio de la transaccion
     */
    public ICuenta getCuenta() {
        return cuenta;
    }
    /**
     * Permite obtener el monto realizado en la transaccion
     * @return monto realizado en transaccion
     */
    public double getMonto() {
        return monto;
    }
    /**
     * Permite obtener la fecha involucrada en la transaccion
     * @return fecha de realizacion de transaccion
     */
    public Date getFecha() {
        return fecha;
    }
}
