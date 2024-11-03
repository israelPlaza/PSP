/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Turnos;

/**
 *
 * @author isra
 */
public class Main {

    public static void main(String[] args) throws InterruptedException{
        RecursoComun rc;
        Hilo hilo1, hilo2;
    
        rc=new RecursoComun();
        hilo1=new Hilo("Hilo 1", rc, 0);
        hilo2=new Hilo("Hilo 2", rc, 1);
        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();
        System.out.println("Todos los hilos han terminado. Fin del programa.  "  );
    }

}
