package Jarra.Jarrilla1;

public class Ejemplo {
        public static void  main (String argv[]) throws Exception {

            Jarra j1 = new Jarra(7);
            Jarra j2 = new Jarra(4);
            j1.llena();
            System.out.println(j1);
            System.out.println(j2);
            j2.llenaDesde(j1);
            System.out.println(j1);
            System.out.println(j2);
            j2.vacia();
            System.out.println(j1);
            System.out.println(j2);
            j2.llenaDesde(j1);
            System.out.println(j1);
            System.out.println(j2);
        }
}
