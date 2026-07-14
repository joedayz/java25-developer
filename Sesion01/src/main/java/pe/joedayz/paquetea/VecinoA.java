package pe.joedayz.paquetea;

public class VecinoA {

    public void doThings(){
        A a = new A();
        a.m1 = "m1";

        a.m3 = "m3";
        a.m2 = "m2";


        a.play();
        a.run();
        // a.m4 = "m4"; // This line will cause a compilation error because m4 is private in class A
    }
}
