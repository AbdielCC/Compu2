public interface ICliente {
  /**
   * Se abrira y creara una cuenta nueva para el cliente
   * @param cuenta representa la cuenta que se abrira
   */
    void abrirCuenta(ICuenta cuenta);
    /**
     * Se cerrara la cuenta del cliente
     * @param cuentaID representa la llave identificadora de la cuenta a cerrar
     */
    void cerrarCuenta(int cuentaID);
    /**
     * Obtiene la cuenta especifica del cliente por su ID
     * @param cuentaID representa la llave con el que se identificara la cuenta a obtener informacion
     * @return  la cuenta correspondiente al id
     */
    ICuenta obtenerCuenta(int cuentaID);
}