package Conexion;

public final class Parametros {

    private String nombre;
    private Object valor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Parametros(String nom, Object val) {
        this.setNombre(nom);
        this.setValor(val);
    }

    public Parametros() {

    }
    


}
