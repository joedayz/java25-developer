package pe.joedayz.interfaceherencia;

public interface X2 extends X1{
    public default void c(){
        System.out.println("C de X2");
    }

}
