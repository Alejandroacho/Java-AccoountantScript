public abstract class Dinero {
    //Metodos protegidos
    protected double dinero;
    protected String description;

    //Devuelve el dinero
    public double getDinero(){
        return dinero;
    }

    //Establece el dinero
    public void setDinero (double dinero){
        this.dinero = dinero;
    }

    //Devuelve la descripción
    public String getDescription(){
        return description;
    }
    //Establece la descripción
    public void setDescription (String description){
        this.description = description;
    }

}