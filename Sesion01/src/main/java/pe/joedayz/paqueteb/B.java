package pe.joedayz.paqueteb;

import pe.joedayz.paquetea.A;

public class B {

    C c =  new C();

    public void doThings(){
        A a = new A();
        a.m1 = "m1";

        //a.play();

        //a.m2 = "m2";
        //a.m3 = "m3"; // es una variable package private y vive fuera del paquete
        //a.m4 = "m4"; // This line will cause a compilation error because m4 is private in class A
    }
}
