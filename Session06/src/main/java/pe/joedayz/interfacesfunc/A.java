package pe.joedayz.interfacesfunc;

@FunctionalInterface
public interface A {

    public void a();  // 1 solo metodo abstracto


    //los 3 de object no cuentan en la suma
    public int hashCode();


    public boolean equals(Object obj) ;


    public String toString() ;
}
