public class Ingreso extends Dinero {

    public Ingreso (double ingreso, String description){
        this.dinero = ingreso;
        this.description = description;
    }

    //Devuelve el concepto del ingreso
    @Override
    public String toString() {
        return "Ingreso de " + this.dinero +
        " por el concepto de " + this.getDescription() ;
    }
}
