import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    //Lectura por teclado
    private static Scanner lectura = new Scanner (System.in);
    //Almacena el nombre de usuario
    private static String nombreUsuario;
    //Almacena la edad en formato texto
    private static String posibleEdadUsuario;
    //Almacena el DNI en formato texto
    private static String DNIUsuario;
    //Almacena un nuevo usuario
    private static Usuario nuevoUsuario;
    //Se utiliza para comprobar que el usuario ponga la edad correcta
    private static int edadUsuario;
    //Se utiliza para almacenar una nueva cuenta
    private static Cuenta nuevaCuenta;

    private static boolean introducirUsuario() {
        // Bucle para la asignacion del nombre de usuario
        do{
            //Se pregunta el nombre de usuario
            System.out.println("Introduzca el nombre de usuario: ");
            //Se guarda en la variable nombre
            nombreUsuario = lectura.nextLine();
            //Se pasa a mayusculas
            nombreUsuario = nombreUsuario.toUpperCase();
        }while (nombreUsuario.isEmpty());

        // Bucle para la asignacion de la edad
        do{
            //Se pregunta la edad del usuario
            System.out.println("Introduzca la edad del usuario: ");
            //Se almacena la edad del usuario en la variable
            posibleEdadUsuario = lectura.nextLine();
            try{
                //Intentamos convertirlo a numero. Hacemos esto para saber si el usuario introdujo un numero
                edadUsuario = Integer.parseInt(posibleEdadUsuario);
                //Si el numero es menor o igual a 0 se muestra el mensaje
                if (edadUsuario<=0){
                    System.out.println("La edad debe ser mayor que cero: ");
                }
            }
            //Se muestra  la excepcion en donde se pide que se introduzca un numero mayor que 0
            catch (Exception e){
                System.out.println("Debes introducir un numero.");
            }

        }while (posibleEdadUsuario.isEmpty() || edadUsuario<=0);

        // Bucle para la asignacion del DNI
        do {
            //Se pregunta el DNI al usuario
            System.out.println("Introduzca el DNI del usuario: ");
            //Se almacena el DNI del usuario en la variable
            DNIUsuario = lectura.nextLine();
            //Lo pasamos a mayusuculas
            DNIUsuario = DNIUsuario.toUpperCase();
        }while(DNIUsuario.isEmpty() || DNIUsuario.length()<9 || DNIUsuario.length()>10);
        System.out.println("*******************************");
        //Se devuelve true
        return true;
    }
    //Metodo que crea el usuario
    private static void crearUsuario(){
        //Se agregan los datos que se pidieron por teclado
        nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombreUsuario);
        nuevoUsuario.setEdad(edadUsuario);
        nuevoUsuario.setDNI(DNIUsuario);

    }
    //Se crea la variable que almacenara lo que elija el usuario
    private static int opcionSeleccionada;
    private static void seleccionarOperacion(){
        //Se muestra el menu y se pregunta por una opción
        System.out.println("Realiza una nueva acción");
        System.out.println("1. Introduce un nuevo gasto");
        System.out.println("2. Introduce un nuevo ingreso");
        System.out.println("3. Mostrar gastos");
        System.out.println("4. Mostrar ingresos");
        System.out.println("5. Mostrar saldo");
        System.out.println("0. Salir");
        do{
            System.out.println("Selecciona una opcion: ");
            opcionSeleccionada = lectura.nextInt();
        }while(opcionSeleccionada<0 || opcionSeleccionada>5);
        //Se hace limpieza de buffer
        lectura.nextLine();
    }
    //Variable para almacenar el importe
    private static double importe;
    //Variable para almacenar la descripcion del movimiento
    private static String descriptionMovimiento;

    private static boolean insertarDatosGasto (){
        do{
            //Se pide el concepto del gasto
            System.out.println("Introduzca el concepto del nuevo gasto: ");
            //Se almacena en la variable
            descriptionMovimiento = lectura.nextLine();
        }while (descriptionMovimiento.isEmpty());

        do {
            //Se pide el importe del gasto
            System.out.println("Introduzca el importe del gasto: ");
            //Se almacena el importe en la variable
            importe = lectura.nextDouble();
        }while (importe < 0);
        //Se retorna true
        return true;
    }
    //Almacena la lista de gastos
    private static List <Gasto> gastos=  new ArrayList<Gasto>();
    //El metodo crea un objeto de tipo gasto y agrega a la lista de gastos el nuevo gasto
    private static void agregarGasto(){
        //Se crea un nuevo gasto
        Gasto nuevoGasto = new Gasto(importe,descriptionMovimiento);
        //se le establece la descripcion y el importe
        nuevoGasto.setDescription(descriptionMovimiento);
        nuevoGasto.setDinero(importe);
        //se añade el nuevo gasto a la lista
        gastos.add(nuevoGasto);
    }
    private static boolean insertarDatosIngreso () {
        do {
            //Se pide el concepto del ingreso
            System.out.println("Introduzca el concepto del nuevo ingreso: ");
            //Se guarda la descripcion del ingreso
            descriptionMovimiento = lectura.nextLine();
        } while (descriptionMovimiento.isEmpty());

        do {
            //Se pide el importe
            System.out.println("Introduzca el importe del ingreso: ");
            importe = lectura.nextDouble();
        } while (importe < 0);
        //Se retorna true
        return true;

    }
    //Se almacena la lista de ingresos
    private static List <Ingreso> ingresos =  new ArrayList<Ingreso>();
    //Crea un objeto de tipo ingreso y agrega a la lista de ingresos el nuevo ingreso
    private static void agregarIngreso(){
        //Se crea un nuevo ingreso
        Ingreso nuevoIngreso = new Ingreso(importe, descriptionMovimiento);
        //Se establecen los valores
        nuevoIngreso.setDescription(descriptionMovimiento);
        nuevoIngreso.setDinero(importe);
        //Se agrega el ingreso a la lista
        ingresos.add(nuevoIngreso);
    }
    //Ejecución del programa
    public static void main (String[] args) throws GastoException {
        if (introducirUsuario()){
            crearUsuario(); // Se crea el usuario
            nuevaCuenta = new Cuenta(nuevoUsuario); //Se crea la cuenta para almacenar los ingresos
            seleccionarOperacion();
            do { //Se muestran las opciones
                switch (opcionSeleccionada){ // se hace como minimo una vez
                    case 1:
                        //Si el metodo devuelve true es que los datos son correctos
                        if(insertarDatosGasto()) {
                            if (importe > nuevaCuenta.getSaldo()) {
                                // Si el importe es mayor que el saldo se lanza la excepción
                                System.out.println(new GastoException());

                            } else
                                agregarGasto(); //Se agrega un nuevo gasto
                            nuevaCuenta.addGastos(descriptionMovimiento, importe); //Se actualiza el estado de cuenta
                        }   nuevaCuenta.setGastos(gastos);// Se agrega a la lista de gastos
                        seleccionarOperacion();
                        break;
                    case 2:
                        if (insertarDatosIngreso()){
                            agregarIngreso();// Se agrega el ingreso
                            nuevaCuenta.addIngresos(descriptionMovimiento,importe); //Se agrega ek ingreso a la cuenta
                            nuevaCuenta.setIngresos(ingresos);

                        }
                        seleccionarOperacion();
                        break;
                    case 3:
                        if (nuevaCuenta.getGastos() == null){ //Se muestra un mensaje de informacion
                            System.out.println("No existen movimientos de gastos");
                        }
                        else {
                            System.out.println(nuevaCuenta.getGastos());

                        }seleccionarOperacion();
                        break;
                    case 4:
                        if (nuevaCuenta.getIngresos() == null){ //Se muestra un mensaje de informacion
                            System.out.println("No existen movimientos de ingresos");
                        }
                        else {
                            System.out.println(nuevaCuenta.getIngresos());

                        }seleccionarOperacion();
                        break;
                    case 5:
                        System.out.println(nuevaCuenta.toString());
                        seleccionarOperacion();
                        break;
                    case 0:
                }

            }while (opcionSeleccionada !=0 || opcionSeleccionada>5);

            System.out.println("El programa ha finalizado. "
                    + "Gracias por utilizar la aplicacion.");

        }lectura.close();
    }
}
