
public class Codigo {
    public static void main(String[] args) throws Exception {
        int codigo=65839522;

        //pasamos de int a string
        String codigoString = String.valueOf(codigo);

        //pasamos el ultimo numero a char y luego a int para utilizrlo de control
        char ultimoChar = codigoString.charAt(7);
        int digitoControlProporcionado = Integer.parseInt(String.valueOf(ultimoChar));

        //hacer las operaciones de resto de numeros
        int suma = 0;
        for (int i = 0; i < 7; i++) {
            char digitoChar = codigoString.charAt(i);
            int digito = Integer.parseInt(String.valueOf(digitoChar));

            if ((i + 1) % 2 != 0) {
                suma += digito * 3;
            } else {
                suma += digito * 1;
            }
        }

        int residuo = suma % 10;
        int digitoControlCalculado;

        if (residuo == 0) {
            digitoControlCalculado = 0;
        } else {
            digitoControlCalculado = 10 - residuo;
        }

        if (digitoControlCalculado == digitoControlProporcionado) {
            System.out.println("El código de barras es CORRECTO.");
        } else {
            System.out.println("El código de barras es INCORRECTO.");
        }

    }
}
