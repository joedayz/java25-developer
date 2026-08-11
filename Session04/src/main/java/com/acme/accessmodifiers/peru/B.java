package com.acme.accessmodifiers.peru;

public class B {

    public void foo(){
        A a = new A();
        a.m1 = "public";
        // System.out.println("m2: " + a.m2); // Error: m2 has private access in A

        a.m3 = "default";
        System.out.println("m3: " + a.m3);

        System.out.println("m4: " + a.m4);

        a.packagePrivateMethod();
        a.protectedMethod();
        a.publicMethod();
    }
}
