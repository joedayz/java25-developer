package com.acme.accessmodifiers.peru;

public class A {

    public String m1;
    private String m2;
    String m3;
    protected String m4;


    public A(){

        this.m1 = "public";
        this.m2 = "private";
        this.m3 = "default";
        this.m4 = "protected";
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    void packagePrivateMethod() {
        System.out.println("This is a package-private method.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    public void publicMethod() {
        System.out.println("This is a public method.");
    }
}
