/**
 * Reoresentan las cuentas de cheques, estas pueden tener sobregiros con previo acuerdo del banco
 */
public class CuentaCheques extends Cuenta {
    private double sobregiro;
    /**
     * Constructor para crear nuevas cuentas de cheques
     * @param id ID de la cuenta del cliente
     * @param balanceInicial El monto que tiene permitido hacer sobregiro
     */
    public CuentaCheques(int id, double balanceInicial, double sobregiro) {
        super(id, balanceInicial);
        this.sobregiro = sobregiro;
    }
    /**
     * Consultar cuento te permite el banco de tener sobregiro
     * @return el monto de sobregiro permitido
     */

    public double consultarSobregiro() {
        return sobregiro;
    }
    /**
     * Permite retirar dinero de la cuenta con un excedente permitido por el banco (sobregiro)
     * @param monto Cantidad de dinero a retirar
     */
    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= balance + sobregiro) {
            balance -= monto;
        } else {
            System.out.println("No hay suficiente dinero en la cuenta");
        }
    }
}
