package org.example.prologo2;

class Padre {
    Padre() {
        mostrar();
    }

    void mostrar() {
        System.out.println("Padre");
    }
}

public class Hijo  extends Padre {

     int n;

    Hijo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        super();

    }

    static void main() {
        new Hijo(9);
    }

    @Override
    void mostrar() {
        IO.println("Hijo n= " + n);
    }
}
