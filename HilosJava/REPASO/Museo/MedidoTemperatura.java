package Museo;

import java.util.Scanner;

public class MedidoTemperatura {



    private int temperatura=0;
    private Scanner sc =new Scanner(System.in);

    public void mostrarTemperatura(){
        System.out.println("La temperatura es de " + temperatura+ " grados.");
    }
    public void escribirTemperatura(){
        System.out.println("El sensor de temperatura tiene...");
        temperatura = sc.nextInt();
    }
    public int getTemperatura() {
        return temperatura;
    }

}
