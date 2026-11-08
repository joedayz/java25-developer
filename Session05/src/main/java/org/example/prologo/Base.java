package org.example.prologo;

public class Base {

    static{
        System.out.println("static Base");
    }
    {
        System.out.println("instance Base");
    }

    Base(){
        System.out.println("constructor Base");
    }
}

class Padre extends Base{

    static{
        System.out.println("static Padre");
    }

    int x = imprimirCampo();

    int imprimirCampo(){
        System.out.println("campo Padre");
        return 10;
    }


    {
        System.out.println("instance Padre");
    }

    Padre(){
        System.out.println("Prologo Padre");
        super();
        System.out.println("Epilogo Padre");
    }
}

class Hijo extends Padre {

    static{
        System.out.println("static Hijo");
    }

    int y = imprimirCampo();

    int imprimirCampo(){
        System.out.println("campo Hijo");
        return 20;
    }

    {
        System.out.println("instance Hijo");
    }

    Hijo(int x){
        System.out.println("Prologo Hijo");
        super();
        System.out.println("Epilogo Hijo");
    }
}

class Main{
    static void main() {
        new Hijo(4);
    }
}