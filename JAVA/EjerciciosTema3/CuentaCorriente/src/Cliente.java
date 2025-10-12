public class Cliente {
    private String nombre;
    private String apellidos;
    private String dni;
    private float saldo;

    public Cliente(String nombre,String apellidos, String dni,float saldo){
        this.nombre= nombre;
        this.apellidos =apellidos;
        this.dni= dni;
        this.saldo= saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", saldo=" + saldo + "]";
    }

    

}
