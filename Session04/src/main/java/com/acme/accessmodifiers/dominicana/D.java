package com.acme.accessmodifiers.dominicana;

import com.acme.accessmodifiers.peru.A;

public class D extends A {


    public void bar(){
        System.out.println("m1: " + m1);
        // System.out.println("m2: " + m2); // Error: m2
        //System.out.println("m3: " + m3);
        System.out.println("m4: " + m4); // solo puede acceder a m4 porque es protected y D es subclase de A

        protectedMethod();

        publicMethod();
    }

    public void foo(){
        A a = new A();
        a.m1 = "public";
        // System.out.println("m2: " + a.m2); // Error: m2 has private access in A

        //System.out.println("m3: " + a.m3); // Error: m3 is not public in A; cannot be accessed from outside package
        //System.out.println("m4: " + a.m4); // Error: m4 is not public in A; cannot be accessed from outside package
    }


}
