package com.acme.accessmodifiers.usa;

import com.acme.accessmodifiers.peru.A;

public class U {

    public void baz(){
        A a = new A();
        a.m1 = "public";
        // System.out.println("m2: " + a.m2); // Error: m2 has private access in A

        //System.out.println("m3: " + a.m3); // Error: m3 is not public in A; cannot be accessed from outside package

        //a.protectedMethod();

        a.publicMethod();
    }
}
