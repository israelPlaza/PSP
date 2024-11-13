package numeroMasAlto;

public class Main {
    public static void main(String[] args) {
Ring ring=new Ring();
        for (int i=0;i<10;i++){
            new Hilo(i,ring).start();
        }
    }
}
