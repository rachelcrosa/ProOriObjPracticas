package Jarra.Jarrilla1;

public class Jarra{
    private final int capacidad;
    private int contenido;
    public Jarra(int capacidad) throws Exception {
        if(capacidad < 0) throw new RuntimeException("Capacity is below 0");
        this.capacidad = capacidad;
        this.contenido = 0;
    }
    public int capacidad(){
        return capacidad;
    }
    public int contenido(){
        return contenido;
    }
    public void llena(){
        contenido = capacidad;
    }
    public void vacia(){
        contenido = 0;
    }
    public void llenaDesde(Jarra j){
        int toFill = capacidad-contenido;
        if(j.equals(this)) throw new RuntimeException();
        if(j.contenido()<toFill){
            this.contenido += j.contenido();
            j.vacia();
        }else{
            this.contenido = this.capacidad;
            j.contenido -= toFill;
        }

    }
    public String toString(){
        return "J(" + capacidad + "," +  contenido + ")";
    }
}
