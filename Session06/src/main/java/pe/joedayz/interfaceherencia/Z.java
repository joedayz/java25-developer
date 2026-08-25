package pe.joedayz.interfaceherencia;

public class Z
        extends W
        implements X1, X2{



    @Override
    public void b() {
        System.out.println("b de Z");
    }
}

class Main{
    void main(){
        Z z = new Z();
        z.a();
        z.b();
        z.c(); // tiene prioridad la del hijo
    }
}