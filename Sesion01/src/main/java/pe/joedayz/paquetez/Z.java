package pe.joedayz.paquetez;

import pe.joedayz.paquetea.A;



public class Z extends A {

    public void doThings(){
        //NO ES QUE DEBA INSTANCIAR A PARA USAR PROTECTED O PACKAGE PRIVATE

        A a = new A();
        a.m1 = "m1";
        //a.m2 = "m2"; // This line will cause a compilation error because

        Z z = new Z();
        z.m2 = "abc"; //solo se usa por herencia, no por instanciacion de la clase padre

        z.run();

        // COMO PROPIEDAD O ATRIBUTO HEREADO SI PUEDO ACCEDER A ELLA DIRECTAMENTE
        System.out.println("m2: " + m2); // This is valid because m2 is protected and Z is a subclass of A

        run();
    }
}
