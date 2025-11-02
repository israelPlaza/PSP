public class Vehiculo {
    private String matricula;
    private String etiquetaAmbiental;
    private int minutosEstacionados;
    private boolean tieneAbono;
    private float  importetotal= -1.0f;
    private float  descuento;
    public Vehiculo(){
        this.matricula=matricula;
        this.etiquetaAmbiental=etiquetaAmbiental;
        this.minutosEstacionados=minutosEstacionados;
        this.tieneAbono=tieneAbono;
    }

    public Vehiculo(String matricula,String etiquetaAmbiental,int minutosEstacionados,boolean  tieneAbono){
        this.matricula=matricula;
        this.etiquetaAmbiental=etiquetaAmbiental;
        this.minutosEstacionados=minutosEstacionados;
        this.tieneAbono=tieneAbono;
    }

    @Override
    public String toString() {
        return "Matricula: "+matricula+" etiqueta ambiental: "+etiquetaAmbiental+" minutos estacionados: "+minutosEstacionados+
                " abono: "+tieneAbono+" Precio Total: "+importetotal+"€";
    }

    public void calcularImporte(float tarifaGeneralHora){
        importetotal= (minutosEstacionados/60)*tarifaGeneralHora;

       //para calacular la e tiqueta
        descuento = (etiquetaAmbiental.equals("B")) ? importetotal * 0.10f : (etiquetaAmbiental.equals("C")) ? 
        importetotal * 0.20f : importetotal * 0.50f;
        importetotal=importetotal-descuento;

        //para calcualar el decuneto del abono

        importetotal=(tieneAbono==true)? importetotal - 3.00f:importetotal -0.00f;

    
    }
    
}
