package pe.joedayz.genericos;

import pe.joedayz.interfaces.Pato;

public class Some {

    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    static void main() {
        Some some = new Some();

        some.setValue("Hola");
        System.out.println(some.getValue());

        some.setValue(new Pato());

        Object value = some.getValue();

        System.out.println(value);


        some.setValue(100);

        String texto = (String) some.getValue();
    }
}