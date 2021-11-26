public class Gasto extends Dinero {

    public Gasto(double gasto, String description){
        this.dinero = gasto;
        this.description = description;
    }

    //Devuelve el concepto del gasto
    @Override
    public String toString() {
        return "Gasto de " + this.dinero + " en concepto de " + this.getDescription() ;
    }
}
