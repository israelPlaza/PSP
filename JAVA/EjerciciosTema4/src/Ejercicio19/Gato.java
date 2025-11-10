package Ejercicio19;

public class Gato {

    private String nombre;
    private int edad;

  
    public Gato(String nombre, int edad) {
       
        this.setNombre(nombre);
        this.setEdad(edad);
    }

   
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() < 3) {
           
            System.out.println("Error: El nombre debe tener al menos 3 caracteres.");
        } else {
            // Solo si es válido, lo asignamos
            this.nombre = nombre;
        }
    }

    public void setEdad(int edad) {
        if (edad < 0) {
           
            System.out.println("Error: La edad no puede ser negativa.");
        } else {
            
            this.edad = edad;
        }
    }

    public void imprimir() {
        System.out.println("--- Ficha del Gato ---");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad:   " + this.edad);
    }
}