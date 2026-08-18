package com.acme;

public class ClaseHija extends ClasePadre {


    public ClaseHija(){
        super();
    }

    @Override
    public void saludar() {
        super.saludar();
    }


    static void main() {
        ClaseHija hija = new ClaseHija();
        hija.saludar();
    }
}
