public class Usuario {
    private String nombre;
    private int edad;
    private String DNI;

    public Usuario() {
    }

    //GETTERS Y SETTERS
    //Devuelve el nombre
    public String getNombre() {
        return nombre;
    }
    //Establece el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Devuelve la edad
    public int getEdad() {
        return edad;
    }
   //Establece la edad
    public void setEdad(int edad) {
        this.edad = edad;
    }
    //Devuelve el DNI
    public String getDNI() {
        return DNI;
    }
    //Establece el DNI con sus parametros
    public boolean setDNI(String DNI) {
        if (DNI.matches("^[0-9]{8}[a-zA-Z]$")){
            this.DNI = DNI;
            return true;
        }
        else {
            return false;
        }
    }
    //Devuelve los datos ingresados
    @Override
    public String toString () {
        return "Nombre: " + nombre + "/n"
             + "Edad: " + edad + "/n"
             + "DNI: " + DNI ;
    }
}
