
import java.util.List;

public class Cuenta {
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

    public Cuenta (Usuario usuario){
        this.usuario = usuario;
        this.saldo = 0;
    }

    //Establece el saldo
    public void setSaldo (double saldo){
        this.saldo = saldo;
    }
    //Devuelve el saldo
    public double getSaldo(){
        return saldo;
    }
    //Establece el usuario
    public void setUsuario (Usuario usuario){
        this.usuario = usuario;
    }
    //Devuelve el usuario
    public Usuario getUsuario() {
        return usuario;
    }
    //Crea una lista de gastos
    public void setGastos (List<Gasto> gastos){
        this.gastos = gastos;
    }
    //Devuelve una lista de gastos
    public List<Gasto> getGastos(){
        return gastos;
    }
    //Crea una lista de ingresos
    public void setIngresos (List<Ingreso> ingresos){
        this.ingresos = ingresos;
    }
    //Devuelve una lista de ingresos
    public List<Ingreso> getIngresos(){
        return ingresos;
    }
    //Agrega un ingreso y lo suma con el saldo
    public double addIngresos (String description, double cantidad){
        this.saldo = this.saldo + cantidad;
        return saldo;
    }
    //Agrega un gasto y lo resta con el saldo
    public double addGastos (String description, double cantidad){
        this.saldo = this.saldo - cantidad;
        return saldo;
    }

    //Devuelve el saldo de la cuenta como un string
    @Override
    public String toString(){
        return "El saldo de tu cuenta es " + this.saldo + " euros.";
    }
}

