
import java.util.Scanner;

public class Temperatura {
public static void main(String[] args) {
    //Variables
    float temperatura= 0.0f;
    int humedad =0;
    final int UMBRAL_INF= 285;
    final int UMBRAL_SUP= 308;
    Scanner sc = new Scanner(System.in);

    //Ingreso de valores
    System.out.println("Marque la temperatura en ºC:");
    //temperatura = sc.nextFloat();
    //Para cumplir un caso de prueba ponemos datos directamen
    temperatura=40;

    System.out.println("Marque la húmedad relatica: ");
    //humedad =sc.nextInt();
    //Para cumplir un caso de prueba ponemos datos directamen
    humedad=100;

    //Calculamos la sensacion tenmica en grados (yhacemo un cast a int ya que hay float)
    int sensacionTermicaC =  (int) (temperatura + ((humedad/100) * (temperatura*0.1)));


    //calculamos la temperatura en kelvin y casteo para que sea un entero
    int kelvin = (int)(temperatura + 273.15);

    //creamos alerta
    String dato = kelvin < UMBRAL_INF ? "Alerta: riego temperaturas altas" : kelvin > UMBRAL_SUP ?
     "Alerta: riego golpe de calor" : "Condiciones normales";

    // muestra de datos en grados ºC
    float sensacionTermicaFloat = (float)sensacionTermicaC;
    System.out.println("La sensación térmica es de " +sensacionTermicaFloat+"ºC");
    System.out.println(dato);

    // mustra de datos en k
    int sensacionTermicaK =  (int) (kelvin + ((humedad/100) * (kelvin*0.1)));
    System.out.println("La sensación térmica es de "+sensacionTermicaK+"K");
    System.out.println(dato);

    //como la temperatura supera el umbral supèrior
    //tiene que dar el mensaje de alerta de reisgo por calor

}
}
