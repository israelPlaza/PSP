public class Main {
    public static void main(String[] args) {
        int[] primero  = {1, 2, 3, 4, 5};
        int[] segundo = new int[primero.length];


        for (int i = 0; i < primero.length; i++) {
          int x= primero.length -i -1;
          segundo[x] = primero[i];
            System.out.println();
        }
        primero = segundo;
        for (int i = 0; i < segundo.length ; i++) {
            System.out.println(primero[i]);
        }

    }
}