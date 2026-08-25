package pe.joedayz.interfaceherencia;

public interface X1 {
    public default void a(){
        System.out.println("a de X1");
    }
    public default void b(){
        System.out.println("b de X1");
    }
    public default void c(){
        System.out.println("C de X1");
    }

}
