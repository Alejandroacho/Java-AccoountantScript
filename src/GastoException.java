public class GastoException extends Exception {
    //Se crea la variable para almacenar el mensaje de error
    private String mensajeError;
    public GastoException () {
        this.mensajeError = "No se puede agregar el " +
        "movimiento porque el saldo no es suficiente.";
    }
    public String getMessage (){
        return mensajeError;
    }
}
