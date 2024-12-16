package PracticaExamenMuseo.PracticaExamenMuseo;

public class GestorSala {

    final int maxPersonas=50;
    final int maxPersonasUmbral=35;
    int tUmbral=30;
    int personas;
    int jubilados;


    public synchronized void entrarSala() throws InterruptedException {

        while (personas>=maxPersonas || personas>=maxPersonasUmbral || jubilados>0){
            wait();
        }
        personas++;
        System.out.println("Perosnas Esperando "+personas);

    }
    public synchronized void entrarSalaJubilado() throws InterruptedException {
        while (personas>=maxPersonas || personas>=maxPersonasUmbral || jubilados>0){
            wait();
        }
        jubilados++;
        System.out.println("personas jubiladas esperando " +jubilados+ " personas no jubiladas "+ personas);
    }
    public synchronized void salirSala(Persona tipoPersona){
        if (tipoPersona.equals(PracticaExamenMuseo.PracticaExamenMuseo.tipoPersona.PERSONA)) {
            personas--;
            System.out.println("saliendo persona");
        }
        if (tipoPersona.equals(PracticaExamenMuseo.PracticaExamenMuseo.tipoPersona.JUBILADO)) {
            jubilados--;
            System.out.println("saliendo jubilado");
        }
    }
    public synchronized void notificarTemperatura(){

    }

}
