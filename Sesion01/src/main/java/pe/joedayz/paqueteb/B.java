package pe.joedayz.paqueteb;

import pe.joedayz.paquetea.A;

public class B {

    public void doThings(){
        A a = new A();
        a.m1 = "m1";

        //a.m4 = "m4"; // This line will cause a compilation error because m4 is private in class A
    }
}
