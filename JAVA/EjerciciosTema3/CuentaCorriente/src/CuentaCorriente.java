import java.util.Scanner;

public class CuentaCorriente {

    public static void main(String[] args) {
       
        Cliente cliente = null;
        Scanner sc = new Scanner(System.in);
        int dato = 0;

        do {
            System.out.println("\n--------MENU-----------");
            System.out.println("[1] Crear Cliente");
            System.out.println("[2] Sacar Dinero");
            System.out.println("[3] Ingresar Dinero"); 
            System.out.println("[4] Ver Saldo");
            System.out.println("[5] Salir");
            System.out.print("Elige una opción: ");
            dato = sc.nextInt();
            
            // Limpiamos el buffer 
            sc.nextLine(); 

            switch (dato) {
                case 1:
                    
                    cliente = crearCliente(sc);
                    
                    break;
                case 2:
                   
                    if (cliente != null) {
                        
                        sacarDinero(cliente, sc);
                    } else {
                        System.out.println("Error: Primero debes crear un cliente.");
                    }
                    break;
                case 3:
                    
                        ingresarDinero(cliente, sc);
        
                    break;
                case 4:
                     
                        System.out.println(cliente.toString());
                    
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Número no correcto.");
            }

        } while (dato != 5);

        sc.close();
    }
    
    
    public static Cliente crearCliente(Scanner sc) {
        String nombre, apellidos, dni;
        
        System.out.println("Nombre del cliente:");
        nombre = sc.nextLine();
        System.out.println("Escribe los apellidos:");
        apellidos = sc.nextLine();
        System.out.println("Escribe el DNI:");
        dni = sc.nextLine();

        Cliente nuevoCliente = new Cliente(nombre, apellidos, dni, 0.0f);
        System.out.println("¡Cliente creado con éxito!");
        return nuevoCliente;
    }

    
    public static void sacarDinero(Cliente cliente, Scanner sc) {
    
    boolean fondoSuficiente = false;

    System.out.println("Tu saldo actual es: " + cliente.getSaldo() + "€");
    System.out.print("¿Qué cantidad quieres retirar? ");
    float dinero = sc.nextFloat();
    sc.nextLine(); // Limpiamos el buffer

    
    if (cliente.getSaldo() == 0.0f) {
        System.out.println("No puedes sacar dinero, estás a 0€");
       
    } else if (cliente.getSaldo() < dinero) {
        System.out.println("No tienes esa cantidad para poder retirar");
        
    } else if (cliente.getSaldo() >= dinero) {
        
        fondoSuficiente = true;
    }

    
    if (fondoSuficiente == true) {
        System.out.println("...Procesando retirada...");
        
        
        cliente.setSaldo(cliente.getSaldo() - dinero);
        
        System.out.println("Retirada realizada con éxito.");
       
        System.out.println(cliente.toString());
    }
}
    
    
    public static void ingresarDinero(Cliente cliente, Scanner sc) {
        System.out.print("¿Qué cantidad quieres ingresar? ");
        float dinero = sc.nextFloat();
        
        if (dinero > 0) {
            cliente.setSaldo(cliente.getSaldo() + dinero);
            System.out.println("Ingreso realizado con éxito.");
            System.out.println(cliente.toString());
        } else {
            System.out.println("La cantidad debe ser positiva.");
        }
    }
}