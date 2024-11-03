/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Turnos;

/**
 *
 * @author isra
 */
public class RecursoComun {
    private int turno;
    public RecursoComun(){
        this.turno=0;
    }
    public synchronized void solicitarTurno(int id)throws InterruptedException{
        while (turno!=id) { 
            wait();
            System.out.println("El hilo "+id+" espera su turno");
            Thread.currentThread().sleep(2000);
            turno= 1-turno;
            notifyAll();

        }       
    }


}
