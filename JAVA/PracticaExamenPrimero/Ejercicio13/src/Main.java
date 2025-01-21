import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nombre = "";
        int edad = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Alumnos> alumnos = new ArrayList<>();
        ArrayList<Alumnos> mayores = new ArrayList<>();
        ArrayList<Alumnos> menores = new ArrayList<>();

        do {

            System.out.println("Introduce el nombre del alumno: ");
            nombre = sc.next();
            System.out.println("Introduce la edad del alumno: ");
            edad = sc.nextInt();
            alumnos.add(new Alumnos(nombre, edad));
            System.out.println("Introduce * para salir: ");
            nombre = sc.next();


        } while (!nombre.equals("*"));

        for (Alumnos alumno : alumnos) {

            if (alumno.getEdad() > 18) {
                mayores.add(alumno);
            } else {
                menores.add(alumno);
            }
        }

        System.out.println("Alumnos mayores de edad: ");

        for (Alumnos alumno : mayores) {

            System.out.println(alumno.toString());
        }
        System.out.println();
        System.out.println("Alumnos menores de edad: ");
        for (Alumnos alumno : menores) {
            System.out.println(alumno.toString());
        }

    }
}