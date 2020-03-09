package Jarra.Jarrilla2;

import Jarra.Jarrilla1.Jarra;

public class Mesa {
    private Jarra j1;
    private Jarra j2;
    public Mesa(int c1, int c2) throws Exception {
        this(new Jarra(c1), new  Jarra(c2));
    }
    public Mesa(Jarra j1, Jarra j2){
        if(j1.equals(j2)) throw new RuntimeException();
        this.j1 = j1;
        this.j2 = j2;
    }
    public int capacidad(int sel){
        return sel==1?j1.capacidad():j2.capacidad();
    }
    public int contenido(int sel){
        return sel==1?j1.contenido():j2.contenido();
    }
    public void llena(int sel){
        if(sel==1) j1.llena();
        else j2.llena();
    }
    public void vacia(int sel){
        if(sel==1) j1.vacia();
        else j2.vacia();
    }
    public void llenaDesde(int sel){
        if(sel==1) j1.llenaDesde(j2);
        else j2.llenaDesde(j1);
    }

    @Override
    public String toString() {
        return "Mesa(" + j1 + j2 + ')';
    }
}
